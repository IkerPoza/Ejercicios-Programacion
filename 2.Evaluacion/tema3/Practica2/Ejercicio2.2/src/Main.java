import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<ArrayList<Integer>> notasAlumnos = new ArrayList<>();
    public static int notaProg = 0,  numeroAlumno = 0, contadorProg = 0;
    public static String[] nombresAsignaturas = {"Programacion", "Entornos de Desarrollo", "Base de Datos", "Lenguaje de Marcas", "Digitalizacion", "Sostenibilidad", "IPE1", "Ingles"};

    public static void main(String[] args) {
        pedirNotas();
        mostrarNotas();
    }

    public static void pedirNotas() {
        boolean continuar = true;
        do {
            notasAlumnos.add(new ArrayList<>());
                boolean continuar2 = true;
                do {
                    try{
                        System.out.println("De que asignatura quieres añadir la nota?");
                        String asignatura = sc.nextLine();
                        if(!Arrays.asList(nombresAsignaturas).contains(asignatura)) {
                            throw new datoNoValido();
                        }
                        System.out.println("Dime la nota de la asignatura:");
                        int nota = sc.nextInt();
                        if (nota < 0 || nota > 10) {
                            throw  new notaNoValida();
                        }
                        notasAlumnos.get(numeroAlumno).add(nota);
                        if (asignatura.equalsIgnoreCase("programacion")) {
                            notaProg += nota;
                            contadorProg++;
                        }
                        sc.nextLine();
                        boolean error = true;
                        do {
                            System.out.println("Quieres añadir otra nota?");
                            String opcion1 = sc.nextLine();
                            if (opcion1.equalsIgnoreCase("no")) {
                                continuar2 = false;
                                error = false;
                            } else if (opcion1.equalsIgnoreCase("si")) {
                                System.out.println("---Nueva nota---");
                                error = false;
                            } else {
                                System.out.println("Opcion incorrecta");
                            }
                        }while (error);
                    }catch (datoNoValido e){
                        System.out.println("El dato introducido no es valido, vuelve a intentarlo");
                    }catch (notaNoValida | InputMismatchException e) {
                        System.out.println("La nota de la asignatura es incorrecta, vuelve a intentarlo");
                        sc.nextLine();
                    }
                } while (continuar2);
                boolean error = true;
                do {
                    System.out.println("Quieres añadir otro alumno?");
                    String opcion = sc.nextLine();
                    if (opcion.equalsIgnoreCase("no")) {
                        continuar = false;
                        error = false;
                    } else if (opcion.equalsIgnoreCase("si")) {
                        System.out.println("---Nuevo Alumno---");
                        error = false;
                    } else {
                        System.out.println("Opcion incorrecta");
                    }
                }while (error);
                numeroAlumno++;
        } while (continuar);
    }

    public static void mostrarNotas() {
        for (ArrayList<Integer> notasAlumno : notasAlumnos) {
            int suma = 0;
            int contador = 0;
            for (Integer integer : notasAlumno) {
                if (integer > 0) {
                    suma += integer;
                    contador++;
                }
            }
            System.out.println("La media del alumno es " + suma / contador);
        }
        System.out.println("La media de la asignatura programacion es " + notaProg / contadorProg);
    }
}