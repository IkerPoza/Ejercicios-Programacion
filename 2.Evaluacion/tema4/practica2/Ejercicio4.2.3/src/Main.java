import Modelo.Cliente;
import Modelo.Directivo;
import Modelo.Empleado;
import Modelo.Empresa;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Cliente> clientes;
    public static ArrayList<Empleado> empleados;
    public static ArrayList<Directivo> directivos;
    public static ArrayList<Empresa> empresas;
    public static void main(String[] args) {
        crearClientes();
        crearEmpleados();
        crearDirectivos();
        crearEmpresas();
        buscar();
    }
    public static void crearClientes() {
        clientes = new ArrayList<>();
        clientes.add(new Cliente("C1", 30, 101));
        clientes.add(new Cliente("C2", 30, 102));
        clientes.add(new Cliente("C3", 30, 103));
        clientes.add(new Cliente("C4", 30, 104));
        clientes.add(new Cliente("C5", 30, 105));
        clientes.add(new Cliente("C6", 30, 106));
        clientes.add(new Cliente("C7", 30, 107));
        clientes.add(new Cliente("C8", 30, 108));
        clientes.add(new Cliente("C9", 30, 109));
        clientes.add(new Cliente("C10", 30, 1010));
    }
    public static void crearEmpleados() {
        empleados = new ArrayList<>();
        empleados.add(new Empleado("E1", 30, 10000));
        empleados.add(new Empleado("E2", 30, 10000));
        empleados.add(new Empleado("E3", 30, 10000));
        empleados.add(new Empleado("E4", 30, 10000));
        empleados.add(new Empleado("E5", 30, 10000));
    }
    public static void crearDirectivos() {
        directivos = new ArrayList<>();
        ArrayList<Empleado> subordinados1 = new ArrayList<>();
        subordinados1.add(empleados.get(0));
        directivos.add(new Directivo("D1",30,10000,"C1",subordinados1));
        ArrayList<Empleado> subordinados2 = new ArrayList<>();
        subordinados2.add(empleados.get(1));
        subordinados2.add(empleados.get(2));
        subordinados2.add(empleados.get(3));
        directivos.add(new Directivo("D2",30,10000,"C2",subordinados2));
        ArrayList<Empleado> subordinados3 = new ArrayList<>();
        subordinados3.add(empleados.get(4));
        directivos.add(new Directivo("D3",30,10000,"C3",subordinados3));

    }
    public  static void crearEmpresas() {
        empresas = new ArrayList<>();
        ArrayList<Cliente> clientesEmp1 = new ArrayList<>();
        clientesEmp1.add(clientes.get(0));
        clientesEmp1.add(clientes.get(1));
        clientesEmp1.add(clientes.get(2));
        clientesEmp1.add(clientes.get(3));

        ArrayList<Empleado> empleadosEmp1 = new ArrayList<>();
        empleadosEmp1.add(empleados.get(0));
        empleadosEmp1.add(empleados.get(1));
        empleadosEmp1.add(directivos.get(0));

        empresas.add(new Empresa("Empresa1", empleadosEmp1, clientesEmp1));

        ArrayList<Cliente> clientesEmp2 = new ArrayList<>();
        clientesEmp2.add(clientes.get(4));
        clientesEmp2.add(clientes.get(5));
        clientesEmp2.add(clientes.get(6));

        ArrayList<Empleado> empleadosEmp2 = new ArrayList<>();
        empleadosEmp2.add(empleados.get(2));
        empleadosEmp2.add(empleados.get(3));
        empleadosEmp2.add(directivos.get(1));

        empresas.add(new Empresa("Empresa2", empleadosEmp2, clientesEmp2));

        ArrayList<Cliente> clientesEmp3 = new ArrayList<>();
        clientesEmp3.add(clientes.get(7));
        clientesEmp3.add(clientes.get(8));
        clientesEmp3.add(clientes.get(9));

        ArrayList<Empleado> empleadosEmp3 = new ArrayList<>();
        empleadosEmp3.add(empleados.get(4));
        empleadosEmp3.add(directivos.get(2));
        empresas.add(new Empresa("Empresa3", empleadosEmp3, clientesEmp3));
    }
    public  static void buscar(){
        int max = 0;
        Directivo objetoMaximo = null;

        for (Empresa empresa : empresas) {
            for (int y = 0; y < empresa.getEmpleados().size(); y++) {
                if (empresa.getEmpleados().get(y) instanceof Directivo) {
                    Directivo objeto = (Directivo) empresa.getEmpleados().get(y);
                    if (objeto.getSubordinados().size() > max) {
                        objetoMaximo = objeto;
                        max = objeto.getSubordinados().size();
                    }
                }
            }

        }
        System.out.println(" El directivo que más subordinados tiene es " + objetoMaximo.getNombre() + " y tiene " + max + " empleados a su cargo");
    }
}