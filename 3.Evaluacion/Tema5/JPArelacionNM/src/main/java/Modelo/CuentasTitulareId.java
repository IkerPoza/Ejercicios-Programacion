package Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CuentasTitulareId implements Serializable {
    private static final long serialVersionUID = -3355154836533351619L;
    @Column(name = "id_cuenta", nullable = false)
    private Integer idCuenta;

    @Column(name = "id_titular", nullable = false)
    private Integer idTitular;

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Integer getIdTitular() {
        return idTitular;
    }

    public void setIdTitular(Integer idTitular) {
        this.idTitular = idTitular;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CuentasTitulareId entity = (CuentasTitulareId) o;
        return Objects.equals(this.idTitular, entity.idTitular) &&
                Objects.equals(this.idCuenta, entity.idCuenta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTitular, idCuenta);
    }

}