package ec.org.isspol.persistence.dao.security.impl;

import ec.org.isspol.persistence.dao.security.HorarioDao;
import ec.org.isspol.persistence.dao.common.impl.GenericDAOImpl;
import ec.org.isspol.persistence.entities.security.Horario;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by mauchilan on 20/3/17.
 */
public class HorarioDaoImpl extends GenericDAOImpl<Horario, Integer> implements HorarioDao {

    public HorarioDaoImpl(){
        super(Horario.class);
    }

    public List<Horario> getAllHorario() {
        Query query = em.createNamedQuery("Horario.findAllHorario");
        List<Horario> horarios = query.getResultList();
        return horarios;
    }
}
