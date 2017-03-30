package ec.org.isspol.route.security.facade;

import ec.org.isspol.common.ConstantIsspol;
import ec.org.isspol.persistence.entities.security.*;
import ec.org.isspol.persistence.service.security.EstadoUsuarioSvc;
import ec.org.isspol.persistence.service.security.HorarioSvc;
import ec.org.isspol.persistence.service.security.OficinaSvc;
import ec.org.isspol.persistence.service.security.UsuarioSvc;
import ec.org.isspol.persistence.sp.service.IsspolStoreProcedureSvc;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mauchilan on 22/3/17.
 */
public class UsuarioServiceFacadeImpl implements UsuarioServiceFacade {

    private UsuarioSvc usuarioSvc;
    private EstadoUsuarioSvc estadoUsuarioSvc;
    private OficinaSvc oficinaSvc;
    private HorarioSvc horarioSvc;
    private IsspolStoreProcedureSvc isspolStoreProcedureSvc;

    @Override
    public List<Horario> getAllHorario() {
        return horarioSvc.getAllHorario();
    }

    @Override
    public List<EstadoUsuario> getAllEstadoUsuario() {
        return estadoUsuarioSvc.getAllEstadoUsuario();
    }

    @Override
    public List<OficinaSucursal> getAllOficinaSucursal() {
        return oficinaSvc.getAllOficinaSucursal();
    }

    @Override
    public List<Usuario> getAllUsuario() {
        return usuarioSvc.getAllUsuario();
    }

    @Override
    public List<Usuario> getUsuarioByEstado(Object[] parameters) {
        return usuarioSvc.getUsuarioByEstado(parameters);
    }

    @Override
    public Map<String, Object> getAllCargo() {
        return isspolStoreProcedureSvc.executeStoreProcedure(ConstantIsspol.PROC_DDDW_ESTRUCTURA_ORGANIZACIONAL, null, null);
    }

    @Override
    public Map<String, Object> createUsuario(HashMap<String, Object> values) {
        SqlParameter[] sqlParameters = new SqlParameter[]{
                new SqlParameter(ConstantIsspol.AS_USU_USUARIO, Types.VARCHAR),
                new SqlParameter(ConstantIsspol.AI_OFICINA, Types.INTEGER),
                new SqlParameter(ConstantIsspol.AS_NOMBRE, Types.VARCHAR),
                new SqlParameter(ConstantIsspol.AI_ESTADO, Types.INTEGER),
                new SqlParameter(ConstantIsspol.AS_EMAIL, Types.INTEGER),
                new SqlParameter(ConstantIsspol.AS_IDENTIFICACION, Types.INTEGER),
                new SqlParameter(ConstantIsspol.AB_CUALQUIER_ESTACION, Types.BIT),
                new SqlParameter(ConstantIsspol.AI_ID_HORARIO, Types.INTEGER),
                new SqlParameter(ConstantIsspol.AI_ID_ESTRUCTURA, Types.INTEGER),
                new SqlParameter(ConstantIsspol.Ai_USUARIO_SUPERIOR, Types.INTEGER),
                new SqlParameter(ConstantIsspol.AI_ID_DASHBOARD_INICIO, Types.INTEGER),
                new SqlParameter(ConstantIsspol.AS_USUARIO, Types.VARCHAR),
                new SqlOutParameter(ConstantIsspol.AI_USU_ID, Types.INTEGER),
                new SqlOutParameter(ConstantIsspol.AS_MSJ, Types.VARCHAR)
        };
        return isspolStoreProcedureSvc.executeStoreProcedure(ConstantIsspol.PROC_USUARIO_INSERTAR, sqlParameters, values);
    }

    @Override
    public Map<String, Object> updateUsuario(HashMap<String, Object> values) {
        SqlParameter[] sqlParameters = new SqlParameter[]{
                new SqlParameter(ConstantIsspol.AS_USUARIO, Types.VARCHAR),
                new SqlParameter(ConstantIsspol.AS_OFICINA, Types.INTEGER),
                new SqlParameter(ConstantIsspol.AS_NOMBRE, Types.VARCHAR),
                new SqlParameter(ConstantIsspol.AS_ESTADO, Types.INTEGER),
                new SqlParameter(ConstantIsspol.AS_EMAIL, Types.INTEGER),
                new SqlParameter(ConstantIsspol.AB_CAMBIAR_PWD_PRX_LOGON, Types.INTEGER),
                new SqlParameter(ConstantIsspol.AB_NO_PUEDE_CAMBIAR_PWD, Types.BIT),
                new SqlParameter(ConstantIsspol.AB_PWD_NUNCA_EXPIRA, Types.INTEGER),
                new SqlParameter(ConstantIsspol.AB_BLOQUEADA, Types.INTEGER),
                new SqlParameter(ConstantIsspol.AI_ID, Types.INTEGER),
                new SqlParameter(ConstantIsspol.AS_IDENTIFICACION, Types.INTEGER),
                new SqlParameter(ConstantIsspol.AB_CUALQUIER_ESTACION, Types.VARCHAR),
                new SqlParameter(ConstantIsspol.AI_TIEMPO_INACTIVIDAD, Types.INTEGER),
                new SqlParameter(ConstantIsspol.AS_USUARIO_ACT, Types.VARCHAR),
                new SqlOutParameter(ConstantIsspol.AS_MSJ, Types.VARCHAR),
                new SqlParameter(ConstantIsspol.AI_ID_HORARIO, Types.VARCHAR),
                new SqlParameter(ConstantIsspol.AI_ID_ESTRUCTURA, Types.VARCHAR),
                new SqlParameter(ConstantIsspol.AS_USUARIO_SUPERIOR, Types.VARCHAR),
                new SqlParameter(ConstantIsspol.AI_ID_DASHBOARD_INICIO, Types.VARCHAR)
        };
        return isspolStoreProcedureSvc.executeStoreProcedure(ConstantIsspol.PROC_USUARIO_ACTUALIZAR, sqlParameters, values);
    }

    @Override
    public Map<String, Object> deleteUsuario(HashMap<String, Object> values) {
        return null;
    }

    public void setHorarioSvc(HorarioSvc horarioSvc) {
        this.horarioSvc = horarioSvc;
    }

    /*public void setEstadoUsuarioSvc(EstadoUsuarioSvc estadoUsuarioSvc) {
        this.estadoUsuarioSvc = estadoUsuarioSvc;
    }*/

    public void setOficinaSvc(OficinaSvc oficinaSvc) {
        this.oficinaSvc = oficinaSvc;
    }

    public void setUsuarioSvc(UsuarioSvc usuarioSvc) {
        this.usuarioSvc = usuarioSvc;
    }

    public void setIsspolStoreProcedureSvc(IsspolStoreProcedureSvc isspolStoreProcedureSvc) {
        this.isspolStoreProcedureSvc = isspolStoreProcedureSvc;
    }
}
