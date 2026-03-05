package Vista;

import java.util.Scanner;

public class menuPrincipal {
    public static Scanner sc = new Scanner(System.in);
    public static void mostrarMenu() {
        boolean continuar = true;
        do {
            System.out.print("""
                
                ╔══════════════════════════════════════╗
                ║        --- Menu Principal ---        ║
                ║                                      ║
                ║       1) Menu Vuelos                 ║
                ║       2) Menu Pasajeros              ║
                ║       3) Consultas                   ║
                ║       0) Salir                       ║
                ╚══════════════════════════════════════╝
                Que opción desea realizar?
                """);
            int opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1 -> menuVuelos.mostrarMenu();
                case 2 -> menuPasajeros.mostrarMenu();
                case 3 -> menuConsultas.mostrarMenu();
                case 0 -> continuar = false;
                default -> System.out.println("*Opcion no valida*");
            }
        }while(continuar);
    }
}
