import Modelo.Estudio;
import Modelo.Pelicula;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    private static Estudio[] estudios;
    private static ArrayList<Pelicula> peliculas, peliculasUniversal, peliculasCentury, peliculasWarner;
    public static void main(String[] args) {
        crearEstudios();
        crearPeliculas();
        resultados();
    }
    public static void crearEstudios() {
        peliculasUniversal = new ArrayList<>();
        Estudio universal = new Estudio("Universal", "Albacete", "Calle Castilla", "universal.com",
                LocalDate.of(1985,5,3), "España", 687348384, peliculasUniversal);

        peliculasCentury = new ArrayList<>();
        Estudio century = new Estudio("Century", "Granada", "Calle Dos", "century.com",
                LocalDate.of(1993,9,10), "España", 694839273, peliculasCentury);

        peliculasWarner = new ArrayList<>();
        Estudio warner = new Estudio("Warner", "Paris", "Calle Paris", "warmer.com",
                LocalDate.of(1975,8,12), "Francia", 857392043, peliculasWarner);
        estudios = new Estudio[3];
        estudios[0] = universal;
        estudios[1] = century;
        estudios[2] = warner;
    }

    public static void crearPeliculas() {
        ArrayList<Estudio> estudiosEt = new ArrayList<>();
        estudiosEt.add(estudios[0]);
        estudiosEt.add(estudios[1]);
        Pelicula et = new Pelicula("ET",2002, 90, "Comedia", estudiosEt);

        ArrayList<Estudio> estudiosTitanic = new ArrayList<>();
        estudiosTitanic.add(estudios[1]);
        estudiosTitanic.add(estudios[2]);
        Pelicula titanic = new Pelicula("Titanic",1998, 180, "Romance", estudiosTitanic);

        ArrayList<Estudio> estudiosElReyLeon = new ArrayList<>();
        estudiosElReyLeon.add(estudios[2]);
        estudiosElReyLeon.add(estudios[1]);
        Pelicula elReyLeon = new Pelicula("El Rey Leon",2005, 97, "Comedia", estudiosElReyLeon);

        peliculas = new ArrayList<>();
        peliculas.add(titanic);
        peliculas.add(elReyLeon);
        peliculas.add(et);

        peliculasUniversal.add(et);
        peliculasCentury.add(titanic);
        peliculasCentury.add(elReyLeon);
        peliculasCentury.add(et);
        peliculasWarner.add(titanic);
        peliculasWarner.add(elReyLeon);
    }

    public static void resultados() {
        int mayorDuracion = 0;
        int posicionMayorDuracion = 0;

        for (int i = 0; i<peliculas.size(); i++) {
            if (peliculas.get(i).getDuracion() > mayorDuracion) {
                mayorDuracion = peliculas.get(i).getDuracion();
                posicionMayorDuracion = i;
            }
        }

        StringBuilder estudiosDePelicula = new StringBuilder();
        for (int i = 0; i<peliculas.get(posicionMayorDuracion).getEstudios().size(); i++) {
            estudiosDePelicula.append("\n-").append(peliculas.get(posicionMayorDuracion).getEstudios().get(i).getNombre());
        }

        System.out.println("La pelicula con mayor duracion es:\n-"
                + peliculas.get(posicionMayorDuracion).getTitulo() +
                "\nY es de: " +
                estudiosDePelicula);

        int mayorPeliculas = 0;
        int posicionMayorPeliculas = 0;

        for (Estudio estudio : estudios) {
            int contador = 0;
            for (int x = 0; x < estudio.getPeliculas().size(); x++) {
                contador++;
            }
            if (contador > mayorPeliculas) {
                mayorPeliculas = contador;
            }
        }

        for (int i = 0; i<estudios.length; i++) {
            int contador = 0;
            for (int x = 0; x<estudios[i].getPeliculas().size(); x++) {
                contador++;
            }
            if (mayorPeliculas == contador){
                posicionMayorPeliculas = i;
            }
        }

        System.out.println("El estudio con mayor numero de peliculas es: "+ estudios[posicionMayorPeliculas].getNombre());
    }
}