package org.example.almacen.Controladores.Modelo;

import org.example.almacen.Modelo.Producto;
import org.example.almacen.Modelo.ProductoDAO;

public class ProductoController {

    public static Producto buscarProducto(String nombre) throws Exception
    {
        Producto producto = ProductoDAO.buscarProducto(nombre);
        return producto;
    }

    public static void buscarPorProducto(int codigo) throws Exception
    {
        AlmacenController.buscarPorProducto(codigo);
    }

    public static void actualizar(Producto producto) throws Exception {
        ProductoDAO.actualizar(producto);
    }

}
