import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[] listaLetras = new char[27];
        int[] contadorLetras = new int[27];
        pedirTexto(listaLetras, contadorLetras);
    }
    public static void pedirTexto(char[] listaLetras, int[] contadorLetras) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Dime el texto que quieres escanear:");
        String textoIntroducido = teclado.nextLine();
        textoIntroducido = textoIntroducido.toLowerCase().replace(" ","");
        StringBuilder texto = new StringBuilder(textoIntroducido);
        for (int i = 0; i < texto.length(); i++) {
            int contador = 0;
            for (int j = 0; j < texto.length(); j++) {
                if (texto.charAt(i) == listaLetras[j]) {
                    contador++;
                    contadorLetras[j]++;
                }
            }
            if (contador == 0) {
                listaLetras[i] = texto.charAt(i);
                contadorLetras[i] = 1;
            }
        }
        mostrarResultado(listaLetras, contadorLetras);
    }
    public  static void mostrarResultado(char[] listaLetras, int[] contadorLetras) {
        for (int i = 0; i < listaLetras.length; i++) {
            if (contadorLetras[i] > 0) {
                System.out.print(listaLetras[i]+" -> "+contadorLetras[i]+"\n");
            }
        }
    }
}