package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.persistence.dao.common.GenericDao;
import ec.org.isspol.persistence.entities.security.EstadoUsuario;

import java.util.List;

/**
 * Created by mauchilan on 20/3/17.
 */
public interface EstadoUsuarioDao extends GenericDao<EstadoUsuario, Integer> {

    List<EstadoUsuario> getAllEstadoUsuario();

}
