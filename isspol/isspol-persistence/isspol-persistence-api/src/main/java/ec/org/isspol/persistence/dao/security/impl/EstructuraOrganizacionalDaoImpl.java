package ec.org.isspol.persistence.dao.security.impl;

import ec.org.isspol.persistence.dao.common.impl.GenericDAOImpl;
import ec.org.isspol.persistence.dao.security.EstructuraOrganizacionalDao;
import ec.org.isspol.persistence.entities.security.EstructuraOrganizacional;

/**
 * Created by mauchilan on 21/3/17.
 */
public class EstructuraOrganizacionalDaoImpl extends GenericDAOImpl<EstructuraOrganizacional, Integer> implements EstructuraOrganizacionalDao {

    public EstructuraOrganizacionalDaoImpl() {
        super(EstructuraOrganizacional.class);
    }
}
