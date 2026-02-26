import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static int [][] numeros = new int[4][4];
    public static void main(String[] args) {
        menu();
    }
    public static void menu() {
        boolean terminar = true;
        do {
            try {
                System.out.print("""
                        ---MENU---
                        1. Rellenar toda la matriz de numeros, debes pedırselos al usuario.
                        2. Suma de una fila que se pedira al usuario.
                        3. Suma de una columna que se pedira al usuario.
                        4. Sumar la diagonal principal
                        5. Sumar la diagonal inversa
                        6. La media de todos los valores de la matriz.
                        7. Salir.
                        """);
                int eleccion = sc.nextInt();
                switch (eleccion) {
                    case 1:
                        rellenarNumeros();
                        break;
                    case 2:
                        sumaFila();
                        break;
                    case 3:
                        sumaColumna();
                        break;
                    case 4:
                        sumaDiagonal();
                        break;
                    case 5:
                        sumaDiagonalInversa();
                        break;
                    case 6:
                        mediaNumeros();
                        break;
                    case 7:
                        salir();
                        terminar = false;
                        break;
                    default:
                        System.out.println("Numero no valido, vuelve a introducirlo.");
                }
            }catch (Exception e) {
                System.out.println("Error en el programa.");
            }
        }while (terminar);
    }
    public static void rellenarNumeros() {
        boolean error = true;
        do {
            try {
                for (int i = 0; i < numeros.length; i++) {
                    for (int j = 0; j < numeros[i].length; j++) {
                        System.out.println("Dime el numero que quieres guardar en la posicion fila " + (i + 1) + " columna " + (j + 1) + ": ");
                        numeros[i][j] = sc.nextInt();
                    }
                }
                System.out.println("Se han guardado todos los numeros. La matriz es:");
                for (int[] numero : numeros) {
                    for (int i : numero) {
                        System.out.print(i + "  ");
                    }
                    System.out.println();
                }
                error = false;
            }catch (InputMismatchException e){
                System.out.println("El numero es incorrecto, vuelva a intentarlo");
            }
        }while (error);
    }
    public static void sumaFila() {
        boolean error = true;
        do {
            try {
                System.out.println("Dime la fila que quieres sumar:");
                int fila = sc.nextInt() - 1;
                if (fila > 3 || fila < 0) {
                    throw new numeroNoValido();
                }
                int suma = 0;
                for (int i = 0; i < numeros[fila].length; i++) {
                    suma = suma + numeros[fila][i];
                }
                System.out.println("Esta es la suma de la fila que quieres sumar: " + suma);
                error = false;
            }catch (numeroNoValido e){
                System.out.println("El numero de la fila es incorrecto, vuelva a intentarlo");
            }catch (InputMismatchException e){
                sc.nextLine();
                System.out.println("El numero es incorrecto, vuelva a intentarlo");
            }
        }while (error);
    }
    public static void sumaColumna() {
        boolean error = true;
        do {
            try {
                System.out.println("Dime la columna que quieres sumar:");
                int columna = sc.nextInt() - 1;
                if (columna > 3 || columna < 0) {
                    throw new numeroNoValido();
                }
                int suma = 0;
                for (int i = 0; i < numeros[columna].length; i++) {
                    suma = suma + numeros[i][columna];
                }
                System.out.println("Esta es la suma de la columna que quieres sumar: " + suma);
                error = false;
            }catch (numeroNoValido e){
                System.out.println("El numero de la columna es incorrecto, vuelva a intentarlo");
            }catch (InputMismatchException e){
                sc.nextLine();
                System.out.println("El numero es incorrecto, vuelva a intentarlo");
            }
        }while (error);
    }
    public static void sumaDiagonal() {
        int columna = 0;
        int suma = 0;
        for (int i = 0; i < 4; i++) {
            suma = suma + numeros[i][columna];
            columna ++;
        }
        System.out.println("Esta es la suma de la diagonal: "+suma);
    }
    public static void sumaDiagonalInversa() {
        int fila = 3;
        int suma = 0;
        for (int i = 0; i < 4; i++) {
            suma = suma + numeros[fila][i];
            fila--;
        }
        System.out.println("Esta es la suma de la diagonal inversa: "+suma);
    }
    public static void mediaNumeros() {
        int suma = 0;
        int contador = 0;
        for (int[] numero : numeros) {
            for (int i : numero) {
                suma = suma + i;
                contador++;
            }
        }
        System.out.println("Esta es la media de la matriz: "+ suma/contador);
    }
    public static void salir() {
        System.out.println("Se ha terminado el programa.");
    }
}