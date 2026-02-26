package Modelo;

import java.util.ArrayList;

public class Cliente extends Persona {
    private ArrayList<Mascota> mascotas;

    public Cliente(String nombre, String direccion, String telefono) {
        super(nombre, direccion, telefono);
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
        return "--- CLIENTE ---" +
                "\n-Nombre:"+getNombre()+
                "\n-Direccion:"+getDireccion()+
                "\n-Telefono:"+getTelefono()+
                "\n-Mascotas: "+ mascotas.size();
        }
    }
}
