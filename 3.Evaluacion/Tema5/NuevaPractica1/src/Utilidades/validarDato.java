package Utilidades;

import java.time.LocalDate;
import java.util.Scanner;

public class validarDato {
    public static String validarDato(Scanner sc, String dato, String mensaje, String exp){
        boolean valido = false;
        String respuesta = "";
        do {
            System.out.println(mensaje);
            respuesta = sc.nextLine();
            if (respuesta.matches(exp)) {
                valido = true;
            }else {
                System.out.println("*"+dato+" no es valido*");
            }
        }while(!valido);
        return respuesta;
    }

    public static LocalDate validarFecha(Scanner sc, String dato, String mensaje){
        boolean valido = false;
        LocalDate fecha = null;
        do {
            System.out.println(mensaje);
            String respuesta = sc.nextLine();
            try {
                fecha = LocalDate.parse(respuesta, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                valido = true;
                if (fecha.isBefore(LocalDate.now())) {
                    System.out.println("*La fecha no puede ser anterior a la fecha actual*");
                    valido = false;
                }
            } catch (java.time.format.DateTimeParseException e) {
                System.out.println("*"+dato+" no es una fecha valida*");
            }
        }while(!valido);
        return fecha;
    }
}
