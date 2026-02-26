package Modelo;

import java.util.ArrayList;

public class Directivo extends Empleado {
    private String categoria;
    private ArrayList<Empleado> subordinados = new ArrayList();

    public Directivo(String nombre, int edad, int sueldoBruto, String categoria, ArrayList<Empleado> subordinados) {
        super(nombre, edad, sueldoBruto);
        this.categoria = categoria;
        this.subordinados = subordinados;
    }

    public ArrayList<Empleado> getSubordinados() {
        return subordinados;
    }

    public void setSubordinados(ArrayList<Empleado> subordinados) {
        this.subordinados = subordinados;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String mostrar() {
        return "El directivo se llama " + this.getNombre() + " y tiene " + this.getEdad() + " años.\n" +
                "Y su sueldo bruto es " + this.getSueldoBruto() +
                "\nY su categoria es " + categoria;
    }
}
