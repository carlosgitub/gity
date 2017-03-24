package ec.org.isspol.persistence.entities.security;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by mauchilan on 20/3/17.
 */
@Embeddable
public class GrupoModuloPK implements Serializable {

    @Column(name = "IdGrupoModulo", nullable = false)
    @Basic(optional = false)
    private int idGrupoModulo;
    @Column(name = "IdModulo", nullable = false)
    @Basic(optional = false)
    private int idModulo;

    public int getIdGrupoModulo() {
        return idGrupoModulo;
    }

    public void setIdGrupoModulo(int idGrupoModulo) {
        this.idGrupoModulo = idGrupoModulo;
    }

    public int getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GrupoModuloPK that = (GrupoModuloPK) o;

        if (idGrupoModulo != that.idGrupoModulo) return false;
        if (idModulo != that.idModulo) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idGrupoModulo;
        result = 31 * result + idModulo;
        return result;
    }
}
