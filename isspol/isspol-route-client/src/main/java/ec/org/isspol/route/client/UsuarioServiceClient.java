package ec.org.isspol.route.client;

import ec.org.isspol.persistence.entities.security.EstadoUsuario;
import ec.org.isspol.persistence.entities.security.Horario;
import ec.org.isspol.persistence.entities.security.OficinaSucursal;
import ec.org.isspol.persistence.entities.security.Usuario;
import ec.org.isspol.route.security.UsuarioService;
import org.apache.camel.CamelContext;

import java.util.List;

/**
 * Created by mauchilan on 23/3/17.
 */
public class UsuarioServiceClient {

    private CamelContext context;
    private UsuarioService usuarioService;

    public UsuarioServiceClient(){
        usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
    }

    /*public List<Horario> getAllHorario(){
        return usuarioService.getAllHorario();
    }*/

    /*public List<EstadoUsuario> getAllEstadoUsuario(){
        return usuarioService.getAllEstadoUsuario();
    }*/

    public List<OficinaSucursal> getAllOficinaSucursal(){
        return usuarioService.getAllOficinaSucursal();
    }

    /*public List<Usuario> getAllUsuario(){
        return usuarioService.getAllUsuario();
    }

    public List<Usuario> getUsuarioByEstado(Object[] parameters){
        return usuarioService.getUsuarioByEstado(parameters);
    }*/

    public void setContext(CamelContext context) {
        this.context = context;
    }
}
