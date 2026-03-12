package Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "cuentas")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "iban", nullable = false, length = 24)
    private String iban;

    @Column(name = "saldo", nullable = false)
    private Integer saldo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_titular", nullable = false)
    private Titular idTitular;

    public Cuenta() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public Titular getIdTitular() {
        return idTitular;
    }

    public void setIdTitular(Titular idTitular) {
        this.idTitular = idTitular;
    }

    public Cuenta(String iban, Integer saldo, Titular idTitular) {
        this.iban = iban;
        this.saldo = saldo;
        this.idTitular = idTitular;
    }
}