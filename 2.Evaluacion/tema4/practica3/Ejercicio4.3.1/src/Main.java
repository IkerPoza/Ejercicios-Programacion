import Modelo.Alumno;
import Modelo.Autor;
import Modelo.Libro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Libro> libros = new ArrayList<>();
    public static ArrayList<Alumno> alumnos = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        generarDatos();
        menu();
    }
    public static void generarDatos(){
        ArrayList<Autor> autores = new ArrayList<>();
        autores.add(new Autor("España", LocalDate.of(1999,10,12),"Autor1"));
        autores.add(new Autor("España", LocalDate.of(1999,10,12),"Autor2"));
        autores.add(new Autor("España", LocalDate.of(1999,10,12),"Autor3"));
        autores.add(new Autor("España", LocalDate.of(1999,10,12),"Autor4"));

        libros.add(new Libro("Libro1","Editorial", 90, autores.get(0)));
        libros.add(new Libro("Libro2","Editorial", 90, autores.get(1)));
        libros.add(new Libro("Libro3","Editorial", 90, autores.get(2)));
        libros.add(new Libro("Libro4","Editorial", 90, autores.get(3)));

        ArrayList<Libro> librosA1 = new ArrayList<>();
        alumnos.add(new Alumno("España",LocalDate.of(2004,12,1),"Alumno1","123A", librosA1));

        ArrayList<Libro> librosA2 = new ArrayList<>();
        alumnos.add(new Alumno("España",LocalDate.of(2004,12,1),"Alumno2","123A", librosA2));

        ArrayList<Libro> librosA3 = new ArrayList<>();
        alumnos.add(new Alumno("España",LocalDate.of(2004,12,1),"Alumno3","123A", librosA3));

        ArrayList<Libro> librosA4 = new ArrayList<>();
        alumnos.add(new Alumno("España",LocalDate.of(2004,12,1),"Alumno4","123A", librosA4));
    }
    public static void menu(){
        boolean continuar = true;
        do {
            System.out.print("""
                    --- Menu Biblioteca ---
                    1. Alquiler Libro
                    2. Devolver Libro
                    3. Ver datos disponibles
                    4. Salir
                    """);
            int respuesta = sc.nextInt();
            switch (respuesta) {
                case 1:
                    sc.nextLine();
                    alquilarLibro();
                    break;
                case 2:
                    sc.nextLine();
                    devolverLibro();
                    break;
                case 3:
                    sc.nextLine();
                    datos();
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Se ha finalizado el programa.");
                    break;
            }
        }while (continuar);
    }
    public static void alquilarLibro(){
        int posicionLibro = 0;
        int posicionAlumno = 0;
        boolean error = true;
        do {
            try {
                System.out.println("Dime el nombre del alumno:");
                String nombre = sc.nextLine();
                System.out.println("Dime el libro que quieres alquilar:");
                String libro = sc.nextLine();
                for (int i = 0; i < alumnos.size(); i++) {
                    if(alumnos.get(i).getNombre().equalsIgnoreCase(nombre)){
                        posicionAlumno = i;
                        for (int x = 0; x < libros.size(); x++) {
                            if (libros.get(x).getTitulo().equalsIgnoreCase(libro)) {
                                error = false;
                                posicionLibro = x;
                            }
                        }
                    }
                }
                if (error) {
                    throw new DatoNoValido();
                }
            }catch(DatoNoValido e){
                System.out.println("El nombre del alumno o el libro no existe");
            }
        }while (error);

        libros.get(posicionLibro).alquilar(alumnos.get(posicionAlumno));
    }
    public static void devolverLibro(){
        int posicionLibro = 0;
        int posicionAlumno = 0;
        boolean error = true;
        do {
            try {
                System.out.println("Dime el nombre del alumno:");
                String nombre = sc.nextLine();
                System.out.println("Dime el libro que quieres devolver:");
                String libro = sc.nextLine();
                for (int i = 0; i < alumnos.size(); i++) {
                    if(alumnos.get(i).getNombre().equalsIgnoreCase(nombre)){
                        posicionAlumno = i;
                        for (int x = 0; x < libros.size(); x++) {
                            if (libros.get(x).getTitulo().equalsIgnoreCase(libro)) {
                                error = false;
                                posicionLibro = x;
                            }
                        }
                    }
                }
                if (error) {
                    throw new DatoNoValido();
                }
            }catch(DatoNoValido e){
                System.out.println("El nombre del alumno o el libro no existe");
            }
        }while (error);

        alumnos.get(posicionAlumno).devolver(libros.get(posicionLibro));
    }
    public static void datos(){
        System.out.println("Los libros disponibles son:");
        for (Libro libro : libros) {
            if (libro.getNumeroEjemplares() > 0) {
                System.out.println(libro.getTitulo() + " --> " + libro.getNumeroEjemplares());
            }
        }
        System.out.println("\nLos datos de los alumnos son:");
        for (Alumno alumno : alumnos) {
            System.out.println(alumno.getNombre()+ " --> "+ alumno.getLibrosAlquilados().size());
        }
    }
}