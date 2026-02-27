package Modelo;

public class Cuenta {
    private int id;
    private String iban;
    private double saldo;

    public Cuenta(int id, String iban, double saldo) {
        this.id = id;
        this.iban = iban;
        this.saldo = saldo;
    }

    public Cuenta(String iban, double saldo) {
        this.iban = iban;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public String getIban() {
        return iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public  void setId(int id) {
        this.id = id;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


}
