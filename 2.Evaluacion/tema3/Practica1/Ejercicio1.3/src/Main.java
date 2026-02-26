import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[] listaLetras = new char[26];
        for (int i = 0; i < 26; i++) {
            listaLetras[i] = (char) ('A' + i);
        }
        anadirLetra(listaLetras);
    }
    public static void anadirLetra(char[] listaLetras) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;
        StringBuilder resultado = new StringBuilder();
        do {
            try {
                System.out.println("Dime la posicion que quieres añadir: ");
                int posicion = sc.nextInt();
                if (posicion == -1) {
                    continuar = false;
                }else {
                    resultado.append(listaLetras[posicion]);
                }
            }catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("El numero es invalido, vuelva a intentarlo");
                sc.nextLine();
            }
        }while (continuar);
        System.out.println("Cadena resultante: "+resultado);
    }
}