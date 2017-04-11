package ec.org.isspol.route.client;

import ec.org.isspol.common.ConstantIsspol;
import ec.org.isspol.common.IsspolException;
import ec.org.isspol.common.IsspolMessage;
import ec.org.isspol.persistence.entities.security.OficinaSucursal;
import ec.org.isspol.route.security.service.UsuarioService;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mauchilan on 23/3/17.
 */
public class UsuarioServiceClientTest extends CamelSpringTestSupport {

    private static final Logger LOG = LoggerFactory.getLogger(UsuarioServiceClientTest.class);

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("route-client-test.xml");
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

    @Test
    @Ignore
    public void testSPCargo() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("Calling SP Seguridad.ProcDddwEstructuraOrganizacional");
        IsspolMessage message = new IsspolMessage();
        message.setMethod(ConstantIsspol.METHOD_GET_ALL_CARGO);
        message.setParameters(new Object[]{});
        Map<String, Object> response = (Map<String, Object>) usuarioService.callRemoteService(message);
        LOG.info("Response {}", response);
        for (Map.Entry<String, Object> objectEntry : response.entrySet()) {
            LOG.info("{} --> {} ", objectEntry.getKey(), objectEntry.getValue());
        }
        List<HashMap> rows = (List) response.get("#result-set-1");
        for (HashMap  row : rows) {
            LOG.info("descripcion: {}", row.get("descripcion"));
            LOG.info("id_estructura: {}", row.get("id_estructura"));
            LOG.info("Icono: {}", row.get("Icono"));
            LOG.info("Nivel: {}", row.get("Nivel"));
            LOG.info("orden_arbol: {}", row.get("orden_arbol"));
        }
    }

    /**
     * @AS_USUARIO VARCHAR(15),
     * @AS_OFICINA CHAR(4),
     * @AS_NOMBRE VARCHAR(30),
     * @AS_ESTADO CHAR(1),
     * @AS_EMAIL VARCHAR(100),
     * @AB_CAMBIAR_PWD_PRX_LOGON BIT,
     * @AB_NO_PUEDE_CAMBIAR_PWD BIT,
     * @AB_PWD_NUNCA_EXPIRA BIT,
     * @AB_BLOQUEADA BIT,
     * @AI_ID INT,
     * @AS_IDENTIFICACION VARCHAR(15),
     * @AB_CUALQUIER_ESTACION BIT,
     * @AI_TIEMPO_INACTIVIDAD INT,
     * @AS_USUARIO_ACT VARCHAR(15),
     * @AS_MSJ VARCHAR(100) OUTPUT,
     * @AI_ID_HORARIO INT,
     * @AI_ID_ESTRUCTURA INT,
     * @AS_USUARIO_SUPERIOR VARCHAR(15),
     * @AI_ID_DASHBOARD_INICIO INT
     * @throws IsspolException
     */
    @Test
    @Ignore
    public void testUpdateUserSP() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        LOG.info("Calling SP Seguridad.ProcUsuarioActualizar");
        Map<String, Object> in = new HashMap();
        in.put(ConstantIsspol.AS_USUARIO, "candresc");
        in.put(ConstantIsspol.AS_OFICINA, "1001");
        in.put(ConstantIsspol.AS_NOMBRE, "Carlos A Cordova L");
        in.put(ConstantIsspol.AS_ESTADO, "A");
        in.put(ConstantIsspol.AS_EMAIL, "candresc@prueba.com.ec");
        in.put(ConstantIsspol.AB_CAMBIAR_PWD_PRX_LOGON, Boolean.FALSE);
        in.put(ConstantIsspol.AB_NO_PUEDE_CAMBIAR_PWD, Boolean.FALSE);
        in.put(ConstantIsspol.AB_PWD_NUNCA_EXPIRA, Boolean.TRUE);
        in.put(ConstantIsspol.AB_BLOQUEADA, Boolean.FALSE);
        in.put(ConstantIsspol.AI_ID, 12);
        in.put(ConstantIsspol.AS_IDENTIFICACION, "1001514866");
        in.put(ConstantIsspol.AB_CUALQUIER_ESTACION, Boolean.TRUE);
        in.put(ConstantIsspol.AI_TIEMPO_INACTIVIDAD, 60000);
        in.put(ConstantIsspol.AS_USUARIO_ACT, "ADMIN");
        in.put(ConstantIsspol.AI_ID_HORARIO, 1);
        in.put(ConstantIsspol.AI_ID_ESTRUCTURA, 3);
        in.put(ConstantIsspol.AS_USUARIO_SUPERIOR, null);
        in.put(ConstantIsspol.AI_ID_DASHBOARD_INICIO, 1);
        IsspolMessage message = new IsspolMessage();
        message.setMethod(ConstantIsspol.METHOD_UPDATE_USUARIO);
        message.setParameters(new Object[]{in});
        Map<String, Object> response = (Map<String, Object>) usuarioService.callRemoteService(message);
        LOG.info("Response {}", response);
    }
}
