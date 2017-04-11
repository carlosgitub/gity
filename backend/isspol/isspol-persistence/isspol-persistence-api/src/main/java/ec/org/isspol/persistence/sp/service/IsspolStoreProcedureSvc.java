package ec.org.isspol.persistence.sp.service;

import org.springframework.jdbc.core.SqlParameter;

import java.util.Map;

/**
 * Created by mauchilan on 29/3/17.
 */
public interface IsspolStoreProcedureSvc {

    <K, V>Map<K, V> executeStoreProcedure(String sql, SqlParameter[] sqlParameters, Map values);
    <K, V>Map<K, V> executeStoreProcedure(String sql, SqlParameter[] sqlParameters, Boolean function, Map values);

}
