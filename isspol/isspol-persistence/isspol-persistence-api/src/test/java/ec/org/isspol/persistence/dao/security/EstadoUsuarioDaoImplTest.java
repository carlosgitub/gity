package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.persistence.entities.security.EstadoUsuario;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mauchilan on 21/3/17.
 */
public class EstadoUsuarioDaoImplTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(EstadoUsuarioDaoImplTest.class);

    @Override
    protected List<String> springAppContexts() {
        return Arrays.asList("test-entities.xml");
    }

    @Test
    public void getAllEstadoUsuario(){
        EstadoUsuarioDao estadoUsuarioDao = (EstadoUsuarioDao) getBean("estadoUsuarioDao");
        List<EstadoUsuario> estadoUsuarios = estadoUsuarioDao.getAllEstadoUsuario();
        for (EstadoUsuario estadoUsuario: estadoUsuarios){
            logger.info("Estado Usuario {} --> {}", estadoUsuario.getIdEstadoUsuario(), estadoUsuario.getDescripcion());
        }
        Assert.assertNotNull(estadoUsuarios);
    }

}
