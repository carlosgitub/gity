package ec.org.isspol.web.seguridades;

import ec.org.isspol.persistence.entities.security.EstadoUsuario;
import ec.org.isspol.persistence.entities.security.Horario;
import ec.org.isspol.persistence.entities.security.OficinaSucursal;
import ec.org.isspol.persistence.entities.security.Usuario;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by santiago.yacelga on 29/03/2017.
 */
public class UsuarioDWR implements Serializable {


    public Usuario guardar(Usuario usuario){
        usuario.setNombre("Hola soy un nuevo usuario");
        return usuario;
    }

    public List<Horario> obtenerHorarios  ()throws  Exception{
       /* UsuarioServiceClient client = (UsuarioServiceClient) ApplicartionContext.getBean("usuarioServiceClient");
        List<Horario> lstHorarios = client.getAllHorario();*/

        return null;
    }

    public Map<String, Object> obtenerCargos(){
    /*    UsuarioServiceClient cargos = (UsuarioServiceClient) ApplicartionContext.getBean("usuarioServiceClient");
        Map<String, Object> mapCargos = cargos.getAllCargo();*/
        return null;
    }

    public List<EstadoUsuario> obtenerEstados (){
       /* UsuarioServiceClient client = (UsuarioServiceClient) ApplicartionContext.getBean("usuarioServiceClient");
        List<EstadoUsuario> lstEstadosUsuario = client.getAllEstadoUsuario();*/
        return null;
    }

    public List<OficinaSucursal> obtenerOficinasSucursales(){
       /* UsuarioServiceClient client = (UsuarioServiceClient) ApplicartionContext.getBean("usuarioServiceClient");
        List<OficinaSucursal> lstOficinasSucursal = client.getAllOficinaSucursal();*/
        return null;
    }

    public Map<String, Object> insertarUsuario(HashMap<String, Object> values){
   /*     UsuarioServiceClient client= (UsuarioServiceClient) ApplicartionContext.getBean("usuarioServiceClient");
        HashMap<String, Object> in = new HashMap();
        in.put(ConstantIsspol.AS_USU_USUARIO, "candresc2");
        in.put(ConstantIsspol.AI_OFICINA, 4);
        in.put(ConstantIsspol.AS_NOMBRE, "Carlos A Cordova L");
        in.put(ConstantIsspol.AI_ESTADO, 1);
        in.put(ConstantIsspol.AS_EMAIL, "candresc@prueba.com.ec");
//        in.put(ConstantIsspol.AB_CAMBIAR_PWD_PRX_LOGON, Boolean.FALSE);
//        in.put(ConstantIsspol.AB_NO_PUEDE_CAMBIAR_PWD, Boolean.FALSE);
//        in.put(ConstantIsspol.AB_PWD_NUNCA_EXPIRA, Boolean.TRUE);
//        in.put(ConstantIsspol.AB_BLOQUEADA, Boolean.FALSE);
////        in.put(ConstantIsspol.AI_ID, 17);
        in.put(ConstantIsspol.AS_IDENTIFICACION, "1721737243");
        in.put(ConstantIsspol.AB_CUALQUIER_ESTACION, Boolean.TRUE);
//        in.put(ConstantIsspol.AI_TIEMPO_INACTIVIDAD, 60000);
//        in.put(ConstantIsspol.AS_USUARIO_ACT, "ADMIN");
        in.put(ConstantIsspol.AI_ID_HORARIO, 1);
        in.put(ConstantIsspol.AI_ID_ESTRUCTURA, 3);
        in.put(ConstantIsspol.Ai_USUARIO_SUPERIOR, null);
        in.put(ConstantIsspol.AI_ID_DASHBOARD_INICIO, 1);
        in.put(ConstantIsspol.AS_USUARIO, "candresc2");
        System.out.println("por insertar");
        Map<String, Object>resultado=client.createUsuario(in);
        if(resultado!=null)
            for(Map.Entry<String,Object>objecto:resultado.entrySet()){
                System.out.println(objecto.getKey()+"/"+objecto.getValue());
            }*/
        return null;
    }

    public Map<String, Object> updateUserSP(HashMap<String, Object> values){
        /*UsuarioServiceClient usuarioService = (UsuarioServiceClient) ApplicartionContext.getBean("usuarioServiceClient");
        HashMap<String, Object> in = new HashMap();
        in.put(ConstantIsspol.AS_USUARIO, "candresc1");
        in.put(ConstantIsspol.AS_OFICINA, "1001");
        in.put(ConstantIsspol.AS_NOMBRE, "Andres F");
        in.put(ConstantIsspol.AS_ESTADO, "A");
        in.put(ConstantIsspol.AS_EMAIL, "candresc@prueba.com.ec");
        in.put(ConstantIsspol.AB_CAMBIAR_PWD_PRX_LOGON, Boolean.FALSE);
        in.put(ConstantIsspol.AB_NO_PUEDE_CAMBIAR_PWD, Boolean.FALSE);
        in.put(ConstantIsspol.AB_PWD_NUNCA_EXPIRA, Boolean.TRUE);
        in.put(ConstantIsspol.AB_BLOQUEADA, Boolean.FALSE);
        in.put(ConstantIsspol.AI_ID, 26);
        in.put(ConstantIsspol.AS_IDENTIFICACION, "1001514866");
        in.put(ConstantIsspol.AB_CUALQUIER_ESTACION, Boolean.TRUE);
        in.put(ConstantIsspol.AI_TIEMPO_INACTIVIDAD, 60000);
        in.put(ConstantIsspol.AS_USUARIO_ACT, "ADMIN");
        in.put(ConstantIsspol.AI_ID_HORARIO, 1);
        in.put(ConstantIsspol.AI_ID_ESTRUCTURA, 3);
        in.put(ConstantIsspol.AS_USUARIO_SUPERIOR, null);
        in.put(ConstantIsspol.AI_ID_DASHBOARD_INICIO, 1);
        System.out.println("ejecucion");
        Map<String, Object>resultado=usuarioService.updateUsuario(in);*/
        return null;
    }
}
