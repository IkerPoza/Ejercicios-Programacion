package Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "cuentas_titulares")
public class CuentasTitulare {
    @EmbeddedId
    private CuentasTitulareId id;

    @MapsId("idCuenta")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cuenta", nullable = false)
    private Cuenta idCuenta;

    public CuentasTitulareId getId() {
        return id;
    }

    public void setId(CuentasTitulareId id) {
        this.id = id;
    }

    public Cuenta getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Cuenta idCuenta) {
        this.idCuenta = idCuenta;
    }

}