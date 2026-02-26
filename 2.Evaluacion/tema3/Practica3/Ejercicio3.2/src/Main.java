import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static Scanner sc;
    public static Pattern producto;
    public static LinkedList <String> productos;
    public static LinkedList <LocalDate> fechas;
    public static void main(String[] args) {
        inicializarColas();
        anadirProducto();
        eliminarProductos();
        mostrar();
    }
    public static void inicializarColas() {
        productos = new LinkedList <>();
        fechas = new LinkedList <>();
        sc = new Scanner(System.in);
        producto = Pattern.compile("^[A-Z][a-z]+$");
    }
    public static void anadirProducto() {
        boolean continuar = true;
        do {
            boolean error = true;
            do {
                System.out.println("Dime el nombre del producto: ");
                String nombre = sc.nextLine();
                if (producto.matcher(nombre).matches()) {
                    error = false;
                    productos.add(nombre);
                }else {
                    System.out.println("El nombre no es valido, vuelve a intentarlo");
                }
            }while (error);
            DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
            error = true;
            do {
                try {
                    System.out.println("Dime la fecha de caducidad del producto: ");
                    String fecha = sc.nextLine();
                    LocalDate fechaCaducidad = LocalDate.parse(fecha, dtf);
                    fechas.add(fechaCaducidad);
                    error = false;
                } catch (DateTimeParseException e) {
                    System.out.println("La  fecha de caducidad no es valida, vuelve a intentarlo");
                }
            }while (error);
            error = true;
            do {
                System.out.println("Quieres añador otro producto?(si/no)");
                String opcion = sc.nextLine();
                if (opcion.equalsIgnoreCase("no")) {
                    continuar = false;
                    error = false;
                }else if (opcion.equalsIgnoreCase("si")) {
                    System.out.println("---Nuevo producto---");
                    error = false;
                } else {
                    System.out.println("Respuesta no valida, vuelve a intentarlo");
                }
            }while (error);
        }while (continuar);
    }
    public static void eliminarProductos() {
        DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
        boolean error = true;
        do {
            try {
                System.out.println("Dime la fecha que maxima de caducidad: ");
                String fecha = sc.nextLine();
                LocalDate fechaCaducidad = LocalDate.parse(fecha, dtf);
                error = false;
                while (!fechas.isEmpty() && fechas.peek().isBefore(fechaCaducidad)) {
                    productos.remove();
                    fechas.remove();
                }
            } catch (DateTimeParseException e) {
                System.out.println("La fecha introducida no es valida, vuelve a intentarlo");
            }
        }while (error);
    }
    public static void mostrar() {
        for (String producto : productos) {
            System.out.println(producto);
        }
    }
}