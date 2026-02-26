import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static Scanner sc;
    public static Pattern nombrePatron;
    public static String[] especies;
    public static ArrayList<String> animalesRescatados;
    public static Queue <String> colaAdopcion;
    public static Map <String, String > relacion;
    public static void main(String[] args) {
        inicializar();
        menu();
    }
    public static void inicializar() {
        sc = new Scanner(System.in);
        nombrePatron = Pattern.compile("^[A-Z][a-z]+$");
        especies =new String[] {"perro", "gato", "conejo", "loro", "tortuga"};
        animalesRescatados = new ArrayList<>();
        colaAdopcion = new LinkedList<>();
        relacion = new HashMap<>();
    }
    public static void menu() {
        boolean error = true;
        do {
            System.out.print("""
                    1) Ver especies aceptadas.
                    2) Agregar un nuevo animal al listado de rescatados.
                    3) Asignar un cuidador a un animal.
                    4) Pasar un animal a la cola de espera de adopcion.
                    5) Adoptar un animal.
                    6) Lista todos los animales y sus cuidadores actuales.
                    7) Salir
                    """);
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    verEspecies();
                    break;
                case 2:
                    agregarRescatado();
                    break;
                case 3:
                    asignarCuidador();
                    break;
                case 4:
                    pasarAdopcion();
                    break;
                case 5:
                    adoptarAnimal();
                    break;
                case 6:
                    listarTodo();
                    break;
                case 7:
                    System.out.println("El programa se ha finalizado");
                    error = false;
                    break;
                default:
                    System.out.println("Opcion no valida, vuelve a intentarlo.");
                    break;
            }
        }while (error);
    }
    public static void verEspecies() {
        System.out.println("Estas son las especies aceptadas:");
        for (String especie : especies) {
            System.out.println(especie);
        }
    }
    public static void agregarRescatado() {
        String tipoEspecie;
        String nombre;
        boolean error = true;
        do {
            System.out.println("Dime la especie del animal rescatado:");
            tipoEspecie = sc.nextLine();
            int contador = 0;
            for (String especie : especies) {
                if (especie.equalsIgnoreCase(tipoEspecie)) {
                    contador = 1;
                }
            }
            if (contador == 1) {
                error = false;
            }else {
                System.out.println("La especie introducida no es valida, vuelve a intentarlo.");
            }
        }while (error);
        error = true;
        do {
            System.out.println("Dime el nombre del animal rescatado:");
            nombre = sc.nextLine();
            if (nombrePatron.matcher(nombre).matches()) {
                error = false;
            }else {
                System.out.println("El nombre del animal rescatado no es valido, vuelve a intentarlo.");
            }
            for (String animalesRescatado : animalesRescatados) {
                if (animalesRescatado.contains(nombre)) {
                    error = true;
                    System.out.println("El nombre no puede repetirse, vuelve a intentarlo.");
                }
            }
        }while (error);
        animalesRescatados.add(nombre+" - "+tipoEspecie);
    }
    public static void asignarCuidador() {
        try {
            String nombreAnimal = "";
            boolean error = true;
            do {
                try {
                    System.out.println("Dime el nombre del animal que le quieres asignar un cuidador:");
                    nombreAnimal = sc.nextLine();
                    if (!nombrePatron.matcher(nombreAnimal).matches()) {
                        throw new datoNoValido();
                    }
                    int contador = 0;
                    for (String animalesRescatado : animalesRescatados) {
                        if (animalesRescatado.contains(nombreAnimal)) {
                            contador = 1;
                        }
                    }
                    if (contador == 0) {
                        throw new datoNoExiste();
                    }
                    error = false;
                } catch (datoNoValido e) {
                    System.out.println("El nombre introducido no es valido, vuelve a intentarlo.");
                }
            } while (error);
            error = true;
            do {
                try{
                    System.out.println("Dime el nombre del cuidador que le quieres asignar a "+nombreAnimal+":");
                    String nombreCuidador = sc.nextLine();
                    if (!nombrePatron.matcher(nombreCuidador).matches()) {
                        throw new datoNoValido();
                    }
                    relacion.put(nombreAnimal, nombreCuidador);
                    error = false;
                }catch (datoNoValido e){
                    System.out.println("El nombre del cuidador no es valido, vuelve a intentarlo.");
                }
            }while (error);
        }catch (datoNoExiste e) {
            System.out.println("El nombre del animal no existe.");
        }
    }
    public static void pasarAdopcion() {
        boolean error = true;
        do {
            System.out.println("Dime el nombre del animal que le quieres pasar a adopcion:");
            String nombre = sc.nextLine();
            if (!nombrePatron.matcher(nombre).matches()) {
                System.out.println("El nombre del animal no es valido, vuelve a intentarlo.");
            }else {
                int contador = 0;
                for (String animalesRescatado : animalesRescatados) {
                    if (animalesRescatado.contains(nombre)) {
                        contador = 1;
                        colaAdopcion.add(animalesRescatado);
                    }
                }
                if (contador == 0) {
                    System.out.println("El nombre del animal no existe.");
                }
                error = false;
            }
        }while (error);
    }
    public static void adoptarAnimal() {
        if (!colaAdopcion.isEmpty()) {
            String nombreAnimal = colaAdopcion.remove();
            System.out.println("El animal que has adoptado es: "+ nombreAnimal);
            for (String clave : relacion.keySet()) {
                if (nombreAnimal.contains(clave)) {
                    relacion.remove(clave);
                }
            }
            animalesRescatados.removeIf(animalesRescatado -> animalesRescatado.contains(nombreAnimal));
        }else {
            System.out.println("La cola de adopcion esta vacia.");
        }
    }
    public static void listarTodo() {
        if (!relacion.isEmpty()) {
            for (String clave : relacion.keySet()) {
                System.out.println(clave + " - " + relacion.get(clave));
            }
        }else {
            System.out.println("No hay animales con cuidadores.");
        }
    }
}