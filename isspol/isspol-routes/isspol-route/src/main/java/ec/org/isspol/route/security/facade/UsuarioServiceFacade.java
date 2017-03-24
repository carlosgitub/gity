package ec.org.isspol.route.security.facade;

import ec.org.isspol.persistence.entities.security.EstadoUsuario;
import ec.org.isspol.persistence.entities.security.Horario;
import ec.org.isspol.persistence.entities.security.OficinaSucursal;
import ec.org.isspol.persistence.entities.security.Usuario;

import java.util.List;

/**
 * Created by mauchilan on 22/3/17.
 */
public interface UsuarioServiceFacade {

    List<Horario> getAllHorario();
    //List<EstadoUsuario> getAllEstadoUsuario();
    List<OficinaSucursal> getAllOficinaSucursal();
    List<Usuario> getAllUsuario();
    List<Usuario> getUsuarioByEstado(Object[] parameters);

}
