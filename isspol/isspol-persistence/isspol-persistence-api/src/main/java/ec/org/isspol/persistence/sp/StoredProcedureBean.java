package ec.org.isspol.persistence.sp;

import org.springframework.jdbc.core.*;
import org.springframework.jdbc.object.StoredProcedure;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by mauchilan on 23/3/17.
 */
public class StoredProcedureBean extends StoredProcedure {

    private final static String PARAMETER_MODE_IN = "in";
    private final static String PARAMETER_MODE_OUT = "out";
    private final static String PARAMETER_MODE_INOUT = "inout";

    private Set<String> inParameterNames = new HashSet<>();
    private Map<String, String> inParameterValueFrom = new HashMap<>();	// key = Param Name, val = value source ("body" | Header Name)

    /**
     * Constructor
     *
     * @param dataSource
     * @param sqlTypesClassName    Typically either "java.sql.Types" or "oracle.jdbc.OracleTypes".
     * @param storedProcedureName
     * @param isFunction
     * @param parameters
     * @throws Exception
     */
    public StoredProcedureBean(final DataSource dataSource,
                               final String sqlTypesClassName,
                               final String storedProcedureName,
                               final boolean isFunction,
                               final List<Map<String, Object>> parameters)  throws IllegalArgumentException {

        super(dataSource, storedProcedureName);

        Class sqlTypesClass;
        try {
            sqlTypesClass = Class.forName((sqlTypesClassName != null) ? sqlTypesClassName : "java.sql.Types");
        } catch (ClassNotFoundException cnfe) {
            throw new IllegalArgumentException("Cannot find class for sqlTypesClassName: " + sqlTypesClassName);
        }

        setFunction(isFunction);

        // Iterate over all of the stored procedure parameters.
        for (Map<String, Object> parameter : parameters ) {
            String parameterName = (String) parameter.get("name");
            String parameterMode = (String) parameter.get("mode");
            String parameterType = (String) parameter.get("type");
            String parameterValueFrom = (String) parameter.get("valueFrom");   // (optional) "body" means value comes from message body; any other text refers to a header name that the value will come from
            RowMapper parameterRowMapper = (RowMapper) parameter.get("rowMapper");   // (optional) for cursor and ResultSet types, specifies the RowMapper to use; defaults to ColumnMapRowMapper

            if (parameterName == null || parameterMode == null || parameterType == null) {
                throw new IllegalArgumentException("Parameter not sufficiently configured.");
            }

            // Map the declared type of each parameter to the SQL-defined type.
            int sqlType;
            if ("ResultSet".equalsIgnoreCase(parameterType)) {
                sqlType = 0;  // not used
            } else {
                try {
                    Field f = sqlTypesClass.getField(parameterType.toUpperCase());
                    sqlType = (Integer)f.get(sqlTypesClass);
                } catch (NoSuchFieldException nsfe) {
                    throw new IllegalArgumentException("Invalid parameter type.");
                } catch (IllegalAccessException iae) {
                    throw new IllegalArgumentException("Unable to derive parameter type.");
                }
            }

            // Declare the correct Spring JDBC SqlParameter class according to the parameter mode.
            if (PARAMETER_MODE_IN.equalsIgnoreCase(parameterMode)) {
                declareParameter(new SqlParameter(parameterName, sqlType));
            } else if (PARAMETER_MODE_INOUT.equalsIgnoreCase(parameterMode)) {
                declareParameter(new SqlInOutParameter(parameterName, sqlType));
            } else if (PARAMETER_MODE_OUT.equalsIgnoreCase(parameterMode)) {
                if ("cursor".equalsIgnoreCase(parameterType)) {
                    declareParameter(new SqlOutParameter(parameterName, sqlType, (parameterRowMapper != null) ? parameterRowMapper : new ColumnMapRowMapper()));
                } else if ("ResultSet".equalsIgnoreCase(parameterType)) {
                    declareParameter(new SqlReturnResultSet(parameterName, (parameterRowMapper != null) ? parameterRowMapper : new ColumnMapRowMapper()));
                } else {
                    declareParameter(new SqlOutParameter(parameterName, sqlType));
                }
            } else {
                throw new IllegalArgumentException("Invalid parameter mode.");
            }

            // Handle the IN(OUT) parameters.
            if (PARAMETER_MODE_IN.equalsIgnoreCase(parameterMode) || PARAMETER_MODE_INOUT.equalsIgnoreCase(parameterMode)) {
                inParameterNames.add(parameterName);
                if (parameterValueFrom != null) {
                    inParameterValueFrom.put(parameterName, parameterValueFrom);
                }
            }
        }

        // Prepare the procedure call using the Spring JDBC StoredProcedure method.
        compile();
    }

    /**
     * This method is used to include only IN and INOUT parameters
     * when the procedure is actually invoked and its results processed.
     *
     * @return Set<String> The set of IN and INOUT parameters
     */
    public Set<String> getInParameterNames() {
        return this.inParameterNames;
    }

    /**
     * This method is used when mapping "alternate" values to IN(OUT) parameters.
     * Normally the value for a given parameter will come from the message header of the same name.
     * This functionality allows the value to come from either the message body or a message header of a different name.
     *
     * @return Map<String, String> key = Param Name, val = value source ("body" | Header Name)
     */
    public Map<String, String>  getInParameterValueFrom() {
        return this.inParameterValueFrom;
    }

}
