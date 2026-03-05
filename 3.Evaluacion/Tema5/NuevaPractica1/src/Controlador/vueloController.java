package Controlador;

import DAO.vueloDAO;
import Modelo.Vuelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class vueloController {
    public static void altaVuelo(String codVuelo, LocalDate fechaSalida, String destino, String prcedencia) {
        Vuelo vuelo = new Vuelo(codVuelo, fechaSalida,destino,prcedencia);
        vueloDAO.altaVuelo(vuelo);
    }

    public static void borrarVuelo(String codVuelo) {
        vueloDAO.bajaVuelo(codVuelo);
    }

    public static void modificarCodigo(String codVuelo, String nuevoCodigo) {
        vueloDAO.modificarCodigo(codVuelo, nuevoCodigo);
    }

    public static void modificarFechaSalida(String codVuelo, LocalDate nuevaFecha) {
        vueloDAO.modificarFechaSalida(codVuelo, nuevaFecha);
    }

    public static void modificarDestino(String codVuelo, String nuevoDestino) {
        vueloDAO.modificarDestino(codVuelo, nuevoDestino);
    }

    public static void modificarPrcedencia(String codVuelo, String nuevoPrcedencia) {
        vueloDAO.modificarProcedencia(codVuelo, nuevoPrcedencia);
    }

    public static Vuelo buscarVuelo(String codVuelo) {
        return vueloDAO.buscarVuelo(codVuelo);
    }

    public static ArrayList<Vuelo> vueloDestino(String destino) {
        return vueloDAO.vueloDestino(destino);
    }

    public static ArrayList<Vuelo> vueloProcedencia(String procedencia) {
        return vueloDAO.vueloProcedencia(procedencia);
    }

    public static ArrayList<Vuelo> vueloFechaSalida(LocalDate fechaSalida) {
        return vueloDAO.vueloFechaSalida(fechaSalida);
    }
}
