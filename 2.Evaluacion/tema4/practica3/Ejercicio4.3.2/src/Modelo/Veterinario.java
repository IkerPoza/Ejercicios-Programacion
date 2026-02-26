package Modelo;

import java.util.ArrayList;

public class Veterinario extends Persona {
    private String DNI;
    private String numeroSS;
    private ArrayList<Mascota> mascotas;

    public Veterinario(String nombre, String direccion, String telefono, String DNI, String numeroSS) {
        super(nombre, direccion, telefono);
        this.DNI = DNI;
        this.numeroSS = numeroSS;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNumeroSS() {
        return numeroSS;
    }

    public void setNumeroSS(String numeroSS) {
        this.numeroSS = numeroSS;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public void setMascota(Mascota mascota) {
        if (mascotas == null) {
            mascotas = new ArrayList<>();
        }
        mascotas.add(mascota);
    }

    @Override
    public String toString() {
        if (mascotas == null) {
            return null;
        }else {
            return "--- VETERINARIO ---" +
                    "\n-Nombre:" + getNombre() +
                    "\n-Direccion:" + getDireccion() +
                    "\n-Telefono:" + getTelefono() +
                    "\n-DNI:" + getDNI() +
                    "\n-Numero Seguridad Social:" + getNumeroSS() +
                    "\n-Mascotas: " + mascotas.size();
        }
    }
}
