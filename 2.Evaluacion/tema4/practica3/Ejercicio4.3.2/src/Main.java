import Modelo.Cliente;
import Modelo.Mascota;
import Modelo.Veterinario;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Mascota> listaMascotas = new ArrayList<>();
    public static ArrayList<Cliente> listaClientes = new ArrayList<>();
    public static ArrayList<Veterinario> listaVeterinarios = new ArrayList<>();
    public static void main(String[] args) {
        agregarVeterinarios();
        agregarCliente();
        agregarMascota();
        menu();
    }
    public static void agregarVeterinarios(){
        boolean continuar;
        do {
            System.out.println("--- Agregar Veterinario ---");
            continuar = true;
            listaVeterinarios.add(new Veterinario(
                    solicitarDato("Nombre","Introduce el nombre:","^[a-z]+$"),
                    solicitarDato("Dirección","Introduce la dirección:","^[a-z]+$"),
                    solicitarDato("Teléfono","Introduce el teléfono:","^[0-9]{9}$"),
                    solicitarDato("DNI","Introduce el DNI","^[0-9]{8}[a-z]$"),
                    solicitarDato("Numero Seguridad Social", "Introduce el numero seguridad social","^[0-9]+$")
            ));

            boolean error;
            do {
                System.out.println("Quieres añadir otro veterinario? (si/no)");
                String opcion = sc.nextLine();
                error = false;
                if(opcion.equalsIgnoreCase("no")){
                    continuar = false;
                }else if(!opcion.equalsIgnoreCase("si")){
                    System.out.println("La respuesta no es correcta, vuelve a intentarlo");
                    error = true;
                }
            }while(error);
        }while(continuar);
    }

    public static void agregarCliente(){
        boolean continuar;
        do {
            System.out.println("--- Agregar Cliente ---");
            continuar = true;
            listaClientes.add(new Cliente(
                    solicitarDato("Nombre","Introduce el nombre:","^[a-z]+$"),
                    solicitarDato("Dirección","Introduce la dirección:","^[a-z]+$"),
                    solicitarDato("Teléfono","Introduce el teléfono:","^[0-9]{9}$")
            ));

            boolean error;
            do {
                System.out.println("Quieres añadir otro Cliente? (si/no)");
                String opcion = sc.nextLine();
                error = false;
                if(opcion.equalsIgnoreCase("no")){
                    continuar = false;
                }else if(!opcion.equalsIgnoreCase("si")){
                    System.out.println("La respuesta no es correcta, vuelve a intentarlo");
                    error = true;
                }
            }while(error);
        }while(continuar);
    }

    public static void agregarMascota(){
        boolean continuar;
        do {
            String nombre;
            System.out.println("--- Agregar Mascota ---");
            continuar = true;
            listaMascotas.add(new Mascota(
                    solicitarDato("Tipo","Introduce el tipo:","^(perro|gato)$"),
                    solicitarDato("raza","Introduce la raza:","^[a-z]+$"),
                    nombre = solicitarDato("nombre","Introduce el nombre:","^[a-z]+$")
            ));
            boolean error;
            do {
                error = false;
                String nombreCliente = solicitarDato("Nombre", "Dime el nombre del cliente asociado con la mascota", "^[a-z]+$");
                boolean existeCliente = false;
                for (Cliente cliente : listaClientes) {
                    if (cliente.getNombre().equalsIgnoreCase(nombreCliente)) {
                        existeCliente = true;
                        for (Mascota mascota : listaMascotas) {
                            if (mascota.getNombre().equalsIgnoreCase(nombre)) {
                                mascota.setCliente(cliente);
                                cliente.setMascota(mascota);
                            }
                        }
                    }
                }
                if (!existeCliente) {
                    System.out.println("El nombre del cliente no existe");
                    error = true;
                }
            }while (error);

            do {
                error = false;
                String nombreVeterinario = solicitarDato("Nombre", "Dime el nombre del veterinario asociado con la mascota", "^[a-z]+$");
                boolean existeVeterinario = false;
                for (Veterinario veterinario : listaVeterinarios) {
                    if (veterinario.getNombre().equalsIgnoreCase(nombreVeterinario)) {
                        existeVeterinario = true;
                        for (Mascota mascota : listaMascotas) {
                            if (mascota.getNombre().equalsIgnoreCase(nombre)) {
                                mascota.setVeterinario(veterinario);
                                veterinario.setMascota(mascota);
                            }
                        }
                    }
                }
                if (!existeVeterinario) {
                    System.out.println("El nombre del veterinario no existe");
                    error = true;
                }
            }while (error);

            do {
                System.out.println("Quieres añadir otra Mascota? (si/no)");
                String opcion = sc.nextLine();
                error = false;
                if(opcion.equalsIgnoreCase("no")){
                    continuar = false;
                }else if(!opcion.equalsIgnoreCase("si")){
                    System.out.println("La respuesta no es correcta, vuelve a intentarlo");
                    error = true;
                }
            }while(error);
        }while(continuar);
    }

    public static String solicitarDato(String dato, String mensaje, String exp){
        String respuesta = "";
        boolean error = false;
        do {
            try {
                System.out.println(mensaje);
                respuesta = sc.nextLine();
                respuesta = respuesta.toLowerCase();
                if (!respuesta.matches(exp)) {
                    throw new DatoNoValido();
                }
                error = true;
            }catch (DatoNoValido e){
                System.out.println(dato + " no es correcto, vuelve a intentarlo");
            }
        }while (!error);
        return respuesta;
    }

    public static void menu(){
        boolean continuar = true;
        do {
            System.out.print("""
                    --- MENU ---
                    1. Mostrar el numero de clientes que poseen un tipo de animal concreto.
                    2. Datos personales del cliente a partir del nombre de mascota.
                    3. Datos del veterinario a partir de los datos de una mascota.
                    4. Datos de las mascotas de un cliente.
                    5. Datos de las mascotas de un veterinario.
                    6. Terminar.
                    """);
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    mostrar1();
                    break;
                case 2:
                    mostrar2();
                    break;
                case 3:
                    mostrar3();
                    break;
                case 4:
                    mostrar4();
                    break;
                case 5:
                    mostrar5();
                    break;
                case 6:
                    System.out.println("El programa a finalizado");
                    continuar = false;
                    break;
                default:
                    System.out.println("La respuesta es incorrecta, vuelve a intentarlo");
            }
        }while (continuar);
    }

    public static void mostrar1(){
        int contador = 0;
        String tipo = solicitarDato("Tipo", "Dime el tipo de animal concreto.", "^(perro|gato)$");
        for (Cliente cliente :  listaClientes){
            for (Mascota mascota :  cliente.getMascotas()){
                if (mascota.getTipo().equalsIgnoreCase(tipo)){
                    contador++;
                }
            }
        }
        System.out.println("El numero de clientes que poseen "+tipo+" son: "+contador);
    }

    public static void mostrar2(){
        String nombreMascota = solicitarDato("Nombre", "Introduce el nombre de la mascota", "^[a-z]+$");
        for (Mascota mascota :  listaMascotas){
            if (mascota.getNombre().equalsIgnoreCase(nombreMascota)){
                System.out.println(mascota.getCliente().toString());
            }
        }
    }

    public static void mostrar3(){
        String nombreMascota = solicitarDato("Nombre", "Introduce el nombre de la mascota", "^[a-z]+$");
        for (Mascota mascota :  listaMascotas){
            if (mascota.getNombre().equalsIgnoreCase(nombreMascota)){
                System.out.println(mascota.getVeterinario().toString());
            }
        }
    }

    public static void mostrar4(){
        String nombreCliente = solicitarDato("Nombre", "Introduce el nombre del cliente", "^[a-z]+$");
        for (Cliente cliente :  listaClientes){
            if (cliente.getNombre().equalsIgnoreCase(nombreCliente)){
                System.out.println("---"+cliente.getNombre().toUpperCase()+"---");
                for (Mascota mascota :  cliente.getMascotas()){
                    System.out.println(mascota.toString());
                }
            }
        }
    }

    public static void mostrar5(){
        String nombreVeterinario = solicitarDato("Nombre", "Introduce el nombre del veterinario", "^[a-z]+$");
        for (Veterinario veterinario :  listaVeterinarios){
            if (veterinario.getNombre().equalsIgnoreCase(nombreVeterinario)){
                System.out.println("---"+veterinario.getNombre().toUpperCase()+"---");
                for (Mascota mascota :  veterinario.getMascotas()){
                    System.out.println(mascota.toString());
                }
            }
        }
    }
}