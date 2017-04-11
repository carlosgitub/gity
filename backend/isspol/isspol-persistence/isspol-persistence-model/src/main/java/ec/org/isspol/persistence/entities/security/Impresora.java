package ec.org.isspol.persistence.entities.security;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by mauchilan on 20/3/17.
 */
@Entity
public class Impresora implements Serializable {
    private int idImpresora;
    private String nombre;
    private String dispositivo;
    private String creacionUsuario;
    private Timestamp creacionFecha;
    private String modificaUsuario;
    private Timestamp modificaFecha;
    private Collection<ImpEstacion> impEstacionsByIdImpresora;

    @Id
    @Column(name = "IdImpresora", nullable = false)
    public int getIdImpresora() {
        return idImpresora;
    }

    public void setIdImpresora(int idImpresora) {
        this.idImpresora = idImpresora;
    }

    @Basic
    @Column(name = "Nombre", nullable = false, length = 50)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "Dispositivo", nullable = true, length = 255)
    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
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

        Impresora impresora = (Impresora) o;

        if (idImpresora != impresora.idImpresora) return false;
        if (nombre != null ? !nombre.equals(impresora.nombre) : impresora.nombre != null) return false;
        if (dispositivo != null ? !dispositivo.equals(impresora.dispositivo) : impresora.dispositivo != null)
            return false;
        if (creacionUsuario != null ? !creacionUsuario.equals(impresora.creacionUsuario) : impresora.creacionUsuario != null)
            return false;
        if (creacionFecha != null ? !creacionFecha.equals(impresora.creacionFecha) : impresora.creacionFecha != null)
            return false;
        if (modificaUsuario != null ? !modificaUsuario.equals(impresora.modificaUsuario) : impresora.modificaUsuario != null)
            return false;
        return modificaFecha != null ? modificaFecha.equals(impresora.modificaFecha) : impresora.modificaFecha == null;
    }

    @Override
    public int hashCode() {
        int result = idImpresora;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (dispositivo != null ? dispositivo.hashCode() : 0);
        result = 31 * result + (creacionUsuario != null ? creacionUsuario.hashCode() : 0);
        result = 31 * result + (creacionFecha != null ? creacionFecha.hashCode() : 0);
        result = 31 * result + (modificaUsuario != null ? modificaUsuario.hashCode() : 0);
        result = 31 * result + (modificaFecha != null ? modificaFecha.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "impresoraByIdImpresora")
    public Collection<ImpEstacion> getImpEstacionsByIdImpresora() {
        return impEstacionsByIdImpresora;
    }

    public void setImpEstacionsByIdImpresora(Collection<ImpEstacion> impEstacionsByIdImpresora) {
        this.impEstacionsByIdImpresora = impEstacionsByIdImpresora;
    }
}
