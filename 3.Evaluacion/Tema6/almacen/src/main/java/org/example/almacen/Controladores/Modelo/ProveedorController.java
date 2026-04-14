package org.example.almacen.Controladores.Modelo;

import org.example.almacen.Modelo.Proveedor;
import org.example.almacen.Modelo.ProveedorDAO;

public class ProveedorController
{
    public static Proveedor crearObjetoProveedor(int codigo) throws Exception
    {
        return ProveedorDAO.crearObjetoProveedor(codigo);
    }
}
