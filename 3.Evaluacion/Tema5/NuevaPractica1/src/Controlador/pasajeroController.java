package Controlador;

import DAO.pasajeroDAO;
import Modelo.Pasajero;

import java.util.ArrayList;

public class pasajeroController {
    public static void altaPasajero(String dni, String nombre, String telefono, String codVuelo) {
        Pasajero pasajero = new Pasajero(dni, nombre, telefono, codVuelo);
        pasajeroDAO.altaPasajero(pasajero);
    }

    public static void bajaPasajero(String dni) {
        pasajeroDAO.bajaPasajero(dni);
    }

    public static void modificarDni(String dni, String nuevoDni) {
        pasajeroDAO.modificarDni(dni, nuevoDni);
    }

    public static void modificarNombre(String dni, String nuevoNombre) {
        pasajeroDAO.modificarNombre(dni, nuevoNombre);
    }

    public static void modificarTelefono(String dni, String nuevoTelefono) {
        pasajeroDAO.modificarTelefono(dni, nuevoTelefono);
    }

    public static void modificarVuelo(String dni, String nuevoCodVuelo) {
        pasajeroDAO.modificarVuelo(dni, nuevoCodVuelo);
    }

    public static Pasajero buscarPasajero(String dni) {
        return pasajeroDAO.buscarPasajero(dni);
    }

    public static ArrayList<Pasajero> buscarPasajeros() {
        return pasajeroDAO.buscarPasajeros();
    }
}
