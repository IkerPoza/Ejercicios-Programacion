package Vista;

import Controladores.CuentaController;
import Controladores.TitularController;
import Modelo.Cuenta;
import Modelo.Titular;
import Utilidades.EntradaDatos;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuCuentas {
    public static Scanner sc = new Scanner(System.in);
    public static void mostrarMenu() throws Exception {
        boolean continuar = true;
        do {
            System.out.print("""
                
                ╔══════════════════════════════════════╗
                ║        --- Menu Cuenta ---           ║
                ║                                      ║
                ║       a) Crear cuenta                ║
                ║       b) Borrar cuenta               ║
                ║       c) Modificar saldo             ║
                ║       d) Mostrar cuentas             ║
                ║       e) Ver cuenta por ID           ║
                ║       f) Ver cuenta por IBAN         ║
                ║       g) Ver cuenta por saldo        ║
                ║       h) Salir                       ║
                ╚══════════════════════════════════════╝
                Que opción desea realizar?
                """);
            String opcion = sc.nextLine();
            switch (opcion) {
                case "a" -> crearCuenta();
                case "b" -> borrarCuenta();
                case "c" -> modificarSaldo();
                case "d" -> mostrarCuentas();
                case "e" -> verCuentaPorId();
                case "f" -> verCuentaPorIban();
                case "g" -> verCuentaPorSaldo();
                case "h" -> continuar = false;
                default -> System.out.println("Opción no válida");
            }
        }while (continuar);
    }

    public static void crearCuenta(){
        Titular titular = TitularController.verTitularPorDni(EntradaDatos.leerTexto(sc, "Ingrese el DNI del titular de la cuenta a crear: ", "^[0-9]{8}[A-Z]$"));
        CuentaController.crearCuenta(titular, EntradaDatos.leerTexto(sc, "Ingrese el IBAN de la cuenta: ", "^[A-Z]{2}[0-9]{22}$"), EntradaDatos.leerTexto(sc,"Ingrese el saldo inicial de la cuenta: ", "^[0-9]+$"));
    }

    public static void borrarCuenta() throws Exception {
        CuentaController.borrarCuenta(EntradaDatos.leerTexto(sc,  "Ingrese el IBAN de la cuenta que desea eliminar: ", "^[A-Z]{2}[0-9]{22}$"));
    }

    public static void modificarSaldo() throws Exception {
        String iban = EntradaDatos.leerTexto(sc, "Ingrese el IBAN de la cuenta que desea modificar: ", "^[A-Z]{2}[0-9]{22}$");
        String nuevoSaldo = EntradaDatos.leerTexto(sc,"Ingrese el nuevo saldo de la cuenta: ", "^[0-9]+$");
        CuentaController.modificarSaldo(iban, nuevoSaldo);
    }

    public static void mostrarCuentas() {
        ArrayList<Cuenta> cuentas = CuentaController.mostrarCuentas();
        if (cuentas.isEmpty()) {
            System.out.println("No hay cuentas registradas.");
        }else {
            for (Cuenta cuenta : cuentas) {
                System.out.println("--- ID " + cuenta.getId() + " ---");
                System.out.println("IBAN: " + cuenta.getIban());
                System.out.println("Saldo: " + cuenta.getSaldo());
            }
        }
    }

    public static void verCuentaPorId() throws Exception {
        Cuenta cuenta = CuentaController.verCuentaPorId(Integer.parseInt(EntradaDatos.leerTexto(sc, "Ingrese el ID de la cuenta que desea ver: ", "^[0-9]+$")));
        System.out.println("--- ID "+ cuenta.getId() + " ---");
        System.out.println("IBAN: " + cuenta.getIban());
        System.out.println("Saldo: " + cuenta.getSaldo());
    }

    public static void verCuentaPorIban() throws Exception {
        Cuenta cuenta = CuentaController.verCuentaPorIban(EntradaDatos.leerTexto(sc, "Ingrese el IBAN de la cuenta que desea ver: ", "^[A-Z]{2}[0-9]{22}$"));
        System.out.println("--- ID "+ cuenta.getId() + " ---");
        System.out.println("IBAN: " + cuenta.getIban());
        System.out.println("Saldo: " + cuenta.getSaldo());
    }

    public static void verCuentaPorSaldo() throws Exception {
        ArrayList<Cuenta> cuentas = CuentaController.mostrarCuentasPorSaldo(Integer.parseInt(EntradaDatos.leerTexto(sc, "Ingrese el saldo mínimo de las cuentas que desea ver: ", "^[0-9]+$")));
        if (cuentas.isEmpty()) {
            System.out.println("No hay cuentas con el saldo mínimo especificado.");
        }else {
            for (Cuenta cuenta : cuentas) {
                System.out.println("--- ID " + cuenta.getId() + " ---");
                System.out.println("IBAN: " + cuenta.getIban());
                System.out.println("Saldo: " + cuenta.getSaldo());
            }
        }
    }
}
