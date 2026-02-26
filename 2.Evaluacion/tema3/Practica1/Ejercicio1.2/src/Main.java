import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean error = true;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Cuantos numeros aleatorios quieres guardar?");
                int numeros = sc.nextInt();
                int[] listanumeros = new int[numeros];
                generarListanumeros(listanumeros);
                mostrasResultados(listanumeros);
                error = false;
            }catch (Exception e) {
                System.out.println("El numero es incorrecto, vuelve a intentarlo");
            }
        }while (error);
    }
    public static void generarListanumeros(int[] listanumeros) {
        for (int i = 0; i < listanumeros.length; i++) {
            listanumeros[i] = (int) (Math.random() * 101);
        }
    }
    public static void mostrasResultados(int[] listanumeros) {
        System.out.println("Estos son los numeros: " + Arrays.toString(listanumeros));
        int total = Arrays.stream(listanumeros).sum();
        System.out.println("El total es " + total);
    }
}