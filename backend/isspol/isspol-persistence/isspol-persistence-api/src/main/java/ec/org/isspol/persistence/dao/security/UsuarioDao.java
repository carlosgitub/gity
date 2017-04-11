package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.persistence.dao.common.GenericDao;
import ec.org.isspol.persistence.entities.security.Usuario;

import java.util.List;

/**
 * Created by mauchilan on 20/3/17.
 */
public interface UsuarioDao extends GenericDao<Usuario, Integer> {

    List<Usuario> getAllUsuario();
    List<Usuario> getUsuarioByEstado(Object[] parameters);

}
