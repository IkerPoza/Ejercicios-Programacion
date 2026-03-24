package Controlador;

import DAO.personaDAO;
import Modelo.Persona;

import java.time.LocalDate;

public class personaControlador {
    public static void insertar(String dni, String nombre, String apellido, LocalDate fecha_nac, int telefono) {
        Persona persona = new Persona(dni, nombre, apellido, fecha_nac, telefono);
        personaDAO.insertar(persona);
    }

    public static void eliminar(String dni){
        personaDAO.eliminar(dni);
    }
}
