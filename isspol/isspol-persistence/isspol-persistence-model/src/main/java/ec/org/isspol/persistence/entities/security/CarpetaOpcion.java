package ec.org.isspol.persistence.entities.security;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by mauchilan on 20/3/17.
 */
@Entity
public class CarpetaOpcion implements Serializable{
    private int idCarpetaOpcion;
    private String nombre;
    private String descripcion;
    private int orden;
    private String codigo;
    private Integer nivel;
    private String objeto;
    private String parametro;
    private String tipoAbrir;
    private boolean visible;
    private String creacionUsuario;
    private Timestamp creacionFecha;
    private String modificaUsuario;
    private Timestamp modificaFecha;
    private CarpetaOpcion carpetaOpcionByIdCarpeta;
    private Collection<CarpetaOpcion> carpetaOpcionsByIdCarpetaOpcion;
    private Icono iconoByIcono;
    private Collection<Opcion> opcionsByIdCarpetaOpcion;

    @Id
    @Column(name = "IdCarpetaOpcion", nullable = false)
    public int getIdCarpetaOpcion() {
        return idCarpetaOpcion;
    }

    public void setIdCarpetaOpcion(int idCarpetaOpcion) {
        this.idCarpetaOpcion = idCarpetaOpcion;
    }

    @Basic
    @Column(name = "Nombre", nullable = false, length = 100)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "Descripcion", nullable = true, length = 200)
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

    @Basic
    @Column(name = "Codigo", nullable = true, length = 20)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "Nivel", nullable = true)
    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    @Basic
    @Column(name = "Objeto", nullable = true, length = 100)
    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    @Basic
    @Column(name = "Parametro", nullable = true, length = 100)
    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    @Basic
    @Column(name = "TipoAbrir", nullable = true, length = 2)
    public String getTipoAbrir() {
        return tipoAbrir;
    }

    public void setTipoAbrir(String tipoAbrir) {
        this.tipoAbrir = tipoAbrir;
    }

    @Basic
    @Column(name = "Visible", nullable = false)
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
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

        CarpetaOpcion that = (CarpetaOpcion) o;

        if (idCarpetaOpcion != that.idCarpetaOpcion) return false;
        if (orden != that.orden) return false;
        if (visible != that.visible) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (codigo != null ? !codigo.equals(that.codigo) : that.codigo != null) return false;
        if (nivel != null ? !nivel.equals(that.nivel) : that.nivel != null) return false;
        if (objeto != null ? !objeto.equals(that.objeto) : that.objeto != null) return false;
        if (parametro != null ? !parametro.equals(that.parametro) : that.parametro != null) return false;
        if (tipoAbrir != null ? !tipoAbrir.equals(that.tipoAbrir) : that.tipoAbrir != null) return false;
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
        int result = idCarpetaOpcion;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + orden;
        result = 31 * result + (codigo != null ? codigo.hashCode() : 0);
        result = 31 * result + (nivel != null ? nivel.hashCode() : 0);
        result = 31 * result + (objeto != null ? objeto.hashCode() : 0);
        result = 31 * result + (parametro != null ? parametro.hashCode() : 0);
        result = 31 * result + (tipoAbrir != null ? tipoAbrir.hashCode() : 0);
        result = 31 * result + (visible ? 1 : 0);
        result = 31 * result + (creacionUsuario != null ? creacionUsuario.hashCode() : 0);
        result = 31 * result + (creacionFecha != null ? creacionFecha.hashCode() : 0);
        result = 31 * result + (modificaUsuario != null ? modificaUsuario.hashCode() : 0);
        result = 31 * result + (modificaFecha != null ? modificaFecha.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "IdCarpeta", referencedColumnName = "IdCarpetaOpcion")
    public CarpetaOpcion getCarpetaOpcionByIdCarpeta() {
        return carpetaOpcionByIdCarpeta;
    }

    public void setCarpetaOpcionByIdCarpeta(CarpetaOpcion carpetaOpcionByIdCarpeta) {
        this.carpetaOpcionByIdCarpeta = carpetaOpcionByIdCarpeta;
    }

    @OneToMany(mappedBy = "carpetaOpcionByIdCarpeta")
    public Collection<CarpetaOpcion> getCarpetaOpcionsByIdCarpetaOpcion() {
        return carpetaOpcionsByIdCarpetaOpcion;
    }

    public void setCarpetaOpcionsByIdCarpetaOpcion(Collection<CarpetaOpcion> carpetaOpcionsByIdCarpetaOpcion) {
        this.carpetaOpcionsByIdCarpetaOpcion = carpetaOpcionsByIdCarpetaOpcion;
    }

    @ManyToOne
    @JoinColumn(name = "Icono", referencedColumnName = "IdIcono", nullable = false)
    public Icono getIconoByIcono() {
        return iconoByIcono;
    }

    public void setIconoByIcono(Icono iconoByIcono) {
        this.iconoByIcono = iconoByIcono;
    }

    @OneToMany(mappedBy = "carpetaOpcionByIdCarpetaOpcion")
    public Collection<Opcion> getOpcionsByIdCarpetaOpcion() {
        return opcionsByIdCarpetaOpcion;
    }

    public void setOpcionsByIdCarpetaOpcion(Collection<Opcion> opcionsByIdCarpetaOpcion) {
        this.opcionsByIdCarpetaOpcion = opcionsByIdCarpetaOpcion;
    }
}
