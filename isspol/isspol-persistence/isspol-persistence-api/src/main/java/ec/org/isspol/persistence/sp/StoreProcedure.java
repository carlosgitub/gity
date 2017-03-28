package ec.org.isspol.persistence.sp;

import java.util.List;
import java.util.Map;

/**
 * Created by mauchilan on 26/3/17.
 */
public interface StoreProcedure {

    void compile(String storeProcedureName, boolean function, List<Map<String, Object>> parameters);
    Map<String, Object> execute(List<Map<String, Object>> parameters);

}
