package Modelo;

public class Mascota {
    private String tipo;
    private String raza;
    private String nombre;
    private Cliente cliente;
    private Veterinario veterinario;

    public Mascota(String tipo, String raza, String nombre) {
        this.tipo = tipo;
        this.raza = raza;
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    @Override
    public String toString() {
        return "--- MASCOTA ---" +
                "\n-Nombre:"+getNombre()+
                "\n-Tipo:"+getTipo()+
                "\n-Raza:"+getRaza()+
                "\n-Cliente:"+getCliente().getNombre()+
                "\n-Veterinario:"+getVeterinario().getNombre();
    }
}
