package org.example.almacen.Controladores.Modelo;

import org.example.almacen.Modelo.*;

import java.util.List;

public class ProductoProveedorController {

    public static List<Proveedor> buscarPorProducto(int id) throws Exception
    {
        return ProductoProveedorDAO.buscarPorProducto(id);
    }


    public static Proveedor crearObjetoProveedor(int codigoProveedor) throws Exception
    {
        return AlmacenController.crearObjetoProveedor(codigoProveedor);
    }
}
