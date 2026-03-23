package Utilidades;

import java.util.Scanner;

public class ValidarDato {
    public static String validarDato(String valor, String dato, String exp){
        if (valor.matches(exp)) {
            return valor;
        } else {
            return null;
        }
    }
}
