package Controlador;

import Modelo.Pasajero;
import Modelo.Vuelo;

import java.util.ArrayList;

public class jefeController {
    public static Vuelo vueloPorPasajero(String dni) {
        return vueloController.buscarVuelo(pasajeroController.buscarPasajero(dni).getVuelo());
    }

    public static ArrayList<Pasajero> pasajerosPorVuelo(String codVuelo) {
        ArrayList<Pasajero> pasajeros = new ArrayList<>();
        for (Pasajero pasajero : pasajeroController.buscarPasajeros()) {
            if (pasajero.getVuelo().equals(codVuelo)) {
                pasajeros.add(pasajero);
            }
        }
        return pasajeros;
    }
}
