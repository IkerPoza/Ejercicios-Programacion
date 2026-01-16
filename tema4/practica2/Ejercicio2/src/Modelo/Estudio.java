package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Estudio {
    private String nombre;
    private String ciudad;
    private String direccion;
    private String direccionWeb;
    private LocalDate fechaFundacion;
    private String pais;
    private int telefono;
    private ArrayList<Pelicula> peliculas = new ArrayList<>();

    public Estudio(String nombre, String ciudad, String direccion, String direccionWeb, LocalDate fechaFundacion, String pais, int telefono, ArrayList<Pelicula> peliculas) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.direccionWeb = direccionWeb;
        this.fechaFundacion = fechaFundacion;
        this.pais = pais;
        this.telefono = telefono;
        this.peliculas = peliculas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccionWeb() {
        return direccionWeb;
    }

    public void setDireccionWeb(String direccionWeb) {
        this.direccionWeb = direccionWeb;
    }

    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(LocalDate fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Pelicula> getPeliculas() {return peliculas;}

    public void setPeliculas(ArrayList<Pelicula> peliculas) {this.peliculas = peliculas;}
}
