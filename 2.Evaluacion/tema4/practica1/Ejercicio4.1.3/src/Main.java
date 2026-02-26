import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static List<Persona> listaPersonas = new ArrayList<Persona>();
    public static Pattern patronNombres = Pattern.compile("^[A-Z][a-z]+$");
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        boolean continuar = true;
        do {
            anadirPersona();
            try {
                System.out.println("Quieres añadir a otra persona? (si/no)");
                String opcion = sc.nextLine();
                if (opcion.equalsIgnoreCase("si")) {
                }else if (opcion.equalsIgnoreCase("no")) {
                    continuar = false;
                }else {
                    throw new DatoNoValido();
                }
            }catch (DatoNoValido e){
                System.out.println("La respuesta introducida no es valida, vuelve a intentarlo.");
            }
        }while (continuar);
        buscar();
    }
    public static void anadirPersona() {
        String nombre = pedirNombre();
        LocalDate fechaNacimiento = pedirFechaNacimiento();
        int dia = fechaNacimiento.getDayOfMonth();
        int mes = fechaNacimiento.getMonth().getValue();
        int ano = fechaNacimiento.getYear();
        String direccion = pedirDireccion();
        int codigoPostal = pedirCodigoPostal();
        String ciudad = pedirCiudad();
        listaPersonas.add(new Persona(nombre, dia, mes, ano, direccion, codigoPostal, ciudad));
    }
    public static String pedirNombre() {
        String nombre = null;
        boolean error = false;
        do {
            try {
                System.out.println("Dime el nombre de la persona");
                nombre = sc.nextLine();
                Matcher m = patronNombres.matcher(nombre);
                if (!m.matches()){
                    throw new DatoNoValido();
                }
                error = false;
            }catch (DatoNoValido e){
                System.out.println("El nombre introducido no es valido, vuelve a intentarlo.");
                error = true;
            }
        }while (error);
        return nombre;
    }
    public static LocalDate pedirFechaNacimiento() {
        LocalDate fechaNacimiento = null;
        boolean correcto = false;
        do {
            int dia = 0;
            int mes = 0;
            int ano = 0;
            boolean error = false;
            do {
                try {
                    System.out.println("Dime el dia de la fecha de nacimiento");
                    dia = sc.nextInt();
                    if (dia < 1 || dia > 31) {
                        throw new DatoNoValido();
                    }
                    error = false;
                } catch (DatoNoValido | InputMismatchException e) {
                    sc.nextLine();
                    System.out.println("El dia introducido no es valido, vuelve a intentarlo.");
                    error = true;
                }
            } while (error);
            do {
                try {
                    System.out.println("Dime el mes de la fecha de nacimiento");
                    mes = sc.nextInt();
                    if (mes < 1 || mes > 12) {
                        throw new DatoNoValido();
                    }
                    error = false;
                } catch (DatoNoValido | InputMismatchException e) {
                    System.out.println("El mes introducido no es valido, vuelve a intentarlo.");
                    error = true;
                }
            } while (error);
            do {
                try {
                    System.out.println("Dime el año de la fecha de nacimiento");
                    ano = sc.nextInt();
                    if (ano > LocalDate.now().getYear()) {
                        throw new DatoNoValido();
                    }
                    error = false;
                } catch (InputMismatchException | DatoNoValido e) {
                    System.out.println("El año introducido no es valido, vuelve a intentarlo.");
                    error = true;
                }
            } while (error);
            try {
                fechaNacimiento = LocalDate.of(ano, mes, dia);
                if (fechaNacimiento.isAfter(LocalDate.now())) {
                    throw new DatoNoValido();

                }
                correcto = false;
            } catch (DateTimeException | DatoNoValido e) {
                System.out.println("La fecha introducida no es valida, vuelve a intentarlo.");
                correcto = true;
            }
        }while (correcto);
        return fechaNacimiento;
    }
    public static String pedirDireccion() {
        sc.nextLine();
        String direccion = null;
        boolean error = false;
        do {
            try {
                System.out.println("Dime la direccion de la persona");
                direccion = sc.nextLine();
                Matcher m = patronNombres.matcher(direccion);
                if (!m.matches()){
                    throw new DatoNoValido();
                }
                error = false;
            }catch (DatoNoValido e){
                System.out.println("La direccion introducida no es valido, vuelve a intentarlo.");
                error = true;
            }
        }while (error);
        return direccion;
    }
    public static int pedirCodigoPostal() {
        String codigo = "";
        boolean error = false;
        do {
            try {
                Pattern patronCodigo = Pattern.compile("^[0-9]{5}$");
                System.out.println("Dime el codigo de postal de la persona");
                codigo = sc.nextLine();
                Matcher m = patronCodigo.matcher(codigo);
                if (!m.matches()){
                    throw new DatoNoValido();
                }
                error = false;
            }catch (DatoNoValido e){
                System.out.println("El codigo Postal no es valido, vuelve a intentarlo.");
                error = true;
            }
        }while (error);
        return Integer.parseInt(codigo);
    }
    public static String pedirCiudad() {
        String ciudad = null;
        boolean error = false;
        do {
            try {
                System.out.println("Dime el nombre de la ciudad de la persona");
                ciudad = sc.nextLine();
                Matcher m = patronNombres.matcher(ciudad);
                if (!m.matches()){
                    throw new DatoNoValido();
                }
                error = false;
            }catch (DatoNoValido e){
                System.out.println("La ciudad introducida no es valido, vuelve a intentarlo.");
                error = true;
            }
        }while (error);
        return ciudad;
    }
    public static void buscar(){
        StringBuilder viven =  new StringBuilder();
        for (int i = 0 ; i<listaPersonas.size();i++){
            String nombre = listaPersonas.get(i).vivenEnElche();
            if (!nombre.isEmpty()){
                viven.append(nombre);
            }
        }
        System.out.println("El persona que desea buscar: "+viven);

        int mayorEdad = 0;
        int mayorEdadPosicion = 0;
        for (int i = 0 ; i<listaPersonas.size();i++){
            int edad = listaPersonas.get(i).calcularEdad();
            if (edad > mayorEdad){
                mayorEdad = edad;
                mayorEdadPosicion = i;
            }
        }
        System.out.println("El persona con mayor edad es: "+listaPersonas.get(mayorEdadPosicion) +" con "+mayorEdad);
        int contador = 0;
        for (int i = 0 ; i<listaPersonas.size();i++){
            int edad = listaPersonas.get(i).calcularEdad();
            if (edad >= 18){
                contador++;
            }
        }
        System.out.println("El numero de personas mayores de edad es: "+contador);
    }
}