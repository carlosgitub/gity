package ec.org.isspol.persistence.entities.security;

import javax.persistence.*;

/**
 * Created by mauchilan on 20/3/17.
 */
@Entity
public class Favorito {
    private int idFavorito;
    private Integer idUsuario;
    //private Integer idOpcion;
    private String usuario;
    private int opcion;
    private Opcion opcionByIdOpcion;

    @Id
    @Column(name = "IdFavorito", nullable = false)
    public int getIdFavorito() {
        return idFavorito;
    }

    public void setIdFavorito(int idFavorito) {
        this.idFavorito = idFavorito;
    }

    @Basic
    @Column(name = "IdUsuario", nullable = true)
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    /*@Basic
    @Column(name = "IdOpcion", nullable = true)
    public Integer getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(Integer idOpcion) {
        this.idOpcion = idOpcion;
    }*/

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Favorito favorito = (Favorito) o;

        if (idFavorito != favorito.idFavorito) return false;
        if (opcion != favorito.opcion) return false;
        if (idUsuario != null ? !idUsuario.equals(favorito.idUsuario) : favorito.idUsuario != null) return false;
        //if (idOpcion != null ? !idOpcion.equals(favorito.idOpcion) : favorito.idOpcion != null) return false;
        if (usuario != null ? !usuario.equals(favorito.usuario) : favorito.usuario != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFavorito;
        result = 31 * result + (idUsuario != null ? idUsuario.hashCode() : 0);
        //result = 31 * result + (idOpcion != null ? idOpcion.hashCode() : 0);
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        result = 31 * result + opcion;
        return result;
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
