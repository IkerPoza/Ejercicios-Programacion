import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner teclado = new Scanner(System.in);
    public static boolean terminar = true;
    public static int unidades, producto;
    public static void main(String[] args) {
        int[] listaProductos = {10, 23, 30, 47, 55, 65, 135, 256, 526, 663};
        int[] listaUnidades = new int[10];
        todo(listaUnidades, listaProductos);
    }
    public static void todo (int[] listaUnidades, int[] listaProductos) {
        do {
            try {
                pedirUnidades();
                pedirCodigo(listaProductos, listaUnidades);
                continuar();
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }while (terminar);
        mostrarResultado(listaUnidades, listaProductos);
    }
    public static void pedirUnidades() {
        boolean error = true;
        do {
            try {
                System.out.println("Cuantas unidades has vendidio? ");
                unidades = teclado.nextInt();
                if (unidades <= 0) {
                    throw new numeroNoValido();
                }
                error = false;
            }catch (numeroNoValido e) {
                System.out.println("El numero de unidades no es valido, vuelve a intentarlo");
            }catch (Exception e) {
                System.out.println("El numero de unidades no es valido, vuelve a intentarlo");
                teclado.nextLine();
            }
        }while (error);

    }

    public static void pedirCodigo(int[] listaProductos, int[] listaUnidades) {
        boolean error = true;
        do {
            try {
                int valdido = 0;
                System.out.println("De que producto? (Codigo de Producto)");
                producto = teclado.nextInt();
                for (int i = 0; i < listaProductos.length; i++) {
                    if (producto == listaProductos[i]) {
                        listaUnidades[i] = listaUnidades[i] + unidades;
                        valdido++;
                    }
                }
                if (valdido == 0) {
                    throw new numeroNoValido();
                }
                teclado.nextLine();
                error = false;
            } catch (numeroNoValido e) {
                System.out.println("El codigo no es valido, vuelve a intentarlo");
            }
        }while (error);
    }
    public static void continuar() {
        boolean error = true;
        do {
            try {
                System.out.println("Quieres añadir una nueva venta?");
                String respuesta = teclado.nextLine();
                if (respuesta.equalsIgnoreCase("si")) {
                    terminar = true;
                }else if (respuesta.equalsIgnoreCase("no")) {
                    terminar = false;
                } else {
                    throw new respuestaNoValida();
                }
                error = false;
            } catch (respuestaNoValida e) {
                System.out.println("La respuesta no es valida, vuelve a intentarlo");
            }
        }while (error);
    }
    public static void mostrarResultado(int[] listaUnidades, int[] listaProductos) {
        int[] listaUnidadesOrdenada = Arrays.copyOf(listaUnidades, listaUnidades.length);
        Arrays.sort(listaUnidadesOrdenada);
        for (int i = 0; i < listaUnidades.length; i++) {
            if(listaUnidadesOrdenada[i] > 0) {
                for (int j = 0; j < listaUnidades.length; j++) {
                    if (listaUnidadesOrdenada[i] == listaUnidades[j]) {
                        System.out.println(listaProductos[j] + " -> " + listaUnidadesOrdenada[i]);
                    }
                }
            }
        }
    }
}