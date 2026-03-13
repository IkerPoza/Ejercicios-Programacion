package Utilidades;

import java.util.Scanner;

public class validarDato {
    public static String validarDato(Scanner sc, String dato, String mensaje, String exp) {
        boolean valido = false;
        String resultado = "";
        do {
            System.out.print(mensaje);
            resultado = sc.nextLine();
            if (resultado.matches(exp)) {
                valido = true;
            } else {
                System.out.println(dato+" no válido, por favor ingrese un dato correcto.");
            }
        }while (!valido);
        return  resultado;
    }
}
