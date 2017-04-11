package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.persistence.dao.common.GenericDao;
import ec.org.isspol.persistence.entities.security.Horario;

import java.util.List;

/**
 * Created by mauchilan on 20/3/17.
 */
public interface HorarioDao extends GenericDao<Horario, Integer> {

    List<Horario> getAllHorario();

}
