package ec.org.isspol.persistence.entities.security;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by mauchilan on 20/3/17.
 */
@Entity
public class Grupo {
    private int idGrupo;
    private String grupo;
    private String nombre;
    private String creacionUsuario;
    private Timestamp creacionFecha;
    private String modificaUsuario;
    private Timestamp modificaFecha;
    private Collection<GrupoUsuario> grupoUsuariosByGrupo;
    private Collection<Permiso> permisosByGrupo;

    @Basic
    @Column(name = "IdGrupo", nullable = false)
    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    @Id
    @Column(name = "Grupo", nullable = false, length = 3)
    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
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

        Grupo grupo1 = (Grupo) o;

        if (idGrupo != grupo1.idGrupo) return false;
        if (grupo != null ? !grupo.equals(grupo1.grupo) : grupo1.grupo != null) return false;
        if (nombre != null ? !nombre.equals(grupo1.nombre) : grupo1.nombre != null) return false;
        if (creacionUsuario != null ? !creacionUsuario.equals(grupo1.creacionUsuario) : grupo1.creacionUsuario != null)
            return false;
        if (creacionFecha != null ? !creacionFecha.equals(grupo1.creacionFecha) : grupo1.creacionFecha != null)
            return false;
        if (modificaUsuario != null ? !modificaUsuario.equals(grupo1.modificaUsuario) : grupo1.modificaUsuario != null)
            return false;
        if (modificaFecha != null ? !modificaFecha.equals(grupo1.modificaFecha) : grupo1.modificaFecha != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idGrupo;
        result = 31 * result + (grupo != null ? grupo.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (creacionUsuario != null ? creacionUsuario.hashCode() : 0);
        result = 31 * result + (creacionFecha != null ? creacionFecha.hashCode() : 0);
        result = 31 * result + (modificaUsuario != null ? modificaUsuario.hashCode() : 0);
        result = 31 * result + (modificaFecha != null ? modificaFecha.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "grupoByGrupo")
    public Collection<GrupoUsuario> getGrupoUsuariosByGrupo() {
        return grupoUsuariosByGrupo;
    }

    public void setGrupoUsuariosByGrupo(Collection<GrupoUsuario> grupoUsuariosByGrupo) {
        this.grupoUsuariosByGrupo = grupoUsuariosByGrupo;
    }

    @OneToMany(mappedBy = "grupoByGrupo")
    public Collection<Permiso> getPermisosByGrupo() {
        return permisosByGrupo;
    }

    public void setPermisosByGrupo(Collection<Permiso> permisosByGrupo) {
        this.permisosByGrupo = permisosByGrupo;
    }
}
