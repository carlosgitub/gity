package ec.org.isspol.route.security.service;

import ec.org.isspol.common.IsspolException;
import ec.org.isspol.common.IsspolMessage;

/**
 * Created by mauchilan on 24/3/17.
 */
public interface UsuarioService {

    Object callRemoteService(IsspolMessage message) throws IsspolException;

}
