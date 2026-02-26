import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static int[][][] temperaturas;
    public static String[] ciudades;
    public static void main(String[] args) {
        int ciudad = datosCiudades();
        int dias = datosDias();
        temperaturas = new int[ciudad][dias][3];
        pedirTemperatura();
        ciudadMedia();
        diasMedia();
    }
    public static int datosCiudades() {
        boolean error = false;
        int ciudad = 0;
        do {
            try {
                System.out.println("Dime el numero de ciudades:");
                ciudad = sc.nextInt();
                sc.nextLine();
                if (ciudad < 0) {
                    throw new datoNoValido();
                }
                ciudades = new String[ciudad];
                for (int c = 0; c < ciudad; c++) {
                    System.out.println("Dime el nombre de la ciudad:");
                    ciudades[c] = sc.nextLine();
                }
                error = true;
            } catch (datoNoValido | InputMismatchException e) {
                System.out.println("El numero introducido no es valido, vuelva a intentarlo");
            }
        } while (!error);
        return ciudad;
    }
    public static int datosDias() {
        boolean error = false;
        int dias = 0;
        do {
            try {
                System.out.println("Dime el numero de dias:");
                dias = sc.nextInt();
                if (dias <= 0) {
                    throw new datoNoValido();
                }
                error = true;
            } catch (datoNoValido | InputMismatchException e) {
                System.out.println("El numero introducido no es valido, vuelva a intentarlo");
            }
        } while (!error);
        return dias;
    }
    public static void pedirTemperatura() {
        for (int c = 0; c < temperaturas.length; c++) {
            for (int d = 0; d < temperaturas[c].length; d++) {
                for (int h = 0; h < temperaturas[c][d].length; h++) {
                    boolean error = false;
                    do {
                        try {
                            sc.nextLine();
                            System.out.println("Dime la temperatura de " + ciudades[c] + " del dia " + (d + 1) + " de la hora " + h + ":");
                            temperaturas[c][d][h] = sc.nextInt();
                            error = true;
                        }catch (InputMismatchException e) {
                            System.out.println("El dato introducido no es valido, vuelva a intentarlo");
                        }
                    }while (!error) ;
                }
            }
        }
    }
    public static void ciudadMedia() {
        for (int c = 0; c < temperaturas.length; c++) {
            int suma = 0;
            int cantidad = 0;
            for (int d = 0; d < temperaturas[d].length; d++) {
                for (int h = 0; h < temperaturas[c][d].length; h++) {
                    suma += temperaturas[c][d][h];
                    cantidad++;
                }
            }
            System.out.println("La temperatura media de " + ciudades[c] + " es: " + (suma/cantidad));
        }
    }
    public  static void diasMedia() {
        for (int d = 0; d < temperaturas[0].length; d++) {
            int suma = 0;
            int cantidad = 0;
            for (int c = 0; c < temperaturas.length; c++) {
                for (int h = 0; h < temperaturas[c][d].length; h++) {
                    suma += temperaturas[c][d][h];
                    cantidad++;
                }
            }
            System.out.println("La temperatura media del dia "+ (d+1) + " es: " + (suma/cantidad));
        }
    }
}