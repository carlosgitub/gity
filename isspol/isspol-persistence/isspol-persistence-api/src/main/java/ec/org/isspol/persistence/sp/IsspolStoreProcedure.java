package ec.org.isspol.persistence.sp;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import javax.sql.DataSource;
import java.util.Map;

/**
 * Created by mauchilan on 29/3/17.
 */
public class IsspolStoreProcedure extends StoredProcedure {

    /**
     *
     * @param dataSource
     * @param sql
     * @param sqlParameters
     * @param function
     */
    public IsspolStoreProcedure(DataSource dataSource, String sql, SqlParameter[] sqlParameters, Boolean function){
        setDataSource(dataSource);
        setSql(sql);
        setDeclaredParameters(sqlParameters);
        setFunction(function);
    }

    /**
     *
     * @param dataSource
     * @param sql
     * @param sqlParameters
     */
    public IsspolStoreProcedure(DataSource dataSource, String sql, SqlParameter[] sqlParameters){
        this(dataSource, sql, sqlParameters, true);
    }

    /**
     *
     * @param parameters
     */
    private void setDeclaredParameters(SqlParameter[] parameters) {
        for (int i = 0; i < parameters.length; i++) {
            declareParameter(parameters[i]);
        }
    }

    /**
     *
     * @param valuesParameters
     * @return
     * @throws DataAccessException
     */
    public Map execute(Map valuesParameters) throws DataAccessException {
        compile();
        Map out = super.execute(valuesParameters);
        return out;
    }

}
