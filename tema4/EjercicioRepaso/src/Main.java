import Modelo.Pedido;
import Modelo.Producto;
import Modelo.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Producto> productos = new ArrayList<>();
    public static ArrayList<Pedido> pedidos = new ArrayList<>();
    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static void main(String[] args) {
        crearProductos();
        menu();
    }

    public static void crearProductos() {
        productos.add(new Producto("Leche", 4F,10));
        productos.add(new Producto("Aceite", 8F,10));
        productos.add(new Producto("Crema", 2F,10));
        productos.add(new Producto("Arroz", 6F,10));
        productos.add(new Producto("Salchichas", 5F,10));
        productos.add(new Producto("Bacon", 3F,10));
    }

    public static void menu() {
        boolean continuar = true;
        do {
            System.out.print("""
                --- Menu ---
                a) Dar de alta usuario
                b) Realizar pedido
                c) Salir
                """);
            String opcion = sc.nextLine();
            switch (opcion) {
                case "a":
                    altaUsuario();
                    break;
                case "b":
                    realizarPedido();
                    break;
                case "c":
                    System.out.println("Se ha finalizado el programa");
                    continuar = false;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }while(continuar);

    }

    public static void altaUsuario() {
        usuarios.add(new Usuario(validarDato("Nombre", "Introduce el nombre de usuario:", "^[A-Za-z]+$"),validarDato("Email", "Introduce el email:", "^[A-Za-z0-9]+@gmail.com$")));
    }

    public static void realizarPedido() {
        ArrayList<Producto> productosPedido = new ArrayList<>();
        Usuario usuario = usuarios.stream()
                .filter(usuario1 -> usuario1.getNombre().equalsIgnoreCase(validarDato("Nombre", "Introduce el nombre de usuario:", "^[A-Za-z]+$")))
                .findFirst().orElse(null);
        boolean repetir = true;
        do {
            String nombreProducto = validarDato("Nombre producto", "Introduce el nombre del producto:", "^[A-Za-z]+$");
            Producto productoPedido = productos.stream().filter(producto -> producto.getNombre().equalsIgnoreCase(nombreProducto)).findFirst().orElse(null);
            if (productoPedido != null && productoPedido.getStock()>0) {
                System.out.println("Stock de "+productoPedido.getNombre()+": "+productoPedido.getStock());
                int cantidad = Integer.parseInt(validarDato("Cantidad", "Introduce la cantidad que quieres del producto:", "^[0-9]+$"));
                if (cantidad>productoPedido.getStock()) {
                    System.out.println("No hay tanto stock del producto, vuelve a intentarlo");
                }else {
                    productoPedido.setStock(productoPedido.getStock()-cantidad);
                    productosPedido.add(productoPedido);
                }
            }
            String opcion = validarDato("Opcion", "Quieres añadir mas productos? (si/no)", "^(si|no)$");
            if (opcion.equals("no")) {
                repetir = false;
            }
        }while(repetir);
        pedidos.add(new Pedido(LocalDate.now()));
        pedidos.getLast().setProductos(productosPedido);
        Pedido pedido = pedidos.getLast();
        usuario.anadirPedido(pedido);

    }

    public static String validarDato(String dato, String mensaje, String formato) {
        String respuesta = "";
        boolean error = false;
        do {
            try {
                System.out.println(mensaje);
                respuesta = sc.nextLine();
                respuesta = respuesta.toLowerCase();
                if (!respuesta.matches(formato)) {
                    throw new datoNoValido();
                }
                error = true;
            }catch (datoNoValido e){
                System.out.println(dato + " no es correcto, vuelve a intentarlo");
            }
        }while (!error);
        return respuesta;
    }
}