import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] listaMeses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        pedirDatos(listaMeses);
    }
    public static void pedirDatos(String[] listaMeses) {
        boolean error = true;
        do {
            try {
                Scanner entrada = new Scanner(System.in);
                System.out.print("Ingrese el mes: ");
                String mes = entrada.nextLine();
                int contador = 0;
                for (String listaMese : listaMeses) {
                    if (listaMese.equalsIgnoreCase(mes)) {
                        System.out.print("El mes es correcto");
                        contador++;
                        error = false;
                    }
                }
                if (contador < 1) {
                    throw new mesNoValido();
                }
            }catch (mesNoValido e) {
                System.out.println("El mes es incorrecto, vuelve a intentarlo");
            }
        }while (error);
    }
}