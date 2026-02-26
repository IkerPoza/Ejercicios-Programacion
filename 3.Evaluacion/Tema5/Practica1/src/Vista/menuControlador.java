package Vista;

import Controlador.TitularController;
import Modelo.Titular;
import Utilidades.validarDato;

import java.util.ArrayList;
import java.util.Scanner;

public class menuControlador {
    public static Scanner sc = new Scanner(System.in);
    public static void mostrarMenu() {
        boolean continuar = true;
        do {
            System.out.print("""
                
                ╔══════════════════════════════════════╗
                ║        --- Menu Opciones ---         ║
                ║                                      ║
                ║       a) Crear titular               ║
                ║       b) Borrar titular              ║
                ║       c) Modificar titular           ║
                ║       d) Mostrar titulares           ║
                ║       e) Ver titular por ID          ║
                ║       f) Ver titular por Nombre      ║
                ║       g) Ver titular por DNI         ║
                ║       h) Salir                       ║
                ╚══════════════════════════════════════╝
                Que opción desea realizar?
                """);
            String opcion = sc.nextLine();
            switch (opcion) {
                case "a" -> crearTitular();
                case "b" -> borrarTitular();
                case "c" -> modificarTitular();
                case "d" -> mostrarTitulares();
                case "e" -> verTitularPorId();
                case "f" -> verTitularPorNombre();
                case "g" -> verTitularPorDni();
                case "h" -> continuar = false;
                default -> System.out.println("Opción no válida");
            }
        }while (continuar);

    }

    public static  void crearTitular() {
        String nombre = validarDato.validarDato(sc, "nombre", "Ingrese el nombre del titular: ", "^[A-Z][a-z]+$");
        String dni = validarDato.validarDato(sc, "dni", "Ingrese el DNI del titular: ", "^[0-9]{8}[A-Z]$");
        TitularController.crearTitular(nombre, dni);
    }

    public static void borrarTitular() {
        try {
            String dni = validarDato.validarDato(sc, "dni", "Ingrese el DNI del titular que desea eliminar: ", "^[0-9]{8}[A-Z]$");
            TitularController.borrarTitular(dni);
            System.out.println("Titular con DNI " + dni + " ha sido eliminado.");
        }catch (Exception e){
            System.out.println("No se ha encontrado el titular con el DNI proporcionado.");
        }
    }

    public static void modificarTitular() {
        try {
            System.out.print("""
                    --- Menu Modificar ---
                    a) Nombre
                    b) DNI
                    c) Salir
                    """);
            String opcion = sc.nextLine();
            switch (opcion) {
                case "a" :
                    TitularController.modificarNombre(validarDato.validarDato(sc, "nombre", "Nuevo nombre del titular: ", "^[A-Z][a-z]+$"), validarDato.validarDato(sc, "dni", "DNI del titular a modificar: ", "^[0-9]{8}[A-Z]$"));
                    System.out.println("Titular modificado correctamente.");
                    break;
                case "b" :
                    TitularController.modificarDni(validarDato.validarDato(sc, "dni", "Nuevo DNI del titular: ", "^[0-9]{8}[A-Z]$"), validarDato.validarDato(sc, "dni", "DNI del titular a modificar: ", "^[0-9]{8}[A-Z]$"));
                    System.out.println("Titular modificado correctamente.");
                    break;
                case "c" :
                    System.out.println("Saliendo del menú de modificación.");
                    break;
                default :
                    System.out.println("Opción no válida");
                    break;
            }
        }catch (Exception e){
            System.out.println("No se ha encontrado el titular con el DNI proporcionado.");
        }
    }

    public static void mostrarTitulares() {
        ArrayList<Titular> titulares = new ArrayList<Titular>();
        TitularController.mostrarTitulares(titulares);
        if (titulares.isEmpty()) {
            System.out.println("No hay titulares para mostrar.");
        }else{
        for (Titular titular : titulares) {
            System.out.println("--- ID "+ titular.getId() + " ---");
            System.out.println("Nombre: " + titular.getNombre());
            System.out.println("DNI: " + titular.getDni());
        }
        }
    }

    public static void verTitularPorId() {
        Titular titular = TitularController.verTitularPorId(Integer.parseInt(validarDato.validarDato(sc, "id", "Ingrese el ID del titular que desea ver: ", "^[0-9]+$")));
        if (titular != null) {
            System.out.println("--- ID "+ titular.getId() + " ---");
            System.out.println("Nombre: " + titular.getNombre());
            System.out.println("DNI: " + titular.getDni());
        } else {
            System.out.println("No se ha encontrado el titular con el ID proporcionado.");
        }
    }

    public static void verTitularPorNombre() {
        ArrayList<Titular> titulares = new ArrayList<>();
        TitularController.verTitularPorNombre(validarDato.validarDato(sc, "nombre", "Ingrese el nombre del titular que desea ver: ", "^[A-Z][a-z]+$"), titulares);
        if (titulares.isEmpty()) {
            System.out.println("No se ha encontrado ningún titular con el nombre proporcionado.");
        } else {
            for (Titular titular : titulares) {
                System.out.println("--- ID "+ titular.getId() + " ---");
                System.out.println("Nombre: " + titular.getNombre());
                System.out.println("DNI: " + titular.getDni());
            }
        }
    }

    public static void  verTitularPorDni() {
        Titular titular = TitularController.verTitularPorDni(validarDato.validarDato(sc, "dni", "Ingrese el DNI del titular que desea ver: ", "^[0-9]{8}[A-Z]$"));
        if (titular != null) {
            System.out.println("--- ID "+ titular.getId() + " ---");
            System.out.println("Nombre: " + titular.getNombre());
            System.out.println("DNI: " + titular.getDni());
        } else {
            System.out.println("No se ha encontrado el titular con el DNI proporcionado.");
        }

    }
}
