package org.example.almacen.Modelo;

import java.util.List;

public class Producto
{
    private int  codigo;
    private String nombre;
    private int unidades;
    private float precio;

    // Relación
    private List<Proveedor> listaProveedores;

    public Producto() {
    }

    public Producto(int codigo, String nombre, int unidades, float precio, List<Proveedor> listaProveedores) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.unidades = unidades;
        this.precio = precio;
        this.listaProveedores = listaProveedores;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public List<Proveedor> getListaProveedores() {
        return listaProveedores;
    }

    public void setListaProveedores(List<Proveedor> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }
}
