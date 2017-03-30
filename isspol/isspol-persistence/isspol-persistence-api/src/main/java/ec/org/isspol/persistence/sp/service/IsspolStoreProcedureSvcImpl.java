package ec.org.isspol.persistence.sp.service;

import ec.org.isspol.persistence.sp.IsspolStoreProcedure;
import org.springframework.jdbc.core.SqlParameter;

import javax.sql.DataSource;
import java.util.Map;

/**
 * Created by mauchilan on 29/3/17.
 */
public class IsspolStoreProcedureSvcImpl implements IsspolStoreProcedureSvc {

    private DataSource dataSource;

    @Override
    public <K, V> Map<K, V> executeStoreProcedure(String sql, SqlParameter[] sqlParameters, Map values) {
        IsspolStoreProcedure sp = new IsspolStoreProcedure(dataSource, sql, sqlParameters);
        return (Map<K, V>) sp.execute(values);
    }

    @Override
    public <K, V> Map<K, V> executeStoreProcedure(String sql, SqlParameter[] sqlParameters, Boolean function, Map values) {
        IsspolStoreProcedure sp = new IsspolStoreProcedure(dataSource, sql, sqlParameters, function);
        return (Map<K, V>) sp.execute(values);
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
