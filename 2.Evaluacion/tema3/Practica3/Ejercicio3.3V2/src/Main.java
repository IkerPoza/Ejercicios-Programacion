import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static Deque <String> libros;
    public static Scanner sc;
    public static void main(String[] args) {
        inicializar();
        menu();
    }
    public static void inicializar() {
        libros = new ArrayDeque<>();
        sc = new Scanner(System.in);

    }
    public static void menu() {
        boolean continuar = true;
        do {
            System.out.print("""
                    ---MENU---
                    a) Anadir un libro a la pila
                    b) Consultar el libro en la parte superior
                    c) Retirar el libro en la parte superior
                    d) Mostrar todos los libros en la pila
                    e) Verificar si la pila esta vacia.
                    f) Salir del programa.
                    """);
            String opcion = sc.nextLine();
            switch (opcion) {
                case "a":
                    anadirLibro();
                    break;
                case "b":
                    consultarLibro();
                    break;
                case "c":
                    retirarLibro();
                    break;
                case "d":
                    mostrarLibros();
                    break;
                case "e":
                    verificarPila();
                    break;
                case "f":
                    System.out.println("El programa se ha finalizado");
                    continuar = false;
                    break;
                default:
                    System.out.println("La opcion no es valida, vuelve a intentarlo");
                    break;
            }
        }while (continuar);
    }
    public static void anadirLibro() {
        boolean error = false;
        do {
            Pattern p =  Pattern.compile("[A-Z][a-z ]+");
            System.out.println("Dime el titulo del libro:");
            String titulo = sc.nextLine();
            if (p.matcher(titulo).matches()) {
                libros.push(titulo);
                error = true;
            }else {
                System.out.println("El titulo no es valido, vuelve a intentarlo");
            }
        }while (!error);
    }
    public static void consultarLibro() {
        if (libros.isEmpty()) {
            System.out.println("La pila de libros esta vacia");
        }else {
            System.out.println("El libro de la parte superior es: " + libros.peek());
        }
    }
    public static void retirarLibro() {
        if (libros.isEmpty()) {
            System.out.println("La pila de libros esta vacia");
        }else {
            System.out.println("El libro eliminado de la parte superior es: " + libros.pop());
        }
    }
    public static void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("La pila de libros esta vacia");
        }else  {
            Deque <String> listaLibros = new ArrayDeque<>(libros);
            while (!listaLibros.isEmpty()) {
                System.out.println(listaLibros.pollFirst());
            }
        }
    }
    public static void verificarPila() {
        if (libros.isEmpty()) {
            System.out.println("La pila de libros esta vacia");
        }else {
            System.out.println("Hay libros en la pila");
        }
    }
}