package ec.org.isspol.persistence.entities.security;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by mauchilan on 20/3/17.
 */
@Entity
@Table(name = "Seguridad.NivelEstructuraOrg")
public class NivelEstructuraOrg implements Serializable {
    private int idNivelEstructuraOrg;
    private int nivel;
    private short largoCodigo;
    private String descripcion;
    private int icono;
    private String creacionUsuario;
    private Timestamp creacionFecha;
    private String modificaUsuario;
    private Timestamp modificaFecha;
    private Collection<EstructuraOrganizacional> estructuraOrganizacionalsByIdNivelEstructuraOrg;

    @Id
    @Column(name = "IdNivelEstructuraOrg", nullable = false)
    public int getIdNivelEstructuraOrg() {
        return idNivelEstructuraOrg;
    }

    public void setIdNivelEstructuraOrg(int idNivelEstructuraOrg) {
        this.idNivelEstructuraOrg = idNivelEstructuraOrg;
    }

    @Basic
    @Column(name = "Nivel", nullable = false)
    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Basic
    @Column(name = "LargoCodigo", nullable = false)
    public short getLargoCodigo() {
        return largoCodigo;
    }

    public void setLargoCodigo(short largoCodigo) {
        this.largoCodigo = largoCodigo;
    }

    @Basic
    @Column(name = "Descripcion", nullable = false, length = 50)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "Icono", nullable = false)
    public int getIcono() {
        return icono;
    }

    public void setIcono(int icono) {
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

        NivelEstructuraOrg that = (NivelEstructuraOrg) o;

        if (idNivelEstructuraOrg != that.idNivelEstructuraOrg) return false;
        if (nivel != that.nivel) return false;
        if (largoCodigo != that.largoCodigo) return false;
        if (icono != that.icono) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
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
        int result = idNivelEstructuraOrg;
        result = 31 * result + nivel;
        result = 31 * result + (int) largoCodigo;
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + icono;
        result = 31 * result + (creacionUsuario != null ? creacionUsuario.hashCode() : 0);
        result = 31 * result + (creacionFecha != null ? creacionFecha.hashCode() : 0);
        result = 31 * result + (modificaUsuario != null ? modificaUsuario.hashCode() : 0);
        result = 31 * result + (modificaFecha != null ? modificaFecha.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "nivelEstructuraOrgByIdNivelEstrcuturaOrg")
    public Collection<EstructuraOrganizacional> getEstructuraOrganizacionalsByIdNivelEstructuraOrg() {
        return estructuraOrganizacionalsByIdNivelEstructuraOrg;
    }

    public void setEstructuraOrganizacionalsByIdNivelEstructuraOrg(Collection<EstructuraOrganizacional> estructuraOrganizacionalsByIdNivelEstructuraOrg) {
        this.estructuraOrganizacionalsByIdNivelEstructuraOrg = estructuraOrganizacionalsByIdNivelEstructuraOrg;
    }
}
