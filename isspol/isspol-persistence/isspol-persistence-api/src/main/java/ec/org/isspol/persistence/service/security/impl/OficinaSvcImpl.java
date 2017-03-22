package ec.org.isspol.persistence.service.security.impl;

import ec.org.isspol.persistence.dao.security.OficinaDao;
import ec.org.isspol.persistence.entities.security.OficinaSucursal;
import ec.org.isspol.persistence.service.security.OficinaSvc;

import java.util.List;

/**
 * Created by mauchilan on 21/3/17.
 */
public class OficinaSvcImpl implements OficinaSvc {

    private OficinaDao oficinaDao;

    @Override
    public List<OficinaSucursal> getAllOficinaSucursal() {
        return oficinaDao.getAllOficinaSucursal();
    }

    public void setOficinaDao(OficinaDao oficinaDao) {
        this.oficinaDao = oficinaDao;
    }

}
