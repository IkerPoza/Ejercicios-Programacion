package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {
    private LocalDate fecha;
    private ArrayList<Producto> productos;

    public Pedido(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
}
