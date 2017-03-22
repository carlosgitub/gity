package ec.org.isspol.persistence.dao.common;

import java.io.Serializable;

/**
 * Created by mauchilan on 20/3/17.
 */
public interface GenericDao<T, PK extends Serializable>{

    void create(T entity);
    T read (PK id);
    void update(T entity);
    void delete(T entity);

}
