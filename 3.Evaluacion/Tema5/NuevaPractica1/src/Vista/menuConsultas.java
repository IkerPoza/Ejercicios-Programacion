package Vista;

import Controlador.pasajeroController;
import Controlador.vueloController;
import Controlador.jefeController;
import Modelo.Pasajero;
import Modelo.Vuelo;
import Utilidades.validarDato;

import java.util.ArrayList;
import java.util.Scanner;


public class menuConsultas {
    public static Scanner sc = new Scanner(System.in);
    public static void mostrarMenu(){
        boolean continuar = true;
        do {
            try {
                System.out.print("""
                    \n╔═════════════════════════════════════════╗
                    ║          --- Menu Consultas ---         ║
                    ║                                         ║
                    ║       1) Consulta Vuelo                 ║
                    ║       2) Consulta Pasajero              ║
                    ║       3) Vuelos por destino             ║
                    ║       4) Vuelos por origen              ║
                    ║       5) Vuelo por pasajero             ║
                    ║       6) Lista de pasajeros por vuelo   ║
                    ║       7) Lista de vuelos por fecha      ║
                    ║       0) Volver al Menu Principal       ║
                    ╚═════════════════════════════════════════╝
                    Que opción desea realizar?
                    """);
                int opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1 -> consultaVuelo();
                    case 2 -> consultaPasajero();
                    case 3 -> consultaVuelosPorDestino();
                    case 4 -> consultarVuelosPorOrigen();
                    case 5 -> consultarVueloPorPasajero();
                    case 6 -> listaPasajerosPorVuelo();
                    case 7 -> listaVuelosPorFecha();
                    case 0 -> continuar = false;
                    default -> System.out.println("*Opcion no valida*");
                }
            }catch (NumberFormatException e){
                System.out.println("*Opcion no valida*");
            }
        }while (continuar);
    }

    public static void consultaVuelo(){
        Vuelo vuelo = vueloController.buscarVuelo(validarDato.validarDato(sc,"Codigo Vuelo","Introduce el codigo del vuelo a consultar: ", "^[A-Z]{3}[0-9]-[0-9]{5}$"));
            if (vuelo != null) {
                System.out.println("Vuelo encontrado: " + vuelo);
            } else {
                System.out.println("Vuelo no encontrado.");
            }
    }

    public static void consultaPasajero(){
        Pasajero pasajero = pasajeroController.buscarPasajero(
                validarDato.validarDato(sc,"DNI","Introduce el DNI del pasajero a consultar: ", "^[0-9]{8}[A-Z]$"));
        if (pasajero != null) {
            System.out.println("Pasajero encontrado: " + pasajero);
        } else {
            System.out.println("Pasajero no encontrado.");
        }
    }

    public static void consultaVuelosPorDestino(){
        ArrayList<Vuelo> vuelos = vueloController.vueloDestino(
                validarDato.validarDato(sc,"Destino","Introduce el destino a consultar: ", "^[A-Za-z ]+$"));
        if (!vuelos.isEmpty()) {
            System.out.println("Vuelos encontrados:");
            for (Vuelo vuelo : vuelos) {
                System.out.print(vuelo);
            }
        }else {
            System.out.println("No se encontraron vuelos para el destino especificado.");
        }
    }

    public static void consultarVuelosPorOrigen(){
        ArrayList<Vuelo> vuelos = vueloController.vueloProcedencia(
                validarDato.validarDato(sc,"Procedencia","Introduce la procedencia a consultar: ", "^[A-Za-z ]+$"));
        if (!vuelos.isEmpty()) {
            System.out.println("Vuelos encontrados:");
            for (Vuelo vuelo : vuelos) {
                System.out.print(vuelo);
            }
        }else {
            System.out.println("No se encontraron vuelos para la procedencia especificada.");
        }
    }

    public static void consultarVueloPorPasajero(){
        Vuelo vuelo = jefeController.vueloPorPasajero(
                validarDato.validarDato(sc,"DNI","Introduce el DNI del pasajero a consultar su vuelo: ", "^[0-9]{8}[A-Z]$"));
        if (vuelo != null) {
            System.out.println("Vuelo encontrado: " + vuelo);
        } else {
            System.out.println("No se encontró un vuelo para el pasajero especificado.");
        }
    }

    public static void listaPasajerosPorVuelo(){
        ArrayList<Pasajero> pasajeros = jefeController.pasajerosPorVuelo(
                validarDato.validarDato(sc,"Codigo Vuelo","Introduce el codigo del vuelo a consultar sus pasajeros: ", "^[A-Z]{3}[0-9]-[0-9]{5}$"));
        if (!pasajeros.isEmpty()) {
            System.out.println("Pasajeros encontrados:");
            for (Pasajero pasajero : pasajeros) {
                System.out.print(pasajero);
            }
        }else {
            System.out.println("No se encontraron pasajeros para el vuelo especificado.");
        }
    }

    public static void listaVuelosPorFecha(){
        ArrayList<Vuelo> vuelos = vueloController.vueloFechaSalida(
                validarDato.validarFecha(sc,"Fecha Salida","Introduce la fecha de salida a consultar (dd/MM/yyyy): ")
        );
        if (!vuelos.isEmpty()) {
            System.out.println("Vuelos encontrados:");
            for (Vuelo vuelo : vuelos) {
                System.out.print(vuelo);
            }
        }else {
            System.out.println("No se encontraron vuelos para la fecha de salida especificada.");
        }
    }
}
