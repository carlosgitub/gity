package ec.org.isspol.route.security.facade;

import ec.org.isspol.persistence.entities.security.EstadoUsuario;
import ec.org.isspol.persistence.entities.security.Horario;
import ec.org.isspol.persistence.entities.security.OficinaSucursal;
import ec.org.isspol.persistence.entities.security.Usuario;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mauchilan on 22/3/17.
 */
public interface UsuarioServiceFacade {

    List<Horario> getAllHorario();
    List<EstadoUsuario> getAllEstadoUsuario();
    List<OficinaSucursal> getAllOficinaSucursal();
    List<Usuario> getAllUsuario();
    List<Usuario> getUsuarioByEstado(Object[] parameters);
    Map<String, Object> getAllCargo();
    Map<String, Object> createUsuario(HashMap<String, Object> values);
    Map<String, Object> updateUsuario(HashMap<String, Object> values);
    Map<String, Object> deleteUsuario(HashMap<String, Object> values);

}
