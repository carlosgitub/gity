package ec.org.isspol.persistence.service.security.impl;

import ec.org.isspol.persistence.dao.security.EstadoUsuarioDao;
import ec.org.isspol.persistence.entities.security.EstadoUsuario;
import ec.org.isspol.persistence.service.security.EstadoUsuarioSvc;

import java.util.List;

/**
 * Created by mauchilan on 21/3/17.
 */
public class EstadoUsuarioSvcImpl implements EstadoUsuarioSvc {

    private EstadoUsuarioDao estadoUsuarioDao;

    @Override
    public List<EstadoUsuario> getAllEstadoUsuario() {
        return estadoUsuarioDao.getAllEstadoUsuario();
    }

    public void setEstadoUsuario(EstadoUsuarioDao estadoUsuarioDao) {
        this.estadoUsuarioDao = estadoUsuarioDao;
    }
}
