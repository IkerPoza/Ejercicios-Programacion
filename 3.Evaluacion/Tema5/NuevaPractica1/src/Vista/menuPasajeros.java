package Vista;

import Controlador.pasajeroController;
import Utilidades.validarDato;

import java.util.Scanner;

public class menuPasajeros {
    public static Scanner sc = new Scanner(System.in);
    public static void mostrarMenu(){
            boolean continuar = true;
            do {
                try {
                    System.out.print("""
                            
                            ╔══════════════════════════════════════╗
                            ║        --- Menu Pasajeros ---        ║
                            ║                                      ║
                            ║       1) Alta Pasajero               ║
                            ║       2) Baja Pasajero               ║
                            ║       3) Modificar Pasajero          ║
                            ║       0) Volver al Menu Principal    ║
                            ╚══════════════════════════════════════╝
                            Que opción desea realizar?
                            """);
                    int opcion = Integer.parseInt(sc.nextLine());
                    switch (opcion) {
                        case 1 -> pasajeroController.altaPasajero(
                                validarDato.validarDato(sc, "DNI", "Ingrese el DNI del pasajero: ", "^[0-9]{8}[A-Z]$"),
                                validarDato.validarDato(sc, "Nombre", "Ingrese el nombre del pasajero: ", "^[A-Za-z ]+$"),
                                validarDato.validarDato(sc, "Telefono", "Ingrese el telefono del pasajero: ", "^[0-9]{9}$"),
                                validarDato.validarDato(sc, "Codigo de vuelo", "Ingrese el codigo del vuelo del pasajero: ", "^[A-Z]{3}[0-9]-[0-9]{5}$")
                        );
                        case 2 -> pasajeroController.bajaPasajero(
                                validarDato.validarDato(sc, "DNI", "Ingrese el DNI del pasajero a borrar: ", "^[0-9]{8}[A-Z]$"));
                        case 3 -> modificarPasajero();
                        case 0 -> continuar = false;
                        default -> System.out.println("*Opcion no valida*");
                    }
                }catch (NumberFormatException e) {
                    System.out.println("*Opcion no valida*");
                }
            }while(continuar);
    }

    public static void modificarPasajero(){
        boolean continuar = true;
        do {
            try {
                System.out.print("""
                        
                        ╔══════════════════════════════════════╗
                        ║    --- Menu Editar Pasajeros ---     ║
                        ║                                      ║
                        ║       1) Editar DNI                  ║
                        ║       2) Editar Nombre               ║
                        ║       3) Editar Telefono             ║
                        ║       4) Editar Codigo de Vuelo      ║
                        ║       0) Volver al Menu Pasajero     ║
                        ╚══════════════════════════════════════╝
                        Que opción desea realizar?
                        """);
                int opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1 -> pasajeroController.modificarDni(
                            validarDato.validarDato(sc, "DNI", "Ingrese el DNI del pasajero a modificar: ", "^[0-9]{8}[A-Z]$"),
                            validarDato.validarDato(sc, "DNI", "Ingrese el nuevo DNI del pasajero: ", "^[0-9]{8}[A-Z]$"));
                    case 2 -> pasajeroController.modificarNombre(
                            validarDato.validarDato(sc, "DNI", "Ingrese el DNI del pasajero a modificar: ", "^[0-9]{8}[A-Z]$"),
                            validarDato.validarDato(sc, "Nombre", "Ingrese el nuevo nombre del pasajero: ", "^[A-Za-z ]+$"));
                    case 3 -> pasajeroController.modificarTelefono(
                            validarDato.validarDato(sc, "DNI", "Ingrese el DNI del pasajero a modificar: ", "^[0-9]{8}[A-Z]$"),
                            validarDato.validarDato(sc, "Telefono", "Ingrese el nuevo telefono del pasajero: ", "^[0-9]{9}$"));
                    case 4 -> pasajeroController.modificarVuelo(
                            validarDato.validarDato(sc, "DNI", "Ingrese el DNI del pasajero a modificar: ", "^[0-9]{8}[A-Z]$"),
                            validarDato.validarDato(sc, "Codigo de vuelo", "Ingrese el nuevo codigo de vuelo del pasajero: ", "^[A-Z]{3}[0-9]-[0-9]{5}$"));
                    case 0 -> continuar = false;
                    default -> System.out.println("*Opcion no valida*");
                }
            }catch (NumberFormatException e){
                System.out.println("*Opcion no valida*");
            }
        } while (continuar) ;
    }
}
