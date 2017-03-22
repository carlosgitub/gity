package ec.org.isspol.persistence.entities.security;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by mauchilan on 20/3/17.
 */
@Entity
public class Icono {
    private int idIcono;
    private String icono;
    private String creacionUsuario;
    private Timestamp creacionFecha;
    private String modificaUsuario;
    private Timestamp modificaFecha;
    private Collection<CarpetaOpcion> carpetaOpcionsByIdIcono;
    private Collection<Opcion> opcionsByIdIcono;

    @Id
    @Column(name = "IdIcono", nullable = false)
    public int getIdIcono() {
        return idIcono;
    }

    public void setIdIcono(int idIcono) {
        this.idIcono = idIcono;
    }

    @Basic
    @Column(name = "Icono", nullable = false, length = 50)
    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
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

        Icono icono1 = (Icono) o;

        if (idIcono != icono1.idIcono) return false;
        if (icono != null ? !icono.equals(icono1.icono) : icono1.icono != null) return false;
        if (creacionUsuario != null ? !creacionUsuario.equals(icono1.creacionUsuario) : icono1.creacionUsuario != null)
            return false;
        if (creacionFecha != null ? !creacionFecha.equals(icono1.creacionFecha) : icono1.creacionFecha != null)
            return false;
        if (modificaUsuario != null ? !modificaUsuario.equals(icono1.modificaUsuario) : icono1.modificaUsuario != null)
            return false;
        if (modificaFecha != null ? !modificaFecha.equals(icono1.modificaFecha) : icono1.modificaFecha != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idIcono;
        result = 31 * result + (icono != null ? icono.hashCode() : 0);
        result = 31 * result + (creacionUsuario != null ? creacionUsuario.hashCode() : 0);
        result = 31 * result + (creacionFecha != null ? creacionFecha.hashCode() : 0);
        result = 31 * result + (modificaUsuario != null ? modificaUsuario.hashCode() : 0);
        result = 31 * result + (modificaFecha != null ? modificaFecha.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "iconoByIcono")
    public Collection<CarpetaOpcion> getCarpetaOpcionsByIdIcono() {
        return carpetaOpcionsByIdIcono;
    }

    public void setCarpetaOpcionsByIdIcono(Collection<CarpetaOpcion> carpetaOpcionsByIdIcono) {
        this.carpetaOpcionsByIdIcono = carpetaOpcionsByIdIcono;
    }

    @OneToMany(mappedBy = "iconoByIdIcono")
    public Collection<Opcion> getOpcionsByIdIcono() {
        return opcionsByIdIcono;
    }

    public void setOpcionsByIdIcono(Collection<Opcion> opcionsByIdIcono) {
        this.opcionsByIdIcono = opcionsByIdIcono;
    }
}
