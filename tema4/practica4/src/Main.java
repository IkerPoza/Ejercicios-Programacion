import Modelo.Coche;
import Modelo.Propietario;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static ArrayList<Coche> coches = new ArrayList<>();
    public static ArrayList<Propietario> propietarios = new ArrayList<>();
    public static void main(String [] args) {
        // COCHES
        Coche c1 = new Coche("1234 ABC", "Toyota", 2018 , 18000);
        Coche c2 = new Coche("5678 DEF", "BMW", 2015 , 25000);
        Coche c3 = new Coche("9012 GHI", "Seat", 2012 , 12000);

        Coche c4 = new Coche("3456 JKL", "Toyota", 2020 , 22000);
        Coche c5 = new Coche("7890 MNO", "Audi", 2017 , 30000);
        Coche c6 = new Coche("1122 PQR", "BMW", 2010 , 15000);

        Coche c7 = new Coche("3344 STU", "Seat", 2019 , 16000);
        Coche c8 = new Coche("5566 VWX", "Audi", 2014 , 20000);
        Coche c9 = new Coche("7788 YZA", "Toyota", 2021 , 24000);

        coches.add(c1);
        coches.add(c2);
        coches.add(c3);
        coches.add(c4);
        coches.add(c5);
        coches.add(c6);
        coches.add(c7);
        coches.add(c8);
        coches.add(c9);

        // PROPIETARIOS
        Propietario p1 = new Propietario (
                "Carlos",
                List.of(c1 , c2 , c3)
                );

        Propietario p2 = new Propietario (
                "Ana",
                List.of(c4 , c5 , c6)
                );

        Propietario p3 = new Propietario (
                "Luis",
                List.of(c7 , c8 , c9)
                );
        propietarios.add(p1);
        propietarios.add(p2);
        propietarios.add(p3);

        ejercicioUno();
        ejerciciodos();
        ejerciciotres();
        ejerciciocuatro();
        ejerciciocinco();
        ejercicioseis();
        ejerciciosiete();
        ejercicioocho();
        ejercicionueve();
        ejerciciodiez();
        ejercicioonce();
        ejerciciodoce();
        ejerciciotrece();
    }
    public static void ejercicioUno() {
        List <String> matriculas = coches.stream()
                .map(Coche::getMatricula)
                .toList();

        System.out.println("Matriculas: " + matriculas);

        List <String> matriculas2 = new ArrayList<>();
        for (Coche coche : coches){
            matriculas2.add(coche.getMatricula());
        }

        System.out.println("Matriculas: " + matriculas2);
    }

    public static void ejerciciodos() {
        List<String> numeroCoches = propietarios.stream()
                .map(propietario -> propietario.getNombre() + " - " + propietario.getCoches().size())
                .toList();

        System.out.println("Coches: " + numeroCoches);

        List <String> numeroCoches2 = new ArrayList<>();
        for (Propietario propietario : propietarios){
            numeroCoches2.add(propietario.getNombre() + " - " + propietario.getCoches().size());
        }

        System.out.println("Coches: " + numeroCoches2);
    }

    public static void ejerciciotres() {
        List<String> cochespost2015 = coches.stream()
                .filter(coche -> coche.getAno() > 2015)
                .map(Coche::getMatricula)
                .toList();

        System.out.println("Coches: " + cochespost2015);

        List<String> cochespost20152 = new ArrayList<>();
        for (Coche coche : coches){
            if (coche.getAno() > 2015){
                cochespost20152.add(coche.getMatricula());
            }
        }

        System.out.println("Coches: " + cochespost20152);
    }

    public static void ejerciciocuatro() {
        double preciomedio = coches.stream()
                .mapToDouble(Coche::getPrecio)
                .average()
                .orElse(0.0);

        System.out.println("Precio: " + preciomedio);

        double preciomedio2 = 0.0;

        for (Coche coche : coches){
            preciomedio2 += coche.getPrecio();
        }
        preciomedio2 = preciomedio2 / coches.size();

        System.out.println("Precio: " + preciomedio2);
    }

    public static void ejerciciocinco() {
        String cochemascaro = (coches.stream()
                .max(Comparator.comparing(Coche::getPrecio))
                .map(Coche::getMatricula)
                .orElse(""));

        System.out.println("Coches mas caro: " + cochemascaro);

        String cochesmascaro2 = "";
        double preciomascaro = 0;

        for (Coche coche : coches){
            if (coche.getPrecio() > preciomascaro){
                cochesmascaro2 = coche.getMatricula();
                preciomascaro = coche.getPrecio();
            }
        }
        System.out.println("Coches mas caro: " + cochesmascaro2);
    }

    public static void ejercicioseis() {
        boolean marcaBMW = coches.stream()
                .anyMatch(coche -> coche.getMarca().equalsIgnoreCase("BMW"));

        System.out.println("Marca BMW: " + marcaBMW);
        
        boolean marcaBMW2 = false;
        
        for (Coche coche : coches){
            if (coche.getMarca().equalsIgnoreCase("BMW")){
                marcaBMW2 = true;
                break;
            }
        }
        System.out.println("Marca BMW: " + marcaBMW2);
    }

    public static void ejerciciosiete() {
        List<String> listaporprecio = coches.stream()
                .sorted(Comparator.comparing(Coche::getPrecio))
                .map(Coche::getMatricula)
                .toList();

        System.out.println("Lista coches por precio: " + listaporprecio);

        ArrayList<Coche> listaporprecio2 = new ArrayList<>(coches);

        Coche guardar;

        for (int i = 0; i<listaporprecio2.size(); i++){
            for (int j = i+1; j<listaporprecio2.size(); j++){
                if (listaporprecio2.get(j).getPrecio() < listaporprecio2.get(i).getPrecio()){
                    guardar = listaporprecio2.get(i);
                    listaporprecio2.set(i, listaporprecio2.get(j));
                    listaporprecio2.set(j, guardar);
                }
            }
        }

        for (Coche coche : listaporprecio2){
            System.out.println(coche.getMatricula()+ " -> " + coche.getPrecio());
        }
    }

    public static void ejercicioocho() {
        String cochemasantiguo = coches.stream()
                .min(Comparator.comparing(Coche::getAno))
                .map(Coche::getMatricula)
                .orElse("");

        System.out.println("Coches mas antiguo: " + cochemasantiguo);

        String cochemasantiguo2 = "";
        int anomasantiguo = coches.getFirst().getAno();
        for (Coche coche : coches){
            if (coche.getAno() < anomasantiguo){
                anomasantiguo = coche.getAno();
                cochemasantiguo2 = coche.getMatricula();
            }
        }

        System.out.println("Coches mas antiguo: " + cochemasantiguo2);
    }

    public static void ejercicionueve(){
        long contadorCoches = coches.stream()
                .filter(coche -> coche.getPrecio() > 20000)
                .count();
        System.out.println("Coches con precio mas de 20000: " + contadorCoches);

        int contadorCoches2 = 0;
        for (Coche coche : coches){
            if (coche.getPrecio() > 20000){
                contadorCoches2++;
            }
        }
        System.out.println("Coches con precio mas de 20000: " + contadorCoches2);
    }

    public static void ejerciciodiez(){
        System.out.println("Marcas: "+coches.stream()
                .map(Coche::getMarca)
                .distinct()
                .toList());

        ArrayList<String> marcas = new ArrayList<>();

        for (Coche coche : coches){
            if (!marcas.contains(coche.getMarca())){
                marcas.add(coche.getMarca());
            }
        }

        System.out.println("Marcas: " + marcas);
    }

    public static void ejercicioonce(){
        Map<String, Double> matriculaPrecio = coches.stream()
                .collect(Collectors.toMap(Coche::getMatricula, Coche::getPrecio));

        System.out.println("Matricula y precio: " + matriculaPrecio);

        Map<String, Double> matriculaPrecio2 = new HashMap<>();
        for (Coche coche : coches){
            matriculaPrecio2.put(coche.getMatricula(), coche.getPrecio());
        }

        System.out.println("Matricula y precio: " + matriculaPrecio2);
    }

    public static void ejerciciodoce(){
        Map<String, List<Coche>> cochesmarca = coches.stream()
                .collect(Collectors.groupingBy(Coche::getMarca));

        cochesmarca.forEach((marca, lista) -> {
            System.out.println("Marca: " + marca);
            lista.forEach(c -> System.out.println("  " + c.getMatricula()));
        });

        Map<String, List<Coche>> cochesmarca2 = new HashMap<>();

        for (Coche coche : coches){
            if (!cochesmarca2.containsKey(coche.getMarca())){
                cochesmarca2.put(coche.getMarca(), new ArrayList<>());
                cochesmarca2.get(coche.getMarca()).add(coche);
            }else {
                cochesmarca2.get(coche.getMarca()).add(coche);
            }
        }
        cochesmarca2.forEach((marca, lista) -> {
            System.out.println("Marca: " + marca);
            lista.forEach(c -> System.out.println("  " + c.getMatricula()));
        });
    }

    public static void ejerciciotrece(){
        Map<String,List<Coche>> cochesedad = coches.stream()
                .collect(Collectors.groupingBy(coche -> coche.getAno() < 2015 ? "Antiguos" : "Modernos"));

        cochesedad.forEach((edad, lista) -> {
            System.out.println("Edad: " + edad);
            lista.forEach(c -> System.out.println("  " + c.getMatricula()));
        });
    }
}