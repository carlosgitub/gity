package ec.org.isspol.persistence.entities.security;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by mauchilan on 20/3/17.
 */
@Entity
public class ImpEstacion {
    private int idImpEstacion;
    //private int idEstacion;
    //private int idImpresora;
    private String creacionUsuario;
    private Timestamp creacionFecha;
    private String modificaUsuario;
    private Timestamp modificaFecha;
    private Estacion estacionByIdEstacion;
    private Impresora impresoraByIdImpresora;

    @Id
    @Column(name = "IdImpEstacion", nullable = false)
    public int getIdImpEstacion() {
        return idImpEstacion;
    }

    public void setIdImpEstacion(int idImpEstacion) {
        this.idImpEstacion = idImpEstacion;
    }

    /*@Basic
    @Column(name = "IdEstacion", nullable = false)
    public int getIdEstacion() {
        return idEstacion;
    }

    public void setIdEstacion(int idEstacion) {
        this.idEstacion = idEstacion;
    }*/

    /*@Basic
    @Column(name = "IdImpresora", nullable = false)
    public int getIdImpresora() {
        return idImpresora;
    }

    public void setIdImpresora(int idImpresora) {
        this.idImpresora = idImpresora;
    }*/

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

        ImpEstacion that = (ImpEstacion) o;

        if (idImpEstacion != that.idImpEstacion) return false;
        //if (idEstacion != that.idEstacion) return false;
        //if (idImpresora != that.idImpresora) return false;
        if (creacionUsuario != null ? !creacionUsuario.equals(that.creacionUsuario) : that.creacionUsuario != null)
            return false;
        if (creacionFecha != null ? !creacionFecha.equals(that.creacionFecha) : that.creacionFecha != null)
            return false;
        if (modificaUsuario != null ? !modificaUsuario.equals(that.modificaUsuario) : that.modificaUsuario != null)
            return false;
        if (modificaFecha != null ? !modificaFecha.equals(that.modificaFecha) : that.modificaFecha != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idImpEstacion;
        //result = 31 * result + idEstacion;
        //result = 31 * result + idImpresora;
        result = 31 * result + (creacionUsuario != null ? creacionUsuario.hashCode() : 0);
        result = 31 * result + (creacionFecha != null ? creacionFecha.hashCode() : 0);
        result = 31 * result + (modificaUsuario != null ? modificaUsuario.hashCode() : 0);
        result = 31 * result + (modificaFecha != null ? modificaFecha.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "IdEstacion", referencedColumnName = "IdEstacion", nullable = false)
    public Estacion getEstacionByIdEstacion() {
        return estacionByIdEstacion;
    }

    public void setEstacionByIdEstacion(Estacion estacionByIdEstacion) {
        this.estacionByIdEstacion = estacionByIdEstacion;
    }

    @ManyToOne
    @JoinColumn(name = "IdImpresora", referencedColumnName = "IdImpresora", nullable = false)
    public Impresora getImpresoraByIdImpresora() {
        return impresoraByIdImpresora;
    }

    public void setImpresoraByIdImpresora(Impresora impresoraByIdImpresora) {
        this.impresoraByIdImpresora = impresoraByIdImpresora;
    }
}
