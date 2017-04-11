package ec.org.isspol.persistence.dao.security.impl;

import ec.org.isspol.persistence.dao.security.EstadoUsuarioDao;
import ec.org.isspol.persistence.dao.common.impl.GenericDAOImpl;
import ec.org.isspol.persistence.entities.security.EstadoUsuario;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by mauchilan on 20/3/17.
 */
public class EstadoUsuarioDaoImpl extends GenericDAOImpl<EstadoUsuario, Integer> implements EstadoUsuarioDao{

    public EstadoUsuarioDaoImpl(){
        super(EstadoUsuario.class);
    }

    public List<EstadoUsuario> getAllEstadoUsuario() {
        Query query  = entityManager.createNamedQuery("EstadoUsuario.findAllEstadoUsuario");
        List<EstadoUsuario> estadoUsuario = query.getResultList();
        return estadoUsuario;
    }
}
