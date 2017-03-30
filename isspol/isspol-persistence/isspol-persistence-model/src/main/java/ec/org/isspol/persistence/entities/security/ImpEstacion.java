package ec.org.isspol.persistence.entities.security;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by mauchilan on 20/3/17.
 */
@Entity
public class ImpEstacion implements Serializable {
    private int idImpEstacion;
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
        if (creacionUsuario != null ? !creacionUsuario.equals(that.creacionUsuario) : that.creacionUsuario != null)
            return false;
        if (creacionFecha != null ? !creacionFecha.equals(that.creacionFecha) : that.creacionFecha != null)
            return false;
        if (modificaUsuario != null ? !modificaUsuario.equals(that.modificaUsuario) : that.modificaUsuario != null)
            return false;
        return modificaFecha != null ? modificaFecha.equals(that.modificaFecha) : that.modificaFecha == null;
    }

    @Override
    public int hashCode() {
        int result = idImpEstacion;
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
