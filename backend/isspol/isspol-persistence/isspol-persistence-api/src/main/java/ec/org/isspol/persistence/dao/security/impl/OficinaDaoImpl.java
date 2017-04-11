package ec.org.isspol.persistence.dao.security.impl;

import ec.org.isspol.persistence.dao.security.OficinaDao;
import ec.org.isspol.persistence.dao.common.impl.GenericDAOImpl;
import ec.org.isspol.persistence.entities.security.Oficina;
import ec.org.isspol.persistence.entities.security.OficinaSucursal;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by mauchilan on 20/3/17.
 */
public class OficinaDaoImpl extends GenericDAOImpl<Oficina, Integer> implements OficinaDao {

    public OficinaDaoImpl(){
        super(Oficina.class);
    }

    @Override
    public List<OficinaSucursal> getAllOficinaSucursal() {
        Query query = entityManager.createNativeQuery("select oficina.oficina, oficina.nombre, sucursal.sucursal, sucursal.nombre as sucursalNombre\n" +
                "from seguridad.oficina join seguridad.sucursal on oficina.idsucursal=sucursal.idsucursal");
        List<OficinaSucursal> oficinaSucursals = getResultList(query, OficinaSucursal.class);
        return oficinaSucursals;
    }
}
