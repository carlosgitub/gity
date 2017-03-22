package ec.org.isspol.persistence.entities.security;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by mauchilan on 20/3/17.
 */
@Entity
@Table(name = "Seguridad.EstructuraOrganizacional")
public class EstructuraOrganizacional {
    private int idEstructuraOrganizacional;
    private Integer idEstructura;
    private String codigo;
    private String codigoAlterno;
    private String descripcion;
    private int orden;
    //private int idNivelEstrcuturaOrg;
    private Integer nivel;
    //private Integer idEstructuraPadre;
    private String estado;
    private String creacionUsuario;
    private Timestamp creacionFecha;
    private String modificaUsuario;
    private Timestamp modificaFecha;
    private NivelEstructuraOrg nivelEstructuraOrgByIdNivelEstrcuturaOrg;
    private EstructuraOrganizacional estructuraOrganizacionalByIdEstructuraPadre;
    private Collection<EstructuraOrganizacional> estructuraOrganizacionalsByIdEstructuraOrganizacional;
    private Collection<Usuario> usuariosByIdEstructuraOrganizacional;

    @Id
    @Column(name = "IdEstructuraOrganizacional", nullable = false)
    public int getIdEstructuraOrganizacional() {
        return idEstructuraOrganizacional;
    }

    public void setIdEstructuraOrganizacional(int idEstructuraOrganizacional) {
        this.idEstructuraOrganizacional = idEstructuraOrganizacional;
    }

    @Basic
    @Column(name = "IdEstructura", nullable = true)
    public Integer getIdEstructura() {
        return idEstructura;
    }

    public void setIdEstructura(Integer idEstructura) {
        this.idEstructura = idEstructura;
    }

    @Basic
    @Column(name = "Codigo", nullable = false, length = 15)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "CodigoAlterno", nullable = true, length = 15)
    public String getCodigoAlterno() {
        return codigoAlterno;
    }

    public void setCodigoAlterno(String codigoAlterno) {
        this.codigoAlterno = codigoAlterno;
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
    @Column(name = "Orden", nullable = false)
    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    /*@Basic
    @Column(name = "IdNivelEstrcuturaOrg", nullable = false)
    public int getIdNivelEstrcuturaOrg() {
        return idNivelEstrcuturaOrg;
    }

    public void setIdNivelEstrcuturaOrg(int idNivelEstrcuturaOrg) {
        this.idNivelEstrcuturaOrg = idNivelEstrcuturaOrg;
    }*/

    @Basic
    @Column(name = "Nivel", nullable = true)
    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    /*@Basic
    @Column(name = "IdEstructuraPadre", nullable = true)
    public Integer getIdEstructuraPadre() {
        return idEstructuraPadre;
    }

    public void setIdEstructuraPadre(Integer idEstructuraPadre) {
        this.idEstructuraPadre = idEstructuraPadre;
    }*/

    @Basic
    @Column(name = "Estado", nullable = false, length = -1)
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

        EstructuraOrganizacional that = (EstructuraOrganizacional) o;

        if (idEstructuraOrganizacional != that.idEstructuraOrganizacional) return false;
        if (orden != that.orden) return false;
        //if (idNivelEstrcuturaOrg != that.idNivelEstrcuturaOrg) return false;
        if (idEstructura != null ? !idEstructura.equals(that.idEstructura) : that.idEstructura != null) return false;
        if (codigo != null ? !codigo.equals(that.codigo) : that.codigo != null) return false;
        if (codigoAlterno != null ? !codigoAlterno.equals(that.codigoAlterno) : that.codigoAlterno != null)
            return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (nivel != null ? !nivel.equals(that.nivel) : that.nivel != null) return false;
        //if (idEstructuraPadre != null ? !idEstructuraPadre.equals(that.idEstructuraPadre) : that.idEstructuraPadre != null)
            //return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;
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
        int result = idEstructuraOrganizacional;
        result = 31 * result + (idEstructura != null ? idEstructura.hashCode() : 0);
        result = 31 * result + (codigo != null ? codigo.hashCode() : 0);
        result = 31 * result + (codigoAlterno != null ? codigoAlterno.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + orden;
        //result = 31 * result + idNivelEstrcuturaOrg;
        result = 31 * result + (nivel != null ? nivel.hashCode() : 0);
        //result = 31 * result + (idEstructuraPadre != null ? idEstructuraPadre.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (creacionUsuario != null ? creacionUsuario.hashCode() : 0);
        result = 31 * result + (creacionFecha != null ? creacionFecha.hashCode() : 0);
        result = 31 * result + (modificaUsuario != null ? modificaUsuario.hashCode() : 0);
        result = 31 * result + (modificaFecha != null ? modificaFecha.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "IdNivelEstrcuturaOrg", referencedColumnName = "IdNivelEstructuraOrg", nullable = false)
    public NivelEstructuraOrg getNivelEstructuraOrgByIdNivelEstrcuturaOrg() {
        return nivelEstructuraOrgByIdNivelEstrcuturaOrg;
    }

    public void setNivelEstructuraOrgByIdNivelEstrcuturaOrg(NivelEstructuraOrg nivelEstructuraOrgByIdNivelEstrcuturaOrg) {
        this.nivelEstructuraOrgByIdNivelEstrcuturaOrg = nivelEstructuraOrgByIdNivelEstrcuturaOrg;
    }

    @ManyToOne
    @JoinColumn(name = "IdEstructuraPadre", referencedColumnName = "IdEstructuraOrganizacional")
    public EstructuraOrganizacional getEstructuraOrganizacionalByIdEstructuraPadre() {
        return estructuraOrganizacionalByIdEstructuraPadre;
    }

    public void setEstructuraOrganizacionalByIdEstructuraPadre(EstructuraOrganizacional estructuraOrganizacionalByIdEstructuraPadre) {
        this.estructuraOrganizacionalByIdEstructuraPadre = estructuraOrganizacionalByIdEstructuraPadre;
    }

    @OneToMany(mappedBy = "estructuraOrganizacionalByIdEstructuraPadre")
    public Collection<EstructuraOrganizacional> getEstructuraOrganizacionalsByIdEstructuraOrganizacional() {
        return estructuraOrganizacionalsByIdEstructuraOrganizacional;
    }

    public void setEstructuraOrganizacionalsByIdEstructuraOrganizacional(Collection<EstructuraOrganizacional> estructuraOrganizacionalsByIdEstructuraOrganizacional) {
        this.estructuraOrganizacionalsByIdEstructuraOrganizacional = estructuraOrganizacionalsByIdEstructuraOrganizacional;
    }

    @OneToMany(mappedBy = "estructuraOrganizacionalByIdEstructura")
    public Collection<Usuario> getUsuariosByIdEstructuraOrganizacional() {
        return usuariosByIdEstructuraOrganizacional;
    }

    public void setUsuariosByIdEstructuraOrganizacional(Collection<Usuario> usuariosByIdEstructuraOrganizacional) {
        this.usuariosByIdEstructuraOrganizacional = usuariosByIdEstructuraOrganizacional;
    }
}
