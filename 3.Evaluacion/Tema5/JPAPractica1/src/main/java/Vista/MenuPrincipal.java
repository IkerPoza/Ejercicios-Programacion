package Vista;

import java.util.Scanner;

public class MenuPrincipal {
    public static Scanner sc = new Scanner(System.in);
    public static void mostrarMenu() {
        boolean continuar = true;
        do {
            try {
                System.out.print("""
                
                ╔══════════════════════════════════════╗
                ║        --- Menu Principal ---        ║
                ║                                      ║
                ║       a) Menu Titular                ║
                ║       b) Menu Cuenta                 ║
                ║       d) Salir                       ║
                ╚══════════════════════════════════════╝
                Que opción desea realizar?
                """);
                String opcion = sc.nextLine();
                switch (opcion) {
                    case "a" -> MenuTitulares.mostrarMenu();
                    case "b" -> MenuCuentas.mostrarMenu();
                    case "d" -> continuar = false;
                    default -> System.out.println("Opción no válida");
                }
            }catch(Exception e) {
                System.out.println(e.getMessage());
            }

        }while (continuar);
    }
}
