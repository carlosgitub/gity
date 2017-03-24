package ec.org.isspol.route.security;

import ec.org.isspol.persistence.entities.security.*;
import ec.org.isspol.persistence.service.security.EstadoUsuarioSvc;
import ec.org.isspol.persistence.service.security.HorarioSvc;
import ec.org.isspol.persistence.service.security.OficinaSvc;
import ec.org.isspol.persistence.service.security.UsuarioSvc;

import java.util.List;

/**
 * Created by mauchilan on 22/3/17.
 */
public class UsuarioServiceImpl implements UsuarioService{

    //private HorarioSvc horarioSvc;
    //private EstadoUsuarioSvc estadoUsuarioSvc;
    private OficinaSvc oficinaSvc;
    //private UsuarioSvc usuarioSvc;

    /*@Override
    public List<Horario> getAllHorario() {
        return horarioSvc.getAllHorario();
    }*/

    /*@Override
    public List<EstadoUsuario> getAllEstadoUsuario() {
        return estadoUsuarioSvc.getAllEstadoUsuario();
    }*/

    @Override
    public List<OficinaSucursal> getAllOficinaSucursal() {
        return oficinaSvc.getAllOficinaSucursal();
    }

    /*@Override
    public List<Usuario> getAllUsuario() {
        return usuarioSvc.getAllUsuario();
    }

    @Override
    public List<Usuario> getUsuarioByEstado(Object[] parameters) {
        return usuarioSvc.getUsuarioByEstado(parameters);
    }

    public void setHorarioSvc(HorarioSvc horarioSvc) {
        this.horarioSvc = horarioSvc;
    }*/

    /*public void setEstadoUsuarioSvc(EstadoUsuarioSvc estadoUsuarioSvc) {
        this.estadoUsuarioSvc = estadoUsuarioSvc;
    }*/

    public void setOficinaSvc(OficinaSvc oficinaSvc) {
        this.oficinaSvc = oficinaSvc;
    }

    /*public void setUsuarioSvc(UsuarioSvc usuarioSvc) {
        this.usuarioSvc = usuarioSvc;
    }*/
}
