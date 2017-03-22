package ec.org.isspol.persistence.service.security.impl;

import ec.org.isspol.persistence.dao.security.UsuarioDao;
import ec.org.isspol.persistence.entities.security.Usuario;
import ec.org.isspol.persistence.service.security.UsuarioSvc;

import java.util.List;

/**
 * Created by mauchilan on 21/3/17.
 */
public class UsuarioSvcImpl implements UsuarioSvc{

    private UsuarioDao usuarioDao;

    @Override
    public void createUsuario(Usuario usuario) {
        usuarioDao.create(usuario);
    }

    @Override
    public Usuario readUsuario(int idUsuario) {
        return usuarioDao.read(idUsuario);
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        usuarioDao.update(usuario);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    public List<Usuario> getAllUsuario() {
        return usuarioDao.getAllUsuario();
    }

    @Override
    public List<Usuario> getUsuarioByEstado(Object[] parameters) {
        return usuarioDao.getUsuarioByEstado(parameters);
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }
}
