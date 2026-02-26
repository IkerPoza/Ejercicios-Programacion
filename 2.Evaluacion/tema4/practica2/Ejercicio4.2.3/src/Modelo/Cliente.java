package Modelo;

public class Cliente extends Persona {
    private int telefono;

    public Cliente(String nombre, int edad, int telefono) {
        super(nombre, edad);
        this.telefono = telefono;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String mostrar(){
        return "El cliente se llama " + this.getNombre() + " y tiene " + this.getEdad() + " años.\n" +
                "Y su telefono es " + telefono;
    }
}
