package ec.org.isspol.persistence.dao.common.impl;

import ec.org.isspol.persistence.dao.common.GenericDao;
import ec.org.isspol.persistence.dao.security.impl.AbstractJPADao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mauchilan on 20/3/17.
 */
public class GenericDAOImpl <T, PK extends Serializable> implements GenericDao<T, PK> {

    protected EntityManager entityManager;

    private Class<T> type;

    public GenericDAOImpl(Class<T> type) {
        this.type = type;
    }

    public void create(T entity) {
        entityManager.persist(entity);
        entityManager.flush();
    }

    public T read(PK id) {
        return entityManager.find(type, id);
    }

    public void update(T entity) {
        entityManager.merge(entity);
        entityManager.flush();
    }

    public void delete(T entity) {
        entityManager.remove(entity);
        entityManager.flush();
    }

    public static <T> List<T> map(Class<T> type, List<Object[]> records){
        List<T> result = new LinkedList<>();
        for(Object[] record : records){
            result.add(map(type, record));
        }
        return result;
    }

    public static <T> List<T> getResultList(Query query, Class<T> type){
        @SuppressWarnings("unchecked")
        List<Object[]> records = query.getResultList();
        return map(type, records);
    }

    public static <T> T map(Class<T> type, Object[] tuple){
        List<Class<?>> tupleTypes = new ArrayList<>();
        for(Object field : tuple){
            tupleTypes.add(field.getClass());
        }
        try {
            Constructor<T> ctor = type.getConstructor(tupleTypes.toArray(new Class<?>[tuple.length]));
            return ctor.newInstance(tuple);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
