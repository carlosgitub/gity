package ec.org.isspol.route.client;

import ec.org.isspol.common.ConstantIsspol;
import ec.org.isspol.common.IsspolException;
import ec.org.isspol.common.IsspolMessage;
import ec.org.isspol.persistence.entities.security.OficinaSucursal;
import ec.org.isspol.route.security.service.UsuarioService;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by mauchilan on 23/3/17.
 */
public class UsuarioServiceClientTest extends CamelSpringTestSupport {

    private static final Logger LOG = LoggerFactory.getLogger(UsuarioServiceClientTest.class);

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("META-INF/spring/route-client.xml");
    }

    @Test
    @Ignore
    public void testCliente() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("Calling Oficina Sucursal");
        IsspolMessage message = new IsspolMessage();
        message.setMethod(ConstantIsspol.METHOD_GET_ALL_OFICINA_SUCURSAL);
        message.setParameters(new Object[]{});
        List<OficinaSucursal> oficinaSucursals = (List<OficinaSucursal>) usuarioService.callRemoteService(message);
        for (OficinaSucursal oficinaSucursal: oficinaSucursals){
            LOG.info("Oficina Sucursal: {} {}", oficinaSucursal.getOficina(), oficinaSucursal.getNombre());
        }
    }
}
