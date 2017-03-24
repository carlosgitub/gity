package ec.org.isspol.route.security.service.bean;

import ec.org.isspol.common.IsspolException;
import ec.org.isspol.common.IsspolMessage;
import ec.org.isspol.route.security.facade.UsuarioServiceFacade;
import ec.org.isspol.route.security.service.UsuarioService;
import ec.org.isspol.service.pool.IsspolServiceProcesor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mauchilan on 24/3/17.
 */
public class UsuarioServiceBean extends IsspolServiceProcesor implements UsuarioService {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceBean.class);

    private UsuarioServiceFacade usuarioServiceFacade;

    @Override
    public Object callRemoteService(IsspolMessage message) throws IsspolException{
        long startTime = System.currentTimeMillis();
        Object response;
        try {
            this.usuarioServiceFacade = (UsuarioServiceFacade) getServicePool().borrowObject();
            response = getCaller().callRemoteClass(message.getMethod(), this.usuarioServiceFacade, message.getParameters());
            long endTime = System.currentTimeMillis();
            logger.info("Method {} took {} milliseconds", message.getMethod(), String.valueOf(endTime - startTime));
        }catch (Exception e){
            logger.error("ERROR Bean",e);
            throw new IsspolException("ERROR Bean", e);
        }finally {
            try {
                getServicePool().returnObject(this.usuarioServiceFacade);
            } catch (Exception e) {
                logger.error("ERROR Bean",e);
                throw new IsspolException("ERROR Bean", e);
            }
        }
        return response;
    }

    @Override
    public Object createService() {
        return this.usuarioServiceFacade;
    }

    public void setUsuarioServiceFacade(UsuarioServiceFacade usuarioServiceFacade) {
        this.usuarioServiceFacade = usuarioServiceFacade;
    }
}
