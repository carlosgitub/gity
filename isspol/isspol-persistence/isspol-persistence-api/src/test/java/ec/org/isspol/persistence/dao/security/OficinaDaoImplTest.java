package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.persistence.entities.security.OficinaSucursal;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mauchilan on 21/3/17.
 */
public class OficinaDaoImplTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(HorarioDaoImplTest.class);

    @Override
    protected List<String> springAppContexts() {
        return Arrays.asList("test-entities.xml");
    }

    @Test
    public void getAllOficinaSucursal(){
        OficinaDao oficinaDao = (OficinaDao) getBean("oficinaDao");
        List<OficinaSucursal> oficinaSucursals = oficinaDao.getOficinaSucursal();
        for (OficinaSucursal oficinaSucursal: oficinaSucursals){
            logger.info("Oficina Sucursal: {} - {} - {} - {}", oficinaSucursal.getOficina(), oficinaSucursal.getNombre(), oficinaSucursal.getSucursal(), oficinaSucursal.getSucursalNombre());
        }
        Assert.assertNotNull(oficinaSucursals);
    }

}
