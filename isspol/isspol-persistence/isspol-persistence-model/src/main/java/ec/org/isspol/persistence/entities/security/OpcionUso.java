package ec.org.isspol.persistence.entities.security;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by mauchilan on 20/3/17.
 */
@Entity
public class OpcionUso implements Serializable {
    private int idOpcionUso;
    private String usuario;
    private int opcion;
    private int numeroUso;
    private Timestamp fechaUltimoUso;
    private Usuario usuarioByIdUsuario;
    private Opcion opcionByIdOpcion;

    @Id
    @Column(name = "IdOpcionUso", nullable = false)
    public int getIdOpcionUso() {
        return idOpcionUso;
    }

    public void setIdOpcionUso(int idOpcionUso) {
        this.idOpcionUso = idOpcionUso;
    }
    @Basic
    @Column(name = "Usuario", nullable = false, length = 15)
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Basic
    @Column(name = "Opcion", nullable = false)
    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    @Basic
    @Column(name = "NumeroUso", nullable = false)
    public int getNumeroUso() {
        return numeroUso;
    }

    public void setNumeroUso(int numeroUso) {
        this.numeroUso = numeroUso;
    }

    @Basic
    @Column(name = "FechaUltimoUso", nullable = false)
    public Timestamp getFechaUltimoUso() {
        return fechaUltimoUso;
    }

    public void setFechaUltimoUso(Timestamp fechaUltimoUso) {
        this.fechaUltimoUso = fechaUltimoUso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OpcionUso opcionUso = (OpcionUso) o;

        if (idOpcionUso != opcionUso.idOpcionUso) return false;
        if (opcion != opcionUso.opcion) return false;
        if (numeroUso != opcionUso.numeroUso) return false;
        if (usuario != null ? !usuario.equals(opcionUso.usuario) : opcionUso.usuario != null) return false;
        return fechaUltimoUso != null ? fechaUltimoUso.equals(opcionUso.fechaUltimoUso) : opcionUso.fechaUltimoUso == null;
    }

    @Override
    public int hashCode() {
        int result = idOpcionUso;
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        result = 31 * result + opcion;
        result = 31 * result + numeroUso;
        result = 31 * result + (fechaUltimoUso != null ? fechaUltimoUso.hashCode() : 0);
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

    @ManyToOne
    @JoinColumn(name = "IdOpcion", referencedColumnName = "IdOpcion")
    public Opcion getOpcionByIdOpcion() {
        return opcionByIdOpcion;
    }

    public void setOpcionByIdOpcion(Opcion opcionByIdOpcion) {
        this.opcionByIdOpcion = opcionByIdOpcion;
    }
}
