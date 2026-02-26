import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner sc;
    public static String[] meses;
    public static double[] gastadoMes;
    public static void main(String[] args) {
        inicializar();
        boolean repetir;
        do {
            anadirPago();
            repetir = otraVez();
        }while (repetir);
        mostrarResultado();
    }
    public static void inicializar() {
        meses = new String[]{"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
        gastadoMes = new double[12];
        sc = new Scanner(System.in);
    }
    public static void anadirPago() {
        boolean error = true;
        do {
            try {
                System.out.println("Dime el dia del pago:");
                int dia = sc.nextInt();
                if (dia < 1 || dia > 31) {
                    throw new datoNoValido();
                }
                error = false;
                sc.nextLine();
            }catch (datoNoValido | InputMismatchException e){
                sc.nextLine();
                System.out.println("El dia no es valido, vuelve a intentarlo");
            }
        }while (error);
        error = true;
        do {
            try {
                int contador = 0;
                System.out.println("Dime el mes del pago:");
                String mes = sc.nextLine();
                for (int m = 0; m < meses.length; m++) {
                    if (meses[m].equalsIgnoreCase(mes)) {
                        contador++;
                        boolean error2 = true;
                        do {
                            try {
                                System.out.println("Dime la cantidad pagada:");
                                int cantidad = sc.nextInt();
                                sc.nextLine();
                                error2 = false;
                                gastadoMes[m] = gastadoMes[m] + cantidad;
                            }catch (InputMismatchException e){
                                sc.nextLine();
                                System.out.println("La cantidad no es valida, vuelve a intentarlo");
                            }
                        }while (error2);
                    }
                }
                if (contador == 0) {
                    throw new datoNoValido();
                }
                error = false;
            }catch (datoNoValido e){
                System.out.println("El mes no es valido, vuelve a intentarlo");
            }
        }while (error);
    }
    public static boolean otraVez() {
        boolean repetir = true;
        boolean error = true;
        do {
            System.out.println("Quieres añadir otro pago? (si/no)");
            String opcion = sc.nextLine();
            if (opcion.equalsIgnoreCase("si")) {
                error = false;
            }else if (opcion.equalsIgnoreCase("no")) {
                repetir = false;
                error = false;
            }else {
                System.out.println("La opcion no es valida, vuelve a intentarlo");
            }
        }while (error);
        return repetir;
    }
    public  static void mostrarResultado() {
        System.out.println("---Gastos por Mes---");
        for (int i = 0; i < gastadoMes.length; i++) {
            for (int j = 0; j < gastadoMes.length; j++) {
                if (gastadoMes[i] < gastadoMes[j]) {
                    double valor = gastadoMes[i];
                    gastadoMes[i] = gastadoMes[j];
                    gastadoMes[j] = valor;
                    String mes = meses[i];
                    meses[i] = meses[j];
                    meses[j] = mes;
                }
            }
        }
        for (int i = 0; i < gastadoMes.length; i++) {
            if (gastadoMes[i] != 0) {
                System.out.println(meses[i].toUpperCase() +" --> "+gastadoMes[i]);
            }
        }
    }
}