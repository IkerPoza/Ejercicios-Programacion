package Vista;

import Controlador.GeneralController;
import Modelo.Cuenta;
import Modelo.Titular;
import Utilidades.validarDato;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class menuAsociar {
    public static Scanner sc = new Scanner(System.in);
    public static void mostrarMenu() {
        boolean continuar = true;
        do {
            System.out.print("""
                
                ╔══════════════════════════════════════╗
                ║        --- Menu Asociar ---          ║
                ║                                      ║
                ║     a) Crear Asociacion              ║
                ║     b) Modificar Asociacion          ║
                ║     c) Borrar Asociacion             ║
                ║     d) Mostrar Asociaciones          ║
                ║     e) Mostrar cuentas de titular    ║
                ║     f) Mostrar titulares de cuenta   ║
                ║     g) Salir                         ║
                ╚══════════════════════════════════════╝
                Que opción desea realizar?
                """);
            String opcion = sc.nextLine();
            switch (opcion) {
                case "a" -> crearAsociacion();
                case "b" -> modificarAsociacion();
                case "c" -> borrarAsociacion();
                case "d" -> mostrarAsociaciones();
                case "e" -> mostrarCuentasPorTitular();
                case "f" -> mostrarTitularesPorCuenta();
                case "g" -> continuar = false;
                default -> System.out.println("Opción no válida");
            }
        }while (continuar);
    }

    public static void crearAsociacion() {
        try {
        GeneralController.crearAsociacion(validarDato.validarDato(sc, "dni", "Ingrese el DNI del titular: ", "^[0-9]{8}[A-Z]$"), validarDato.validarDato(sc, "iban", "Ingrese el IBAN de la cuenta: ", "^[A-Z]{2}[0-9]{22}$"));
        }catch (Exception e){
            System.out.println("No se ha encontrado el titular o la cuenta con los datos proporcionados.");
        }
    }

    public static void modificarAsociacion() {
        try {
            System.out.print("""
                    --- Menu Modificar ---
                    a) Titular
                    b) Cuenta
                    c) Salir
                    """);
            String opcion = sc.nextLine();
            switch (opcion) {
                case "a" -> GeneralController.modificarAsociacionTitular(validarDato.validarDato(sc, "dni", "Ingrese el DNI del titular actual: ", "^[0-9]{8}[A-Z]$"), validarDato.validarDato(sc, "iban", "Ingrese el IBAN de la cuenta: ", "^[A-Z]{2}[0-9]{22}$"), validarDato.validarDato(sc, "dni", "Ingrese el DNI del nuevo titular: ", "^[0-9]{8}[A-Z]$"));
                case "b" -> GeneralController.modificarAsociacionCuenta(validarDato.validarDato(sc, "dni", "Ingrese el DNI del titular: ", "^[0-9]{8}[A-Z]$"), validarDato.validarDato(sc, "iban", "Ingrese el IBAN de la cuenta actual: ", "^[A-Z]{2}[0-9]{22}$"), validarDato.validarDato(sc, "iban", "Ingrese el IBAN de la nueva cuenta: ", "^[A-Z]{2}[0-9]{22}$"));
                case "c" -> System.out.println("Saliendo del menú modificar...");
                default -> System.out.println("Opción no válida");
            }
        } catch (Exception e) {
            System.out.println("No se ha encontrado la asociación con los datos proporcionados.");
        }
    }

    public static void borrarAsociacion() {
        try {
            GeneralController.borrarAsociacion(validarDato.validarDato(sc, "dni", "Ingrese el DNI del titular: ", "^[0-9]{8}[A-Z]$"), validarDato.validarDato(sc, "iban", "Ingrese el IBAN de la cuenta: ", "^[A-Z]{2}[0-9]{22}$"));
        }catch (Exception e){
            System.out.println("No se ha encontrado la asociación con los datos proporcionados.");
        }
    }

    public static void mostrarAsociaciones() {
        try {
            Map<Titular, Cuenta> asociaciones = GeneralController.mostrarAsociaciones();
            if (asociaciones.isEmpty()) {
                System.out.println("No hay asociaciones registradas.");
            }else {
                for (Map.Entry<Titular, Cuenta> asociacion : asociaciones.entrySet()) {
                    System.out.println("--- Asociación ---");
                    System.out.println("Titular: " + asociacion.getKey().getNombre() + " (DNI: " + asociacion.getKey().getDni() + ")");
                    System.out.println("Cuenta: " + asociacion.getValue().getIban() + " (Saldo: " + asociacion.getValue().getSaldo() + ")");
                }
            }
        }catch (Exception e){
            System.out.println("No se ha encontrado la asociación con los datos proporcionados.");
        }
    }

    public static void mostrarCuentasPorTitular (){
        try{
            ArrayList<Cuenta> cuentas = GeneralController.mostrarCuentasPorTitular(validarDato.validarDato(sc, "dni", "Ingrese el DNI del titular: ", "^[0-9]{8}[A-Z]$"));
            if (cuentas == null || cuentas.isEmpty()) {
                System.out.println("El titular no tiene cuentas asociadas o no existe el titular.");
            }else {
                System.out.println("--- Cuentas asociadas al titular ---");
                for (Cuenta cuenta : cuentas) {
                    System.out.println("- " + cuenta.getIban() + " (Saldo: " + cuenta.getSaldo() + ")");
                }
            }
        } catch (Exception e) {
            System.out.println("No se ha encontrado el titular con los datos proporcionados.");
        }
    }

    public static void mostrarTitularesPorCuenta(){
        try {
            ArrayList<Titular> titulares = GeneralController.mostrarTitularesPorCuenta(validarDato.validarDato(sc, "iban", "Ingrese el IBAN de la cuenta: ", "^[A-Z]{2}[0-9]{22}$"));
            if (titulares == null || titulares.isEmpty()) {
                System.out.println("La cuenta no tiene titulares asociados o no existe la cuenta.");
            } else {
                System.out.println("--- Titulares asociados a la cuenta ---");
                for (Titular titular : titulares) {
                    System.out.println("- " + titular.getNombre() + " (DNI: " + titular.getDni() + ")");
                }
            }
        } catch (Exception e) {
            System.out.println("No se ha encontrado la cuenta con los datos proporcionados.");
        }
    }
}