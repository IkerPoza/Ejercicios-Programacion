import Modelo.Estudio;
import Modelo.Pelicula;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    private static Estudio[] estudios;
    private static ArrayList<Pelicula> peliculas;
    public static void main(String[] args) {
        crearEstudios();
        crearPeliculas();
        resultados();
    }
    public static void crearEstudios() {
        Estudio universal = new Estudio("Universal", "Albacete", "Calle Castilla", "universal.com",
                LocalDate.of(1985,5,3), "España", 687348384);

        Estudio century = new Estudio("Century", "Granada", "Calle Dos", "century.com",
                LocalDate.of(1993,9,10), "España", 694839273);

        Estudio warner = new Estudio("Warner", "Paris", "Calle Paris", "warmer.com",
                LocalDate.of(1975,8,12), "Francia", 857392043);
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

        HashMap <String, Integer> estudiosPeliculas = new HashMap<>();

        for (Estudio estudio : estudios) {
            String estudioactual = estudio.getNombre();
            estudiosPeliculas.put(estudioactual, 0);
            for (Pelicula pelicula : peliculas) {
                for (int j = 0; j < pelicula.getEstudios().size(); j++) {
                    if (pelicula.getEstudios().get(j).getNombre().equals(estudioactual)) {
                        estudiosPeliculas.put(estudioactual, estudiosPeliculas.get(estudioactual) + 1);
                    }
                }
            }
        }

        String mayorNumeroPeliculas = "";
        int numeroPeliculas = 0;
        for (Estudio estudio : estudios) {
            if (numeroPeliculas < estudiosPeliculas.get(estudio.getNombre())) {
                mayorNumeroPeliculas = estudio.getNombre();
                numeroPeliculas = estudiosPeliculas.get(estudio.getNombre());
            }
        }

        System.out.println("Este es el estudio con el mayor numero de peliculas: "+mayorNumeroPeliculas);
    }
}