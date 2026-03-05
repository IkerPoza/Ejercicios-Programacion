package Controlador;

import Modelo.Pasajero;
import Modelo.Vuelo;

import java.util.ArrayList;

public class jefeController {
    public static Vuelo vueloPorPasajero(String dni) {
        return vueloController.buscarVuelo(pasajeroController.buscarPasajero(dni).getVuelo());
    }
}
