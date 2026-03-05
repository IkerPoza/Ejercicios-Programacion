package Vista;

import Controlador.vueloController;
import Utilidades.validarDato;

import java.util.Scanner;

public class menuVuelos {
    public static Scanner sc = new Scanner(System.in);
    public static void mostrarMenu(){
        boolean continuar = true;
        do {
            System.out.print("""
                
                ╔══════════════════════════════════════╗
                ║         --- Menu Vuelos ---          ║
                ║                                      ║
                ║       1) Alta Vuelo                  ║
                ║       2) Baja Vuelo                  ║
                ║       3) Modificar Vuelo             ║
                ║       0) Volver al Menu Principal    ║
                ╚══════════════════════════════════════╝
                Que opción desea realizar?
                """);
            int opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1 -> altaVuelo();
                case 2 -> bajaVuelo();
                case 3 -> modificarVuelo();
                case 0 -> continuar = false;
                default -> System.out.println("*Opcion no valida*");
            }
        }while(continuar);
    }

    public static void altaVuelo(){
        vueloController.altaVuelo(
                validarDato.validarDato(sc,"Codigo de vuelo","Ingrese el codigo del vuelo: ","^[A-Z]{3}[0-9]-[0-9]{5}$"),
                validarDato.validarFecha(sc,"Fecha de salida","Ingrese la fecha de salida del vuelo (dd/MM/yyyy): "),
                validarDato.validarDato(sc,"Destino","Ingrese el destino del vuelo: ","^[A-Za-z ]+$"),
                validarDato.validarDato(sc,"Procedencia","Ingrese la procedencia del vuelo: ","^[A-Za-z ]+$")
        );
    }

    public static void bajaVuelo(){
        vueloController.borrarVuelo(
                validarDato.validarDato(sc,"Codigo de vuelo","Ingrese el codigo del vuelo a borrar: ","^[A-Z]{3}[0-9]-[0-9]{5}$")
        );
    }

    public static void modificarVuelo(){
        boolean continuar = true;
        do {
            System.out.print("""
                
                ╔══════════════════════════════════════╗
                ║      --- Menu Editar Vuelos ---      ║
                ║                                      ║
                ║       1) Editar Codigo               ║
                ║       2) Editar Fecha Salida         ║
                ║       3) Editar Destino              ║
                ║       4) Editar Procedencia          ║
                ║       0) Volver al Menu Vuelos       ║
                ╚══════════════════════════════════════╝
                Que opción desea realizar?
                """);
            int opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1 -> vueloController.modificarCodigo(
                        validarDato.validarDato(sc,"Codigo de vuelo","Ingrese el codigo del vuelo a modificar: ","^[A-Z]{3}[0-9]-[0-9]{5}$"),
                        validarDato.validarDato(sc,"Nuevo codigo de vuelo","Ingrese el nuevo codigo del vuelo: ","^[A-Z]{3}[0-9]-[0-9]{5}$"));
                case 2 -> vueloController.modificarFechaSalida(
                        validarDato.validarDato(sc,"Codigo de vuelo","Ingrese el codigo del vuelo a modificar: ","^[A-Z]{3}[0-9]-[0-9]{5}$"),
                        validarDato.validarFecha(sc,"Nueva fecha de salida","Ingrese la nueva fecha de salida del vuelo (dd/MM/yyyy): "));
                case 3 -> vueloController.modificarDestino(
                        validarDato.validarDato(sc,"Codigo de vuelo","Ingrese el codigo del vuelo a modificar: ","^[A-Z]{3}[0-9]-[0-9]{5}$"),
                        validarDato.validarDato(sc,"Nuevo destino","Ingrese el nuevo destino del vuelo: ","^[A-Za-z ]+$"));
                case 4 -> vueloController.modificarPrcedencia(
                        validarDato.validarDato(sc,"Codigo de vuelo","Ingrese el codigo del vuelo a modificar: ","^[A-Z]{3}[0-9]-[0-9]{5}$"),
                        validarDato.validarDato(sc,"Nueva procedencia","Ingrese la nueva procedencia del vuelo: ","^[A-Za-z ]+$"));
                case 0 -> continuar = false;
                default -> System.out.println("*Opcion no valida*");
            }
        }while(continuar);
    }
}
