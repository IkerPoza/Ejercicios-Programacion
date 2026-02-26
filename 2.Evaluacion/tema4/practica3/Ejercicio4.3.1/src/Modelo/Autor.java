package Modelo;

import java.time.LocalDate;

public class Autor extends Persona {
    public Autor(String paisNacimiento, LocalDate fechaNacimiento, String nombre) {
        super(paisNacimiento, fechaNacimiento, nombre);
    }
}
