package Modelo;

public class Empleado extends Persona {
    private int sueldoBruto;

    public Empleado(String nombre, int edad, int sueldoBruto) {
        super(nombre, edad);
        this.sueldoBruto = sueldoBruto;
    }

    public int getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(int sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    public String mostrar() {
        return "El empleado se llama " + this.getNombre() + " y tiene " + this.getEdad() + " años.\n" +
                "Y su sueldo bruto es " + sueldoBruto;
    }

    public int calcularSalario(){
        return this.sueldoBruto;
    }
}
