package ec.org.isspol.persistence.dao.security.impl;

import ec.org.isspol.persistence.dao.security.UsuarioDao;
import ec.org.isspol.persistence.dao.common.impl.GenericDAOImpl;
import ec.org.isspol.persistence.entities.security.Usuario;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by mauchilan on 20/3/17.
 */
public class UsuarioDaoImpl extends GenericDAOImpl<Usuario, Integer> implements UsuarioDao {

    public UsuarioDaoImpl(){
        super(Usuario.class);
    }

    @Override
    public List<Usuario> getAllUsuario() {
        Query query = em.createNamedQuery("Usuario.findAllUsuario");
        List<Usuario> usuarios = query.getResultList();
        return usuarios;
    }

    public List<Usuario> getUsuarioByEstado(Object[] parameters) {
        Query query = em.createNamedQuery("Usuario.findUsuarioByIdEstadoUsuario");
        for (int i = 0; i < parameters.length; i++)
            query.setParameter(i + 1, parameters[i]);
        List<Usuario> usuarios = query.getResultList();
        return usuarios;
    }
}
