package org.example.almacen.Modelo;

import org.example.almacen.Controladores.Modelo.ProductoProveedorController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoProveedorDAO {
    private static String plantilla;
    private static PreparedStatement ps;
    private static ResultSet rs;
    private static Connection con;

    public static List<Proveedor> buscarPorProducto(int codigoProducto) throws Exception
    {
        plantilla = " select * from productos_proveedores where codigo_producto = ?";
        con = org.example.almacen.Utilidades.DBConnection.getConnection();
        ps = con.prepareStatement(plantilla);
        ps.setInt(1,codigoProducto);
        rs = ps.executeQuery();
        List<Proveedor> lista = new ArrayList<>();
        while(rs.next())
        {
            lista.add(ProductoProveedorController.crearObjetoProveedor(rs.getInt("codigo_proveedor")));
        }
        return lista;
    }

}
