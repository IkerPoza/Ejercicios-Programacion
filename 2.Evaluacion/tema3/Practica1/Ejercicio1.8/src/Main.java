import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int alumnos = numeroAlumnos();
        int asignaturas = numeroAsignaturas();
        int [][] clases = new int[alumnos][asignaturas];
        guardarNotas(clases);
        mediaAlumnos(clases, asignaturas);
        mediaAsignaturas(clases, alumnos, asignaturas);
        notaMasAlta(clases);
        notaMasBaja(clases);
    }
    public static int numeroAlumnos() {
        boolean error = true;
        int alumnos = 0;
        do {
            try {
                System.out.println("Dime el numero de alumnos de la clase:");
                alumnos = sc.nextInt();
                if (alumnos < 0) {
                    throw new numeroNoValido();
                }
                error = false;
            } catch (InputMismatchException | numeroNoValido e) {
                sc.nextLine();
                System.out.println("El numero introducido no es valido, vuelve a intentarlo");
            }
        } while (error);
        return alumnos;
    }
    public static int numeroAsignaturas() {
        boolean error = true;
        int asignaturas = 0;
        do {
            try {
                System.out.println("Dime el numero de asignaturas de la clase:");
                asignaturas = sc.nextInt();
                if (asignaturas < 0) {
                    throw new numeroNoValido();
                }
                error = false;
            } catch (InputMismatchException | numeroNoValido e) {
                sc.nextLine();
                System.out.println("El numero introducido no es valido, vuelve a intentarlo");
            }
        } while (error);
        return asignaturas;
    }
    public static void guardarNotas(int[][] clases) {
        boolean error = true;
        do {
            try{
                for (int i = 0; i < clases.length; i++) {
                    System.out.println("------------------------------------------");
                    for (int j = 0; j < clases[i].length; j++) {
                        System.out.println("Dime la nota de la asignatura " + (j+1) + " del alumno "+ (i+1) + " :");
                        clases[i][j] = sc.nextInt();
                        if ( clases[i][j] < 0 || clases[i][j] > 10) {
                            throw new numeroNoValido();
                        }
                    }
                }
                error = false;
            }catch (InputMismatchException | numeroNoValido e){
                sc.nextLine();
                System.out.println("El numero introducido no es valido, vuelve a intentarlo");
            }
        }while (error);
    }
    public static void mediaAlumnos(int[][] clases, int asignaturas) {
        for (int i = 0; i < clases.length; i++) {
            System.out.println("------------------------------------------");
            int suma = 0;
            int media;
            for (int j = 0; j < clases[i].length; j++) {
                suma += clases[i][j];
            }
            media = suma/asignaturas;
            System.out.println("La media del alumno "+ (i+1) + " es: " + media);
        }
    }
    public  static void mediaAsignaturas(int[][] clases, int alumnos, int asignaturas) {
        for (int i = 0; i < asignaturas; i++) {
            System.out.println("------------------------------------------");
            int suma = 0;
            int media;
            for (int j = 0; j < alumnos; j++) {
                suma += clases[j][i];
            }
            media = suma/alumnos;
            System.out.println("La media de la asignatura "+ (i+1) + " es: " + media);
        }
    }
    public  static void notaMasAlta(int[][] clases) {
        int notaMasAlta = 0;
        for (int[] clase : clases) {
            for (int i : clase) {
                if (i >= notaMasAlta) {
                    notaMasAlta = i;
                }
            }
        }
        System.out.println("------------------------------------------");
        System.out.println("La nota mas alta es: " + notaMasAlta);
    }
    public  static void notaMasBaja(int[][] clases) {
        int notaMasBaja = 10;
        for (int[] clase : clases) {
            for (int i : clase) {
                if (i <= notaMasBaja) {
                    notaMasBaja = i;
                }
            }
        }
        System.out.println("------------------------------------------");
        System.out.println("La nota mas baja es: " + notaMasBaja);
    }

}