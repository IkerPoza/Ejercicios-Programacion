package org.example.almacen.Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {
    private static String plantilla;
    private static PreparedStatement ps;
    private static ResultSet rs;
    private static Connection con;

    public static Proveedor crearObjetoProveedor(int codigoProveedor) throws Exception{
        plantilla = " select * from proveedores where codigo = ?";
        Connection con = org.example.almacen.Utilidades.DBConnection.getConnection();
        ps = con.prepareStatement(plantilla);
        ps.setInt(1,codigoProveedor);
        ResultSet rsProv = ps.executeQuery();
        // Damos por hecho que existe
        rsProv.next();
        return new Proveedor(rsProv.getInt(1),rsProv.getString(2));
    }
}
