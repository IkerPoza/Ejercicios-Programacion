import Modelo.Cliente;
import Modelo.Empresa;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Cliente> clientes;
    public static void main(String[] args) {
        crearClientes();
        crearEmpresas();
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
    public  static void crearEmpresas() {
        ArrayList<Empresa> empresas = new ArrayList<>();
        ArrayList<Cliente> clientesEmp1 = new ArrayList<>();
        clientesEmp1.add(clientes.get(0));
        clientesEmp1.add(clientes.get(1));
        clientesEmp1.add(clientes.get(2));
        clientesEmp1.add(clientes.get(3));


        empresas.add(new Empresa("Empresa1", clientesEmp1, ))
    }
}