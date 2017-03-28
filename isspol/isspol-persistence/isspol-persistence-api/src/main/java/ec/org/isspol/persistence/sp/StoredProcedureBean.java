package ec.org.isspol.persistence.sp;

import ec.org.isspol.common.ConstantIsspol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.object.StoredProcedure;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by mauchilan on 23/3/17.
 */
public class StoredProcedureBean extends StoredProcedure implements StoreProcedure{

    private DataSource dataSource;
    private final static String PARAMETER_MODE_IN = "in";
    private final static String PARAMETER_MODE_OUT = "out";
    private final static String PARAMETER_MODE_INOUT = "inout";
    private Set<String> inParameterNames = new HashSet<String>();
    private Map<String, String> inParameterValueFrom = new HashMap<String, String>();
    private static final Logger logger = LoggerFactory.getLogger(StoredProcedureBean.class);

    @Override
    public void compile(String storeProcedureName, boolean function, List<Map<String, Object>> parameters) {
        if (!this.isCompiled()) {
            Class sqlTypesClass;
            try {
                sqlTypesClass = Class.forName(ConstantIsspol.SQL_TYPES);
            } catch (ClassNotFoundException cnfe) {
                logger.error("Cannot find class for sqlTypesClassName: " + ConstantIsspol.SQL_TYPES, cnfe);
                throw new IllegalArgumentException("Cannot find class for sqlTypesClassName: " + ConstantIsspol.SQL_TYPES);
            }
            setDataSource(dataSource);
            setSql(storeProcedureName);
            setFunction(function);
            // Iterate over all of the stored procedure parameters.
            for (Map<String, Object> parameter : parameters) {
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
                        sqlType = (Integer) f.get(sqlTypesClass);
                    } catch (NoSuchFieldException nsfe) {
                        logger.error("Invalid parameter type.", nsfe);
                        throw new IllegalArgumentException("Invalid parameter type.");
                    } catch (IllegalAccessException iae) {
                        logger.error("Unable to derive parameter type.", iae);
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
                    logger.error("Invalid parameter mode.");
                    throw new IllegalArgumentException("Invalid parameter mode.");
                }

                // Handle the IN(OUT) parameters.
                if (PARAMETER_MODE_IN.equalsIgnoreCase(parameterMode) || PARAMETER_MODE_INOUT.equalsIgnoreCase(parameterMode)) {
                    getInParameterNames().add(parameterName);
                    if (parameterValueFrom != null) {
                        getInParameterValueFrom().put(parameterName, parameterValueFrom);
                    }
                }
            }
            compile();
        }
    }

    @Override
    public Map<String, Object> execute(List<Map<String, Object>> parameters) {
        Map<String, Object> inParameters = new HashMap<>();
        inParameters.keySet().retainAll(this.getInParameterNames());
        return this.execute(inParameters);
    }

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Set<String> getInParameterNames() {
        return inParameterNames;
    }

    public Map<String, String> getInParameterValueFrom() {
        return inParameterValueFrom;
    }
}
