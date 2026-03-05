package Modelo;

import java.time.LocalDate;

public class Vuelo {
    private String codVuelo;
    private LocalDate fechaSalida;
    private String destino;
    private String procedencia;

    public Vuelo(String codVuelo, LocalDate fechaSalida, String destino, String procedencia) {
        this.codVuelo = codVuelo;
        this.fechaSalida = fechaSalida;
        this.destino = destino;
        this.procedencia = procedencia;
    }

    public String getCodVuelo() {
        return codVuelo;
    }

    public void setCodVuelo(String codVuelo) {
        this.codVuelo = codVuelo;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    @Override
    public String toString() {
        return "\nVuelo: " + codVuelo +
                "\nFecha de Salida: " + fechaSalida +
                "\nDestino: " + destino +
                "\nProcedencia: " + procedencia;
    }
}
