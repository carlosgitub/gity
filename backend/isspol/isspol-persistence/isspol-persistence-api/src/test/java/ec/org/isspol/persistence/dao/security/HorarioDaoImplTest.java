package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.persistence.entities.security.Horario;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mauchilan on 21/3/17.
 */
public class HorarioDaoImplTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(HorarioDaoImplTest.class);

    @Override
    protected List<String> springAppContexts() {
        return Arrays.asList("test-entities.xml");
    }

    @Test
    public void testHorariosGetAll(){
        HorarioDao horarioDao = (HorarioDao) getBean("horarioDao");
        List<Horario> horarios = horarioDao.getAllHorario();
        for (Horario horario: horarios){
            logger.info("Horarios {} --> {}", horario.getIdHorario(), horario.getDescripcion());
        }
        Assert.assertNotNull(horarios);
    }

}
