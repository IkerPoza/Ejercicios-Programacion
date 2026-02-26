import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList <Double> lista = new ArrayList<>();
    public static void main(String[] args) {
        try {
            rellenarLista();
            menu();
        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getClass());
        }
    }
    public static void rellenarLista() {
        boolean error = false;
        do {
            try {
                System.out.println("Dime el numero que quieres insertar:");
                lista.add(sc.nextDouble());
                sc.nextLine();
                boolean error2 = false;
                do {
                    System.out.println("Quieres insertar mas (si/no)?");
                    String opcion = sc.nextLine();
                    if (opcion.equalsIgnoreCase("no")) {
                        error = true;
                        error2 = true;
                    } else if (opcion.equalsIgnoreCase("si")) {
                        error2 = true;
                    } else {
                        System.out.println("La respuesta no es una opcion, vuelve a intentarlo");
                    }
                } while (!error2);
            }catch (InputMismatchException e){
                System.out.println("El dato no es valido, vuelve a intentarlo");
                sc.nextLine();
            }
        }while (!error);
    }
    public static void menu() {
        boolean continuar = false;
        do {
            System.out.print("""
                    a) Visualizar el valor maximo y el mınimo.
                    b) Solicitar un numero y buscarlo.
                    c) Solicitar un numero, buscarlo y borrarlo.
                    d) Convertir el arrayList en un array.
                    e) Si no esta vacıo, mostrar el numero de elementos que contiene.
                    f) Insertar un nuevo elemento por el final.
                    g) Insertar un nuevo elemento en la posicion que te indique el usuario.
                    h) Borrar un elemento de una posicion concreta.
                    i) Calcular la suma y la media aritmetica de los valores contenidos.
                    j) Finalizar.
                    """);
            char opcion = sc.nextLine().charAt(0);
            switch (opcion) {
                case 'a':
                    opciona();
                    break;
                case 'b':
                    opcionb();
                    break;
                case 'c':
                    opcionc();
                    break;
                case 'd':
                    opciond();
                    break;
                case 'e':
                    opcione();
                    break;
                case 'f':
                    opcionf();
                break;
                case 'g':
                    opciong();
                break;
                case 'h':
                    opcionh();
                break;
                case 'i':
                    opcioni();
                break;
                case 'j':
                    System.out.println("Se ha finalizado el programa");
                    continuar = true;
                default:
                    System.out.println("La opcion introducida no es correcta, vuelve a intentarlo");
            }
        }while (!continuar);
    }
    public  static void opciona() {
        double mayor = lista.getFirst();
        double menor = lista.getFirst();
        for (Double aDouble : lista) {
            if (aDouble > mayor) {
                mayor = aDouble;
            }
            if (aDouble < menor) {
                menor = aDouble;
            }
        }
        System.out.println("El numero mayor es: " + mayor);
        System.out.println("El numero menor es: " + menor);
    }
    public static void opcionb() {
        boolean error = false;
        do {
            try {
                System.out.println("Dime el numero que quieres buscar:");
                double numero = sc.nextDouble();
                sc.nextLine();
                if (lista.contains(numero)) {
                    System.out.println("El numero existe.");
                }else {
                    System.out.println("El numero no existe.");
                }
                error = true;
            }catch (InputMismatchException e) {
                System.out.println("El numero es incorrecto, vuelva a intentarlo.");
            }
        }while (!error);
    }
    public static void opcionc() {
        boolean error = false;
        do {
            try {
                System.out.println("Dime el numero que quieres buscar y borrar:");
                double numero = sc.nextDouble();
                sc.nextLine();
                if (lista.remove(numero)) {
                    System.out.println("El numero existe y se a borrado.");
                }else  {
                    System.out.println("El numero no existe.");
                }
                error = true;
            }catch (InputMismatchException e) {
                System.out.println("El numero es incorrecto, vuelva a intentarlo.");
            }
        }while (!error);
    }
    public static void opciond() {
        Object[] listaArray = lista.toArray();
        System.out.println("Se ha convertido en un array, este es su contenido.");
        for (Object o : listaArray) {
            System.out.print(o + "  ");
        }
        System.out.println();
    }
    public static void opcione(){
        if (!lista.isEmpty()) {
            System.out.println("La lista contiene " + lista.size() + " elementos.");
        }else  {
            System.out.println("La lista esta vacia.");
        }
    }
    public static void opcionf(){
        boolean error = false;
        do {
            try {
                System.out.println("Dime el numero que quieres añadir al final:");
                lista.add(sc.nextDouble());
                sc.nextLine();
                error = true;
            }catch (InputMismatchException e) {
                System.out.println("El numero es incorrecto, vuelva a intentarlo.");
            }
        }while (!error);
    }
    public static void opciong(){
        boolean error = false;
        do {
            try {
                System.out.println("Dime la posicion en la que quieres añadir:");
                int posicion = sc.nextInt();
                System.out.println("Dime el numero que quieres añadir:");
                lista.add(posicion, sc.nextDouble());
                sc.nextLine();
                error = true;
            }catch (InputMismatchException e) {
                System.out.println("El numero o la posicion es incorrecto, vuelva a intentarlo.");
            }
        }while (!error);
    }
    public static void opcionh() {
        boolean error = false;
        do {
            try {
                System.out.println("Dime la posicion que quieres borrar:");
                int posicion = sc.nextInt();
                sc.nextLine();
                lista.remove(posicion);
                error = true;
            }catch (InputMismatchException e) {
                System.out.println("El numero es incorrecto, vuelva a intentarlo.");
            }
        }while (!error);
    }
    public static void opcioni() {
        double suma = 0.0;
        for (Double aDouble : lista) {
            suma += aDouble;
        }
        System.out.println("La suma es: " + suma);
        System.out.println("La media aritmetica es: " + suma / lista.size());
    }
}