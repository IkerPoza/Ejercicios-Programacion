package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Alumno extends Persona{
    private String DNI;
    private ArrayList<Libro> librosAlquilados;

    public Alumno(String paisNacimiento, LocalDate fechaNacimiento, String nombre, String DNI, ArrayList<Libro> librosAlquilados) {
        super(paisNacimiento, fechaNacimiento, nombre);
        this.DNI = DNI;
        this.librosAlquilados = new ArrayList<>();
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public ArrayList<Libro> getLibrosAlquilados() {
        return librosAlquilados;
    }

    public void setLibrosAlquilados(ArrayList<Libro> librosAlquilados) {
        this.librosAlquilados = librosAlquilados;
    }

    public void alquilar(Libro libro){
        if(librosAlquilados.size()<3){
            librosAlquilados.add(libro);
            System.out.println("El alumno "+getNombre()+" a alquilado el libro "+libro.getTitulo());
        }else {
            System.out.println("El alumno no puede alquilar mas libros");
        }
    }

    public void devolver (Libro libro){
        int posicionLibro = 0;
        boolean cont = false;
        if (!librosAlquilados.isEmpty()){
            for (int i = 0; i<librosAlquilados.size(); i++){
                if(librosAlquilados.get(i).getTitulo().equals(libro.getTitulo())){
                    posicionLibro = i;
                    System.out.println("El libro alquilado "+librosAlquilados.get(i).getTitulo()+" se ha devuelto");
                    libro.devolver(this);
                    cont = true;
                }
            }
            librosAlquilados.remove(posicionLibro);
        }

        if(!cont){
            System.out.println("El libro "+libro.getTitulo()+" no lo tiene el "+getNombre()+" alquilado");
        }
    }
}
