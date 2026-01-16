import Modelo.Directivo;
import Modelo.Empleado;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Directivo> directivos = new ArrayList<>();
    public static void main(String[] args) {
        crearPersonas();
        verDirectivo();
    }
    public static void crearPersonas() {
        Empleado empleado1 = new Empleado("Alberto", 30, 15000);
        Empleado empleado2 = new Empleado("Marta", 30, 15000);
        Empleado empleado3 = new Empleado("Sandro", 30, 15000);
        Empleado empleado4 = new Empleado("Saul", 30, 15000);
        Empleado empleado5 = new Empleado("Lopez", 30, 15000);
        Empleado empleado6 = new Empleado("Antonio", 30, 15000);

        ArrayList<Empleado> empleados1 = new ArrayList<>();
        empleados1.add(empleado1);
        empleados1.add(empleado2);
        empleados1.add(empleado3);

        ArrayList<Empleado> empleados2 = new ArrayList<>();
        empleados2.add(empleado4);
        empleados2.add(empleado5);

        ArrayList<Empleado> empleados3 = new ArrayList<>();
        empleados3.add(empleado6);

        Directivo directivo1 = new Directivo("Arturo", 40, 20000, "Ciencia",  empleados2);
        Directivo directivo2 = new Directivo("Javier", 40, 20000, "Informatica",  empleados1);
        Directivo directivo3 = new Directivo("Xabi", 50, 30000, "Mecanica",  empleados3);

        directivos.add(directivo1);
        directivos.add(directivo2);
        directivos.add(directivo3);
    }
    public static void verDirectivo() {
        int mayorNumeroEmpleados = 0;
        int contadorNumeroEmpleados;
        String nombreDirectivo = "";
        for (Directivo directivo : directivos) {
            contadorNumeroEmpleados = 0;
            for (Empleado empleado : directivo.getEmpleados()) {
                contadorNumeroEmpleados++;
            }
            if (contadorNumeroEmpleados > mayorNumeroEmpleados) {
                mayorNumeroEmpleados = contadorNumeroEmpleados;
                nombreDirectivo = directivo.getNombre();
            }
        }
        System.out.println("El directivo con mayor numero de empleados es: " + nombreDirectivo + " y tiene " + mayorNumeroEmpleados + " empleados.");
        
    }
}