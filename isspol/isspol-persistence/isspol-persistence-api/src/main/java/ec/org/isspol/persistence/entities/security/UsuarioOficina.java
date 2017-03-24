package ec.org.isspol.persistence.entities.security;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by mauchilan on 20/3/17.
 */
@Entity
public class UsuarioOficina implements Serializable {
    private int idUsuarioOficina;
    private String usuario;
    //private Integer idOficina;
    private String oficina;
    private String creacionUsuario;
    private Timestamp creacionFecha;
    private String modificaUsuario;
    private Timestamp modificaFecha;
    private Oficina oficinaByIdOficina;

    @Id
    @Column(name = "IdUsuarioOficina", nullable = false)
    public int getIdUsuarioOficina() {
        return idUsuarioOficina;
    }

    public void setIdUsuarioOficina(int idUsuarioOficina) {
        this.idUsuarioOficina = idUsuarioOficina;
    }

    @Basic
    @Column(name = "Usuario", nullable = false, length = 15)
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /*@Basic
    @Column(name = "IdOficina", nullable = true)
    public Integer getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(Integer idOficina) {
        this.idOficina = idOficina;
    }*/

    @Basic
    @Column(name = "Oficina", nullable = false, length = 4)
    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
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

        UsuarioOficina that = (UsuarioOficina) o;

        if (idUsuarioOficina != that.idUsuarioOficina) return false;
        if (usuario != null ? !usuario.equals(that.usuario) : that.usuario != null) return false;
        //if (idOficina != null ? !idOficina.equals(that.idOficina) : that.idOficina != null) return false;
        if (oficina != null ? !oficina.equals(that.oficina) : that.oficina != null) return false;
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
        int result = idUsuarioOficina;
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        //result = 31 * result + (idOficina != null ? idOficina.hashCode() : 0);
        result = 31 * result + (oficina != null ? oficina.hashCode() : 0);
        result = 31 * result + (creacionUsuario != null ? creacionUsuario.hashCode() : 0);
        result = 31 * result + (creacionFecha != null ? creacionFecha.hashCode() : 0);
        result = 31 * result + (modificaUsuario != null ? modificaUsuario.hashCode() : 0);
        result = 31 * result + (modificaFecha != null ? modificaFecha.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "IdOficina", referencedColumnName = "IdOficina")
    public Oficina getOficinaByIdOficina() {
        return oficinaByIdOficina;
    }

    public void setOficinaByIdOficina(Oficina oficinaByIdOficina) {
        this.oficinaByIdOficina = oficinaByIdOficina;
    }
}
