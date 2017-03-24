package ec.org.isspol.persistence.entities.security;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by mauchilan on 20/3/17.
 */
@Entity
//@IdClass(GrupoModuloPK.class)
public class GrupoModulo implements Serializable {
    private int idGrupoModulo;
    //private int idModulo;
    private String modulo;
    private String grupoMod;
    private String nombre;
    private String creacionUsuario;
    private Timestamp creacionFecha;
    private String modificaUsuario;
    private Timestamp modificaFecha;
    private Modulo moduloByIdModulo;

    @Id
    @Column(name = "IdGrupoModulo", nullable = false)
    public int getIdGrupoModulo() {
        return idGrupoModulo;
    }

    public void setIdGrupoModulo(int idGrupoModulo) {
        this.idGrupoModulo = idGrupoModulo;
    }

    /*@Id
    @Column(name = "IdModulo", nullable = false)
    public int getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
    }*/

    @Basic
    @Column(name = "Modulo", nullable = false, length = 2)
    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    @Basic
    @Column(name = "GrupoMod", nullable = false, length = 2)
    public String getGrupoMod() {
        return grupoMod;
    }

    public void setGrupoMod(String grupoMod) {
        this.grupoMod = grupoMod;
    }

    @Basic
    @Column(name = "Nombre", nullable = false, length = 25)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

        GrupoModulo that = (GrupoModulo) o;

        if (idGrupoModulo != that.idGrupoModulo) return false;
        //if (idModulo != that.idModulo) return false;
        if (modulo != null ? !modulo.equals(that.modulo) : that.modulo != null) return false;
        if (grupoMod != null ? !grupoMod.equals(that.grupoMod) : that.grupoMod != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
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
        int result = idGrupoModulo;
        //result = 31 * result + idModulo;
        result = 31 * result + (modulo != null ? modulo.hashCode() : 0);
        result = 31 * result + (grupoMod != null ? grupoMod.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (creacionUsuario != null ? creacionUsuario.hashCode() : 0);
        result = 31 * result + (creacionFecha != null ? creacionFecha.hashCode() : 0);
        result = 31 * result + (modificaUsuario != null ? modificaUsuario.hashCode() : 0);
        result = 31 * result + (modificaFecha != null ? modificaFecha.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "IdModulo", referencedColumnName = "IdModulo", nullable = false)
    public Modulo getModuloByIdModulo() {
        return moduloByIdModulo;
    }

    public void setModuloByIdModulo(Modulo moduloByIdModulo) {
        this.moduloByIdModulo = moduloByIdModulo;
    }
}
