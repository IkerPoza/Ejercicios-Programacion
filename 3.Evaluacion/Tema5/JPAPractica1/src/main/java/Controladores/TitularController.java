package Controladores;

import DAO.*;
import Modelo.Titular;

import java.util.List;

public class TitularController {
    public static void crearTitular(String dni, String nombre) {
        Titular titular = new Titular(dni, nombre);
        TitularDAO.insertar(titular);
    }

}

