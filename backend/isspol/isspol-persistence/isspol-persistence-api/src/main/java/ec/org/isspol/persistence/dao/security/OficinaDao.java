package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.persistence.dao.common.GenericDao;
import ec.org.isspol.persistence.entities.security.Oficina;
import ec.org.isspol.persistence.entities.security.OficinaSucursal;

import java.util.List;

/**
 * Created by mauchilan on 20/3/17.
 */
public interface OficinaDao extends GenericDao<Oficina, Integer> {

    List<OficinaSucursal> getAllOficinaSucursal();

}
