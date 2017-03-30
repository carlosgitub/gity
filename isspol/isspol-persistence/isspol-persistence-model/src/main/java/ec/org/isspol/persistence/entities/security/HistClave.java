package ec.org.isspol.persistence.entities.security;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;

/**
 * Created by mauchilan on 20/3/17.
 */
@Entity
public class HistClave implements Serializable {
    private int idHistClave;
    private String usuario;
    private byte[] clave;
    private String creacionUsuario;
    private Timestamp creacionFecha;
    private Usuario usuarioByIdUsuario;

    @Id
    @Column(name = "IdHistClave", nullable = false)
    public int getIdHistClave() {
        return idHistClave;
    }

    public void setIdHistClave(int idHistClave) {
        this.idHistClave = idHistClave;
    }

    @Basic
    @Column(name = "Usuario", nullable = true, length = 15)
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Basic
    @Column(name = "Clave", nullable = true)
    public byte[] getClave() {
        return clave;
    }

    public void setClave(byte[] clave) {
        this.clave = clave;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HistClave histClave = (HistClave) o;

        if (idHistClave != histClave.idHistClave) return false;
        if (usuario != null ? !usuario.equals(histClave.usuario) : histClave.usuario != null) return false;
        if (!Arrays.equals(clave, histClave.clave)) return false;
        if (creacionUsuario != null ? !creacionUsuario.equals(histClave.creacionUsuario) : histClave.creacionUsuario != null)
            return false;
        return creacionFecha != null ? creacionFecha.equals(histClave.creacionFecha) : histClave.creacionFecha == null;
    }

    @Override
    public int hashCode() {
        int result = idHistClave;
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(clave);
        result = 31 * result + (creacionUsuario != null ? creacionUsuario.hashCode() : 0);
        result = 31 * result + (creacionFecha != null ? creacionFecha.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "IdUsuario", referencedColumnName = "IdUsuario")
    public Usuario getUsuarioByIdUsuario() {
        return usuarioByIdUsuario;
    }

    public void setUsuarioByIdUsuario(Usuario usuarioByIdUsuario) {
        this.usuarioByIdUsuario = usuarioByIdUsuario;
    }
}
