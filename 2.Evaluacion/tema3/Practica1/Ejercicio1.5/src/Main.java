import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime el texto que quieres escanear:");
        String texto = sc.nextLine();
        comprobar(texto);
    }
    public static void comprobar (String texto) {
        texto = texto.toLowerCase();
        texto = texto.replace(" ", "");
        char[] listaLetras = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int[] contadorLetras = new int[listaLetras.length];
        for (int i = 0; i < texto.length(); i++) {
            for (int a = 0; a < listaLetras.length; a++) {
                if (texto.charAt(i) == listaLetras[a]) {
                    contadorLetras[a]++;
                }
            }
        }
        for (int i = 0; i < contadorLetras.length; i++) {
            if (contadorLetras[i] > 0) {
                System.out.print(listaLetras[i]+ " -> ");
                System.out.println(contadorLetras[i]);
            }
        }
    }
}