package ec.org.isspol.route.client;

import ec.org.isspol.common.ConstantIsspol;
import ec.org.isspol.common.IsspolException;
import ec.org.isspol.common.IsspolMessage;
import ec.org.isspol.persistence.entities.security.EstadoUsuario;
import ec.org.isspol.persistence.entities.security.Horario;
import ec.org.isspol.persistence.entities.security.OficinaSucursal;
import ec.org.isspol.persistence.entities.security.Usuario;
import ec.org.isspol.route.security.service.UsuarioService;
import org.apache.camel.CamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mauchilan on 23/3/17.
 */
public class UsuarioServiceClient {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceClient.class);

    private CamelContext context;
    private UsuarioService usuarioService;

    /**
     *
     * @return
     */
    public List<Horario> getAllHorario(){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        List<Horario> horarios = null;
        try {
            IsspolMessage message = new IsspolMessage();
            message.setMethod(ConstantIsspol.METHOD_GET_ALL_HORARIO);
            message.setParameters(new Object[]{});
            horarios = (List<Horario>) usuarioService.callRemoteService(message);
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(ConstantIsspol.METHOD_GET_ALL_HORARIO), e);
        }
        return horarios;
    }

    public List<EstadoUsuario> getAllEstadoUsuario(){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        List<EstadoUsuario> response = null;
        try {
            IsspolMessage message = new IsspolMessage();
            message.setMethod(ConstantIsspol.METHOD_GET_ESTADO_USUARIO);
            message.setParameters(new Object[]{});
            response = (List<EstadoUsuario>) usuarioService.callRemoteService(message);
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(ConstantIsspol.METHOD_GET_ESTADO_USUARIO), e);
        }
        return response;
    }

    /**
     *
     * @return
     */
    public List<OficinaSucursal> getAllOficinaSucursal(){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        List<OficinaSucursal> oficinaSucursals = null;
        try {
            IsspolMessage message = new IsspolMessage();
            message.setMethod(ConstantIsspol.METHOD_GET_ALL_OFICINA_SUCURSAL);
            message.setParameters(new Object[]{});
            oficinaSucursals = (List<OficinaSucursal>) usuarioService.callRemoteService(message);
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(ConstantIsspol.METHOD_GET_ALL_OFICINA_SUCURSAL), e);
        }
        return oficinaSucursals;
    }

    /**
     *
     * @return
     */
    public List<Usuario> getAllUsuario(){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        List<Usuario> usuarios = null;
        try {
            IsspolMessage message = new IsspolMessage();
            message.setMethod(ConstantIsspol.METHOD_GET_ALL_USUARIO);
            message.setParameters(new Object[]{});
            usuarios = (List<Usuario>) usuarioService.callRemoteService(message);
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(ConstantIsspol.METHOD_GET_ALL_USUARIO), e);
        }
        return usuarios;
    }

    /**
     *
     * @param idEstadoUsuario
     * @return
     */
    public List<Usuario> getUsuarioByEstado(int idEstadoUsuario ){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        List<Usuario> usuarios = null;
        try {
            IsspolMessage message = new IsspolMessage();
            message.setMethod(ConstantIsspol.METHOD_GET_USUARIO_BY_ESTADO);
            message.setParameters(new Object[]{idEstadoUsuario});
            usuarios = (List<Usuario>) usuarioService.callRemoteService(message);
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(ConstantIsspol.METHOD_GET_USUARIO_BY_ESTADO), e);
        }
        return usuarios;
    }

    /**
     *
     * @return
     */
    public Map<String, Object> getAllCargo(){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        try {
            IsspolMessage message = new IsspolMessage();
            message.setMethod(ConstantIsspol.METHOD_GET_ALL_CARGO);
            message.setParameters(new Object[]{});
            response = (Map<String, Object>) usuarioService.callRemoteService(message);
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(ConstantIsspol.METHOD_GET_ALL_CARGO), e);
        }
        return response;
    }

    /**
     *
     * @param values
     * @return
     */
    public Map<String, Object> createUsuario(HashMap<String, Object> values){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        try {
            IsspolMessage message = new IsspolMessage();
            message.setMethod(ConstantIsspol.METHOD_CREATE_USUARIO);
            message.setParameters(new Object[]{values});
            response = (Map<String, Object>) usuarioService.callRemoteService(message);
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(ConstantIsspol.METHOD_CREATE_USUARIO), e);
        }
        return response;
    }

    /**
     *
     * @param values
     * @return
     */
    public Map<String, Object> deleteUsuario(HashMap<String, Object> values){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        try {
            IsspolMessage message = new IsspolMessage();
            message.setMethod(ConstantIsspol.METHOD_DELETE_USUARIO);
            message.setParameters(new Object[]{values});
            response = (Map<String, Object>) usuarioService.callRemoteService(message);
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(ConstantIsspol.METHOD_DELETE_USUARIO), e);
        }
        return response;
    }

    /**
     *
     * @param values
     * @return
     */
    public Map<String, Object> updateUsuario(HashMap<String, Object> values){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        try {
            IsspolMessage message = new IsspolMessage();
            message.setMethod(ConstantIsspol.METHOD_UPDATE_USUARIO);
            message.setParameters(new Object[]{values});
            response = (Map<String, Object>) usuarioService.callRemoteService(message);
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method".concat(ConstantIsspol.METHOD_UPDATE_USUARIO), e);
        }
        return response;
    }

    public void setContext(CamelContext context) {
        this.context = context;
    }
}
