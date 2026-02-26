import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] elementos = new double[3];
        for (int i = 0; i < elementos.length; i++) {
            System.out.println("Dime el numero del elemento " + (i+1) + ":");
            elementos[i] = sc.nextDouble();
        }
        numeroMax(elementos);
        numeroMin(elementos);
    }
    public static void numeroMax( double[] elementos) {
        double numeroMayor = elementos[0];
        for (double elemento : elementos) {
            if (elemento > numeroMayor) {
                numeroMayor = elemento;
            }
        }
        System.out.println("Este es el valor maximo: " + numeroMayor);
    }
    public static void numeroMin( double[] elementos) {
        double numeroMenor = elementos[0];
        for (double elemento : elementos) {
            if (elemento < numeroMenor) {
                numeroMenor = elemento;
            }
        }
        System.out.println("Este es el valor minimo: " + numeroMenor);
    }
}