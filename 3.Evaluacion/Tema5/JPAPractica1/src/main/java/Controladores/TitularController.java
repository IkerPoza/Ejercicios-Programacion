package Controladores;

import DAO.*;
import Modelo.Titular;

import java.util.ArrayList;


public class TitularController {
    public static void crearTitular(String dni, String nombre) {
        Titular titular = new Titular(dni, nombre);
        TitularDAO.insertar(titular);
    }

    public static void modificarNombre(String nombre, String dni) {
        Titular titular = TitularDAO.buscarTitularPorDni(dni);
        if (titular != null) {
            titular.setNombre(nombre);
            TitularDAO.modificarTitular(titular);
        }
    }

    public static void modificarDni(String nuevoDni, String dni) {
        Titular titular = TitularDAO.buscarTitularPorDni(dni);
        if (titular != null) {
            titular.setDni(nuevoDni);
            TitularDAO.modificarTitular(titular);
        }
    }

    public static void borrarTitular(String dni) {
        TitularDAO.borrarTitular(dni);
    }

    public static ArrayList<Titular> mostrarTitulares() {
        return TitularDAO.listarTitulares();
    }

    public static ArrayList<Titular> verTitularPorNombre(String nombre) {
        return TitularDAO.listarTitularesPorNombre(nombre);
    }

    public static Titular verTitularPorId(int id) {
        return TitularDAO.buscarTitularPorId(id);
    }

    public static Titular verTitularPorDni(String dni) {
        return TitularDAO.buscarTitularPorDni(dni);
    }
}

