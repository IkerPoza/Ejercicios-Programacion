package Vista;

import java.util.Scanner;

public class menuPrincipal {
    public static Scanner sc = new Scanner(System.in);
    public static void mostrarMenu() throws Exception {
        boolean continuar = true;
        do {
            System.out.print("""
                
                ╔══════════════════════════════════════╗
                ║        --- Menu Principal ---        ║
                ║                                      ║
                ║       a) Menu Titular                ║
                ║       b) Menu Cuenta                 ║
                ║       c) Salir                       ║
                ╚══════════════════════════════════════╝
                Que opción desea realizar?
                """);
            String opcion = sc.nextLine();
            switch (opcion) {
                case "a" -> menuTitular.mostrarMenu();
                case "b" -> menuCuenta.mostrarMenu();
                case "c" -> continuar = false;
                default -> System.out.println("Opción no válida");
            }
        }while (continuar);
    }

}
