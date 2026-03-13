package Modelo;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

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
    private Double saldo;

    @ManyToMany (cascade = {CascadeType.PERSIST})
    @JoinTable(joinColumns = @JoinColumn(name = "id_cuenta"),
            inverseJoinColumns = @JoinColumn(name = "id_titular"))
    private Set<Titular> titulares = new LinkedHashSet<>();

    public Cuenta(int id, String iban, Double saldo) {
        this.id = id;
        this.iban = iban;
        this.saldo = saldo;
    }

    public Cuenta(String iban, Double saldo) {
        this.iban = iban;
        this.saldo = saldo;
    }

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

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Set<Titular> getTitulares() {
        return titulares;
    }

    public void setTitulares(Set<Titular> titulares) {
        this.titulares = titulares;
    }

    public void setTitulares(Titular titular) {
        this.titulares.add(titular);
    }

}