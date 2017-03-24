package ec.org.isspol.persistence.entities.security;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by mauchilan on 20/3/17.
 */
@Entity
public class Estacion implements Serializable {
    private int idEstacion;
    private String hostname;
    private String ip;
    private String descripcion;
    private String ubicacion;
    private String creacionUsuario;
    private Timestamp creacionFecha;
    private String modificaUsuario;
    private Timestamp modificaFecha;
    private Collection<EstacionUsuario> estacionUsuariosByIdEstacion;
    private Collection<ImpEstacion> impEstacionsByIdEstacion;

    @Id
    @Column(name = "IdEstacion", nullable = false)
    public int getIdEstacion() {
        return idEstacion;
    }

    public void setIdEstacion(int idEstacion) {
        this.idEstacion = idEstacion;
    }

    @Basic
    @Column(name = "Hostname", nullable = false, length = 50)
    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    @Basic
    @Column(name = "Ip", nullable = true, length = 15)
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Basic
    @Column(name = "Descripcion", nullable = true, length = 50)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "Ubicacion", nullable = true, length = 50)
    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Basic
    @Column(name = "CreacionUsuario", nullable = true, length = 15)
    public String getCreacionUsuario() {
        return creacionUsuario;
    }

    public void setCreacionUsuario(String creacionUsuario) {
        this.creacionUsuario = creacionUsuario;
    }

    @Basic
    @Column(name = "CreacionFecha", nullable = true)
    public Timestamp getCreacionFecha() {
        return creacionFecha;
    }

    public void setCreacionFecha(Timestamp creacionFecha) {
        this.creacionFecha = creacionFecha;
    }

    @Basic
    @Column(name = "ModificaUsuario", nullable = true, length = 15)
    public String getModificaUsuario() {
        return modificaUsuario;
    }

    public void setModificaUsuario(String modificaUsuario) {
        this.modificaUsuario = modificaUsuario;
    }

    @Basic
    @Column(name = "ModificaFecha", nullable = true)
    public Timestamp getModificaFecha() {
        return modificaFecha;
    }

    public void setModificaFecha(Timestamp modificaFecha) {
        this.modificaFecha = modificaFecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estacion estacion = (Estacion) o;

        if (idEstacion != estacion.idEstacion) return false;
        if (hostname != null ? !hostname.equals(estacion.hostname) : estacion.hostname != null) return false;
        if (ip != null ? !ip.equals(estacion.ip) : estacion.ip != null) return false;
        if (descripcion != null ? !descripcion.equals(estacion.descripcion) : estacion.descripcion != null)
            return false;
        if (ubicacion != null ? !ubicacion.equals(estacion.ubicacion) : estacion.ubicacion != null) return false;
        if (creacionUsuario != null ? !creacionUsuario.equals(estacion.creacionUsuario) : estacion.creacionUsuario != null)
            return false;
        if (creacionFecha != null ? !creacionFecha.equals(estacion.creacionFecha) : estacion.creacionFecha != null)
            return false;
        if (modificaUsuario != null ? !modificaUsuario.equals(estacion.modificaUsuario) : estacion.modificaUsuario != null)
            return false;
        if (modificaFecha != null ? !modificaFecha.equals(estacion.modificaFecha) : estacion.modificaFecha != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEstacion;
        result = 31 * result + (hostname != null ? hostname.hashCode() : 0);
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (ubicacion != null ? ubicacion.hashCode() : 0);
        result = 31 * result + (creacionUsuario != null ? creacionUsuario.hashCode() : 0);
        result = 31 * result + (creacionFecha != null ? creacionFecha.hashCode() : 0);
        result = 31 * result + (modificaUsuario != null ? modificaUsuario.hashCode() : 0);
        result = 31 * result + (modificaFecha != null ? modificaFecha.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "estacionByIdEstacion")
    public Collection<EstacionUsuario> getEstacionUsuariosByIdEstacion() {
        return estacionUsuariosByIdEstacion;
    }

    public void setEstacionUsuariosByIdEstacion(Collection<EstacionUsuario> estacionUsuariosByIdEstacion) {
        this.estacionUsuariosByIdEstacion = estacionUsuariosByIdEstacion;
    }

    @OneToMany(mappedBy = "estacionByIdEstacion")
    public Collection<ImpEstacion> getImpEstacionsByIdEstacion() {
        return impEstacionsByIdEstacion;
    }

    public void setImpEstacionsByIdEstacion(Collection<ImpEstacion> impEstacionsByIdEstacion) {
        this.impEstacionsByIdEstacion = impEstacionsByIdEstacion;
    }
}
