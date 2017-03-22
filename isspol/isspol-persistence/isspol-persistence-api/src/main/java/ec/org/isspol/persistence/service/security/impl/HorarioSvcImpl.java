package ec.org.isspol.persistence.service.security.impl;

import ec.org.isspol.persistence.dao.security.HorarioDao;
import ec.org.isspol.persistence.entities.security.Horario;
import ec.org.isspol.persistence.service.security.HorarioSvc;

import java.util.List;

/**
 * Created by mauchilan on 21/3/17.
 */
public class HorarioSvcImpl implements HorarioSvc {

    private HorarioDao horarioDao;

    @Override
    public List<Horario> getAllHorario() {
        return horarioDao.getAllHorario();
    }

    public void setHorarioDao(HorarioDao horarioDao) {
        this.horarioDao = horarioDao;
    }

}
