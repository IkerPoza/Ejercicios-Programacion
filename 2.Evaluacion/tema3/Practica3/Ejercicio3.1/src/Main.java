import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static Pattern patronNombre = Pattern.compile("^[A-Z][a-z]+ [A-Z][a-z]+$");
    public static Boolean insertado, eliminado, modificado;
    public static HashSet<String> porteros = new HashSet<>();
    public static HashSet<String> defensas = new HashSet<>();
    public static HashSet<String> centrocampistas = new HashSet<>();
    public static HashSet<String> delanteros = new HashSet<>();
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
    }
    public static void menu() {
        boolean continuar = true;
        do {
            try {
                System.out.print("""
                        ---MENU---
                        a) Dar de alta a jugador
                        b) Dar de baja a jugador
                        c) Modificar jugador
                        d) Salir
                        """);
                char opcion = sc.nextLine().charAt(0);
                switch (opcion) {
                    case 'a':
                        alta();
                        break;
                    case 'b':
                        baja();
                        break;
                    case 'c':
                        menumodificar();
                        break;
                    case 'd':
                        System.out.println("Se ha cerrado el programa");
                        continuar = false;
                        break;
                    default:
                        System.out.println("La opcion no es valida, vuelve a intentarlo");
                }
            }catch (Exception _) {
            }
        }while (continuar);
    }
    public static void alta() {
        System.out.println("Dime el nombre del jugador que quieres dar de alta:");
        String nombre = sc.nextLine();
        if (!patronNombre.matcher(nombre).matches()) {
            System.out.println("El nombre del jugador no es valido");
        }else {
            System.out.println("Dime la posicion del jugador:");
            String posicion = sc.next();
            switch (posicion.toLowerCase()) {
                case "portero":
                    insertado = porteros.add(nombre);
                    break;
                case "defensa":
                    insertado = defensas.add(nombre);
                    break;
                case "centrocampista":
                    insertado = centrocampistas.add(nombre);
                    break;
                case "delantero":
                    insertado = delanteros.add(nombre);
                    break;
                default:
                    System.out.println("Esa no es una posicion valida solo puede ser portero, defensa, centrocampista y delantero");
                    break;
            }
            if (insertado) {
                sc.nextLine();
                System.out.println("El jugador se ha dado de alta con exito.");
            } else {
                sc.nextLine();
                System.out.println("El jugador no se ha podido dar de alta.");
            }
        }
    }
    public static void baja() {
        System.out.println("Dime el nombre del jugador que quieres dar de baja:");
        String nombre = sc.nextLine();
        if (!patronNombre.matcher(nombre).matches()) {
            System.out.println("El nombre del jugador no es valido");
        }else {
            System.out.println("Dime la posicion del jugador:");
            String posicion = sc.nextLine();
            switch (posicion) {
                case "portero":
                    eliminado = porteros.remove(nombre);
                    break;
                case "defensa":
                    eliminado = defensas.remove(nombre);
                    break;
                case "centrocampista":
                    eliminado = centrocampistas.remove(nombre);
                    break;
                case "delantero":
                    eliminado = delanteros.remove(nombre);
                    break;
                default:
                    System.out.println("Esa no es una posicion valida solo puede ser portero, defensa, centrocampista y delantero");
                    break;
            }
            if (eliminado) {
                System.out.println("El jugador se ha dado de baja con exito.");
            } else {
                System.out.println("El jugador no se ha podido dar de baja.");
            }
        }
    }
    public static void menumodificar(){
        System.out.println("Que quieres modificar el nombre o la posicion del jugador:");
        String opcion = sc.nextLine();
        switch (opcion.toLowerCase()){
            case "nombre":
                modificarnombre();
            break;
            case "posicion":
                modificarposicion();
            break;
            default:
                System.out.println("La respuesta no es valida solo se puede introducir nombre o posicion");
        }
    }
    public static void modificarnombre(){
        System.out.println("Dime el nombre del jugador al que le quieres cambiar el nombre:");
        String nombre = sc.nextLine();
        if (!patronNombre.matcher(nombre).matches()) {
            System.out.println("El nombre del jugador no es valido");
        }else {
            System.out.println("Dime la posicion del jugador:");
            String posicion = sc.nextLine();
            System.out.println("Dime el nuevo nombre del jugador:");
            String nombre2 = sc.nextLine();
            if (!patronNombre.matcher(nombre2).matches()) {
                System.out.println("El nombre del jugador no es valido");
            } else {
                switch (posicion) {
                    case "portero":
                        eliminado = porteros.remove(nombre);
                        break;
                    case "defensa":
                        eliminado = defensas.remove(nombre);
                        break;
                    case "centrocampista":
                        eliminado = centrocampistas.remove(nombre);
                        break;
                    case "delantero":
                        eliminado = delanteros.remove(nombre);
                        break;
                    default:
                        System.out.println("Esa no es una posicion valida solo puede ser portero, defensa, centrocampista y delantero");
                        break;
                }
                if (eliminado) {
                    switch (posicion) {
                        case "portero":
                            modificado = porteros.add(nombre2);
                            break;
                        case "defensa":
                            modificado = defensas.add(nombre2);
                            break;
                        case "centrocampista":
                            modificado = centrocampistas.add(nombre2);
                            break;
                        case "delantero":
                            modificado = delanteros.add(nombre2);
                            break;
                        default:
                            System.out.println("Esa no es una posicion valida solo puede ser portero, defensa, centrocampista y delantero");
                            break;
                    }
                    if (modificado) {
                        System.out.println("El nombre del jugador se ha modificado");
                    }else {
                        System.out.println("El nombre del jugador no se ha podido modificar");
                    }
                }else {
                    System.out.println("El nombre del jugador no se ha podido modificar");
                }
            }
        }
    }

    public static void modificarposicion() {
        System.out.println("Dime el nombre del jugador que quieres modificar:");
        String nombre = sc.nextLine();
        if (!patronNombre.matcher(nombre).matches()) {
            System.out.println("El nombre del jugador no es valido");
        }else {
            System.out.println("Dime la posicion del jugador:");
            String posicion = sc.nextLine();
            System.out.println("Dime la nueva posicion del jugador:");
            String posicion2 = sc.nextLine();
            switch (posicion) {
                case "portero":
                    eliminado = porteros.remove(nombre);
                    break;
                case "defensa":
                    eliminado = defensas.remove(nombre);
                    break;
                case "centrocampista":
                    eliminado = centrocampistas.remove(nombre);
                    break;
                case "delantero":
                    eliminado = delanteros.remove(nombre);
                    break;
                default:
                    System.out.println("Esa no es una posicion valida solo puede ser portero, defensa, centrocampista y delantero");
                    break;
            }
            if (eliminado) {
                boolean error;
                do {
                    error = false;
                    switch (posicion2) {
                        case "portero":
                            modificado = porteros.add(nombre);
                            break;
                        case "defensa":
                            modificado = defensas.add(nombre);
                            break;
                        case "centrocampista":
                            modificado = centrocampistas.add(nombre);
                            break;
                        case "delantero":
                            modificado = delanteros.add(nombre);
                            break;
                        default:
                            error = true;
                            System.out.println("Esa no es una posicion valida solo puede ser portero, defensa, centrocampista y delantero");
                            System.out.println("Dime la nueva posicion del jugador:");
                            posicion2 = sc.nextLine();
                            break;
                    }
                }while (error);
                    if (modificado) {
                        System.out.println("El jugador se ha modificado con exito.");
                    } else {
                        System.out.println("El jugador no se ha podido modificar.");
                    }
            } else {
                System.out.println("El jugador no se ha podido modificar.");
            }
        }
    }
}