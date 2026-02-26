package Controlador;

import DAO.TitularDAO;
import Modelo.Titular;

import java.util.ArrayList;

public class TitularController {
    public static void crearTitular(String nombre, String dni) {
        Titular titular = new Titular(nombre, dni);
        TitularDAO.crearTitular(titular);
    }

    public static void borrarTitular(String dni) throws Exception{
        TitularDAO.borrarTitular(dni);
    }

    public static void modificarNombre(String nuevoNombre, String dni) throws Exception{
        TitularDAO.modificarNombre(nuevoNombre, dni);
    }

    public static void modificarDni(String dni, String dni1) throws Exception{
        TitularDAO.modificarDni(dni, dni1);
    }

    public static void mostrarTitulares(ArrayList<Titular> titulares) {
        TitularDAO.mostrarTitulares(titulares);
    }

    public static Titular verTitularPorId(int id) {
        return  TitularDAO.verTitularPorId(id);
    }

    public static void verTitularPorNombre(String nombre, ArrayList<Titular> titulares) {
        TitularDAO.verTitularPorNombre(nombre, titulares);
    }

    public static Titular verTitularPorDni(String dni) {
        return TitularDAO.verTitularPorDni(dni);
    }

}
