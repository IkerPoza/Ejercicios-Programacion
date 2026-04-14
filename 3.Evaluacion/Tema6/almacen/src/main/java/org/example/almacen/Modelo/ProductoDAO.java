package org.example.almacen.Modelo;

import org.example.almacen.Controladores.Modelo.AlmacenController;
import org.example.almacen.Controladores.Modelo.ProductoController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductoDAO {

    private static String plantilla;
    private static PreparedStatement ps;
    private static ResultSet rs;

    private static Producto producto;

    public static Producto buscarProducto(String nombre) throws Exception
    {
        plantilla = " select * from productos where descripcion = ?";
        Connection con = org.example.almacen.Utilidades.DBConnection.getConnection();
        ps = con.prepareStatement(plantilla);
        ps.setString(1,nombre);
        rs = ps.executeQuery();

        if(rs.next())
            return crearObjeto();

        throw new Exception("El producto no existe");
    }

    public static Producto crearObjeto() throws Exception{
        producto = new Producto();
        producto.setCodigo(rs.getInt(1));
        producto.setNombre(rs.getString(2));
        producto.setUnidades(rs.getInt(3));
        producto.setPrecio(rs.getFloat(4));

        // Buscar proveedores por producto
        ProductoController.buscarPorProducto(producto.getCodigo());

        return producto;
    }

    public static void actualizar(Producto producto) throws Exception{
        plantilla = "UPDATE productos SET unidades = ?, precio = ? WHERE codigo = ?";
        Connection con = org.example.almacen.Utilidades.DBConnection.getConnection();
        ps = con.prepareStatement(plantilla);
        ps.setInt(1, producto.getUnidades());
        ps.setFloat(2, producto.getPrecio());
        ps.setInt(3, producto.getCodigo());
        ps.executeUpdate();
    }
}
