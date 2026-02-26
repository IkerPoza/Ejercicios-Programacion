import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static Pattern numeroPatron = Pattern.compile("^[0-9]{9}$");
    public static Pattern nombrePatron = Pattern.compile("^[A-Z][a-z]+$");
    public static Map <Integer,String> telefonos;
    public static Scanner sc;
    public static void main(String[] args) {
        inicializar();
        menu();
    }
    public  static void inicializar() {
        telefonos = new HashMap<>();
        sc = new Scanner(System.in);
    }
    public static void menu() {
        boolean continuar = true;
        do {
            System.out.print("""
                    1.- Anadir un nuevo numero
                    2.- Borrar un numero
                    3.- Buscar un numero
                    4.- Borrar por nombre
                    5.- Buscar por nombre
                    6.- Salir.
                    """);
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    anadirNumero();
                    break;
                case 2:
                    if (!telefonos.isEmpty()) {
                        borrarNumero();
                    }else {
                        System.out.println("La lista de telefonos esta vacia");
                    }
                    break;
                case 3:
                    if (!telefonos.isEmpty()) {
                        buscarNumero();
                    }else {
                        System.out.println("La lista de telefonos esta vacia");
                    }
                    break;
                case 4:
                    if (!telefonos.isEmpty()) {
                        borrarNombre();
                    }else {
                        System.out.println("La lista de telefonos esta vacia");
                    }
                    break;
                case 5:
                    if (!telefonos.isEmpty()) {
                        buscarNombre();
                    }else {
                        System.out.println("La lista de telefonos esta vacia");
                    }
                    break;
                case 6:
                    System.out.println("Se ha finalizado el programa");
                    continuar = false;
                    break;
            }
        }while (continuar);
    }
    public static void anadirNumero() {
        sc.nextLine();
        int numero = 0;
        boolean error = true;
        do {
            try {
                System.out.println("Ingresa el numero de telefono:");
                String telefonoString = sc.nextLine();
                Matcher matcher = numeroPatron.matcher(telefonoString);
                if (!matcher.matches()) {
                    throw new datoNoValido();
                }
                error = false;
                numero = Integer.parseInt(telefonoString);
            } catch (datoNoValido e) {
                System.out.println("El numero no es correcto, vuelve a intentarlo");
            }
        }while (error);
        String nombre = "";
        boolean error2 = true;
        do {
            try {
                System.out.println("Ingresa el nombre del titular del telefono:");
                nombre = sc.nextLine();
                Matcher matcher = nombrePatron.matcher(nombre);
                if (!matcher.matches()) {
                    throw new datoNoValido();
                }
                error2 = false;
            } catch (datoNoValido e) {
                System.out.println("El nombre no es correcto, vuelve a intentarlo");
            }
        }while (error2);
        telefonos.put(numero, nombre);
    }
    public static void borrarNumero() {
        sc.nextLine();
        boolean error = true;
        do {
            try {
                System.out.println("Ingresa el numero de telefono que desea borrar:");
                String telefonoString = sc.nextLine();
                Matcher matcher = numeroPatron.matcher(telefonoString);
                if (!matcher.matches()) {
                    throw new datoNoValido();
                }
                int numero = Integer.parseInt(telefonoString);
                error = false;
                if (!telefonos.containsKey(numero)) {
                    throw new noExiste();
                }
                System.out.println("Se ha eliminado el numero de telefono: "+numero + " de "+ telefonos.remove(numero));
            }catch (datoNoValido e){
                System.out.println("El numero no es correcto, vuelve a intentarlo");
            }catch (noExiste e){
                System.out.println("El numero no existe");
            }
        }while (error);
    }
    public static void buscarNumero() {
        sc.nextLine();
        boolean error = true;
        do {
            try {
                System.out.println("Ingresa el numero de telefono que quieres buscar:");
                String telefonoString = sc.nextLine();
                Matcher matcher = numeroPatron.matcher(telefonoString);
                if (!matcher.matches()) {
                    throw new datoNoValido();
                }
                int numero = Integer.parseInt(telefonoString);
                error = false;
                if (!telefonos.containsKey(numero)) {
                    throw new noExiste();
                }
                System.out.println("Se ha buscado el numero de telefono: "+numero + " de "+telefonos.get(numero));
            }catch (datoNoValido e){
                System.out.println("El numero no es correcto, vuelve a intentarlo");
            }catch (noExiste e){
                System.out.println("El numero no existe");
            }
        }while (error);
    }
    public static void borrarNombre() {
        sc.nextLine();
        boolean error = true;
        do {
            try {
                System.out.println("Ingresa el nombre del titular del telefono:");
                String nombre = sc.nextLine();
                Matcher matcher = nombrePatron.matcher(nombre);
                if (!matcher.matches()) {
                    throw new datoNoValido();
                }
                error = false;
                if (!telefonos.containsValue(nombre)) {
                    throw new noExiste();
                }
                Map <Integer, String> copiaTelefonos = new HashMap<>(telefonos);
                for (Integer numero : copiaTelefonos.keySet()) {
                    if (telefonos.get(numero).contains(nombre)) {
                        System.out.println("Se ha eliminado el numero de telefono: " + numero + " de " + telefonos.remove(numero));
                    }
                }
            }catch (datoNoValido e){
                System.out.println("El nombre no es correcto, vuelve a intentarlo");
            }catch (noExiste e){
                System.out.println("El nombre no existe");
            }
        }while (error);
    }
    public static void buscarNombre() {
        sc.nextLine();
        boolean error = true;
        do {
            try {
                System.out.println("Ingresa el titular del telefono:");
                String nombre = sc.nextLine();
                Matcher matcher = nombrePatron.matcher(nombre);
                if (!matcher.matches()) {
                    throw new datoNoValido();
                }
                error = false;
                if (!telefonos.containsValue(nombre)) {
                    throw new noExiste();
                }
                for (Integer numero : telefonos.keySet()) {
                    if (telefonos.get(numero).contains(nombre)) {
                        System.out.println("Se ha buscado el numero de telefono: " + numero + " de " + telefonos.get(numero));
                    }
                }
            }catch (datoNoValido e){
                System.out.println("El titular no es correcto, vuelve a intentarlo");
            }catch (noExiste e){
                System.out.println("El nombre no existe");
            }
        }while (error);
    }

}