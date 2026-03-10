package Vista;

import Controladores.*;
import Modelo.Titular;
import Utilidades.EntradaDatos;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuTitulares {
    public static Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {
        int opcion;
        do
        {
            System.out.println("\n====== MENÚ BANCO (TITULARES)  ======");
            System.out.println("1. Crear titular");
            System.out.println("2. Modificar titular");
            System.out.println("3. Borrar titular");
            System.out.println("4. Listar titulares");
            System.out.println("5. Listar titulares por nombre");
            System.out.println("6. Buscar por ID");
            System.out.println("7. Buscar por DNI");
            System.out.println("0. Salir");
            System.out.println("========================");

            opcion = EntradaDatos.leerEntero(sc, "Elige opción: ");

            switch (opcion) {
                case 1 -> crearTitular();
                case 2 -> modificarTitular();
                case 3 -> borrarTitular();
                case 4 -> mostrarTitulares();
                case 5 -> verTitularPorNombre();
                case 6 -> verTitularPorId();
                case 7 -> verTitularPorDni();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    public static void crearTitular() {
        System.out.println("\n--- CREAR TITULAR ---");
        try
        {
            TitularController.crearTitular(
                    EntradaDatos.leerTexto(sc, "Introduce el DNI (8 dígitos y letra mayúscula): ", "^[0-9]{8}[A-Z]$"),
                    EntradaDatos.leerTexto(sc, "Introduce el nombre: ", "^[A-Za-z ]+$")
            );
        }
        catch (Exception e)
        {
            // Mensaje para el usuario para que sepa que ha habido un error al crear el titular
            System.out.println("Problemas creando el titular");
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
                    TitularController.modificarNombre(EntradaDatos.leerTexto(sc, "Nuevo nombre del titular: ", "^[A-Z][a-z ]+$"), EntradaDatos.leerTexto(sc, "DNI del titular a modificar: ", "^[0-9]{8}[A-Z]$"));
                    System.out.println("Titular modificado correctamente.");
                    break;
                case "b" :
                    TitularController.modificarDni(EntradaDatos.leerTexto(sc, "Nuevo DNI del titular: ", "^[0-9]{8}[A-Z]$"), EntradaDatos.leerTexto(sc,"DNI del titular a modificar: ", "^[0-9]{8}[A-Z]$"));
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

    public static void borrarTitular() {
        try {
            String dni = EntradaDatos.leerTexto(sc, "Ingrese el DNI del titular que desea eliminar: ", "^[0-9]{8}[A-Z]$");
            TitularController.borrarTitular(dni);
            System.out.println("Titular con DNI " + dni + " ha sido eliminado.");
        }catch (Exception e){
            System.out.println("No se ha encontrado el titular con el DNI proporcionado.");
        }
    }

    public static void mostrarTitulares() {
        ArrayList<Titular> titulares = TitularController.mostrarTitulares();
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

    public static void verTitularPorNombre() {
        ArrayList<Titular> titulares = TitularController.verTitularPorNombre(EntradaDatos.leerTexto(sc, "Ingrese el nombre del titular que desea buscar: ", "^[A-Za-z ]+$"));
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

    public static void verTitularPorId() {
        Titular titular = TitularController.verTitularPorId(EntradaDatos.leerEntero(sc, "Ingrese el ID del titular que desea ver: "));
        if (titular != null) {
            System.out.println("--- ID "+ titular.getId() + " ---");
            System.out.println("Nombre: " + titular.getNombre());
            System.out.println("DNI: " + titular.getDni());
        } else {
            System.out.println("No se ha encontrado el titular con el ID proporcionado.");
        }
    }

    public static void verTitularPorDni() {
        Titular titular = TitularController.verTitularPorDni(EntradaDatos.leerTexto(sc, "Ingrese el DNI del titular que desea ver: ", "^[0-9]{8}[A-Z]$"));
        if (titular != null) {
            System.out.println("--- ID "+ titular.getId() + " ---");
            System.out.println("Nombre: " + titular.getNombre());
            System.out.println("DNI: " + titular.getDni());
        } else {
            System.out.println("No se ha encontrado el titular con el DNI proporcionado.");
        }

    }
}

