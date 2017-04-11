package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.persistence.entities.security.EstadoUsuario;
import ec.org.isspol.persistence.entities.security.EstructuraOrganizacional;
import ec.org.isspol.persistence.entities.security.Horario;
import ec.org.isspol.persistence.entities.security.Usuario;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mauchilan on 21/3/17.
 */
public class UsuarioDaoImplTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioDaoImplTest.class);

    @Override
    protected List<String> springAppContexts() {
        return Arrays.asList("test-entities.xml");
    }

    @Test
    public void testCrudUsuario(){
        UsuarioDao usuarioDao = (UsuarioDao) getBean("usuarioDao");
        EstadoUsuarioDao estadoUsuarioDao = (EstadoUsuarioDao) getBean("estadoUsuarioDao");
        HorarioDao horarioDao = (HorarioDao) getBean("horarioDao");
        EstructuraOrganizacionalDao estructuraOrganizacionalDao = (EstructuraOrganizacionalDao) getBean("estructuraOrganizacionalDao");
        Usuario usuario = new Usuario();
        usuario.setUsuario("test");
        usuario.setNombre("Testing");
        EstadoUsuario estadoUsuario = estadoUsuarioDao.read(1);
        usuario.setEstadoUsuarioByIdEstadoUsuario(estadoUsuario);
        Horario horario = horarioDao.read(1);
        usuario.setHorarioByIdHorario(horario);
        EstructuraOrganizacional estructuraOrganizacional = estructuraOrganizacionalDao.read(3);
        usuario.setEstructuraOrganizacionalByIdEstructura(estructuraOrganizacional);
        logger.info("Creating user {}", usuario.getNombre());
        usuarioDao.create(usuario);
        usuario = usuarioDao.read(usuario.getIdUsuario());
        logger.info("Reading user {}", usuario.getNombre());
        usuario.setEmail("correo@correo.com");
        logger.info("Updating user {} with value {}", usuario.getNombre(), usuario.getEmail());
        usuarioDao.update(usuario);
        logger.info("Deleting user {}", usuario.getNombre());
        usuarioDao.delete(usuario);
    }

    @Test
    public void testGetAllUsuario(){
        UsuarioDao usuarioDao = (UsuarioDao) getBean("usuarioDao");
        List<Usuario> usuarios = usuarioDao.getAllUsuario();
        for (Usuario usuario: usuarios){
            logger.info("User: {} {}", usuario.getIdUsuario(), usuario.getNombre());
        }
        Assert.assertNotNull(usuarios);
    }

    @Test
    public void testGetByEstadoUsuario(){
        UsuarioDao usuarioDao = (UsuarioDao) getBean("usuarioDao");
        List<Usuario> usuarios = usuarioDao.getUsuarioByEstado(new Object[]{1});
        for (Usuario usuario: usuarios){
            logger.info("User Estado: {} {}", usuario.getIdUsuario(), usuario.getNombre());
        }
        Assert.assertNotNull(usuarios);
    }

}
