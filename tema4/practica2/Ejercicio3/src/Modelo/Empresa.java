package Modelo;

import java.util.ArrayList;

public class Empresa {
    private String nombre;
    private ArrayList<Empleado> empleados = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public Empresa(String nombre, ArrayList<Empleado> empleados, ArrayList<Cliente> clientes) {
        this.nombre = nombre;
        this.empleados = empleados;
        this.clientes = clientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
}
