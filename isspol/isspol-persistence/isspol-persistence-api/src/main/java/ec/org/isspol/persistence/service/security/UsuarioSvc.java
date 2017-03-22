package ec.org.isspol.persistence.service.security;

import ec.org.isspol.persistence.entities.security.Usuario;

import java.util.List;

/**
 * Created by mauchilan on 21/3/17.
 */
public interface UsuarioSvc {

    void createUsuario(Usuario usuario);
    Usuario readUsuario(int idUsuario);
    void updateUsuario(Usuario usuario);
    void deleteUsuario(Usuario usuario);
    List<Usuario> getAllUsuario();
    List<Usuario> getUsuarioByEstado(Object[] parameters);

}
