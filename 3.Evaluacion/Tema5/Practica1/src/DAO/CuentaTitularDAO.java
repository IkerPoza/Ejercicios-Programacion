package DAO;

import Modelo.Cuenta;
import Modelo.Titular;
import Utilidades.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CuentaTitularDAO {
    public static void crearAsociacion(Titular titular, Cuenta cuenta) {
        try{
            Connection con = ConexionDB.conectar();
            String sql = "INSERT INTO cuentas_titulares (id_titular, id_cuenta) VALUES (?, ?)";
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, titular.getId());
            sentencia.setInt(2, cuenta.getId());
            sentencia.executeUpdate();
            ConexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al crear asociación: " + e.getMessage());
        }
    }

    public static void modificarAsociacionTitular(Titular titular, Cuenta cuenta, Titular nuevoTitular) {
        try{
            Connection con = ConexionDB.conectar();
            String sql = "UPDATE cuentas_titulares SET id_titular = ? WHERE id_titular = ? AND id_cuenta = ?";
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, nuevoTitular.getId());
            sentencia.setInt(2, titular.getId());
            sentencia.setInt(3, cuenta.getId());
            sentencia.executeUpdate();
            ConexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al modificar asociación: " + e.getMessage());
        }
    }

    public static void modificarAsociacionCuenta(Titular titular, Cuenta cuenta, Cuenta nuevaCuenta) {
        try{
            Connection con = ConexionDB.conectar();
            String sql = "UPDATE cuentas_titulares SET id_cuenta = ? WHERE id_titular = ? AND id_cuenta = ?";
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, nuevaCuenta.getId());
            sentencia.setInt(2, titular.getId());
            sentencia.setInt(3, cuenta.getId());
            sentencia.executeUpdate();
            ConexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al modificar asociación: " + e.getMessage());
        }
    }

    public static void borrarAsociacion(Titular titular, Cuenta cuenta) {
        try{
            Connection con = ConexionDB.conectar();
            String sql = "DELETE FROM cuentas_titulares WHERE id_titular = ? AND id_cuenta = ?";
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, titular.getId());
            sentencia.setInt(2, cuenta.getId());
            sentencia.executeUpdate();
            ConexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al borrar asociación: " + e.getMessage());
        }
    }

    public static Map<Titular,Cuenta> mostrarAsociaciones() {
        Map<Titular, Cuenta> asociaciones = null;
        try {
            asociaciones = new HashMap<>();
            Connection con = ConexionDB.conectar();
            String sql = "SELECT id_titular, t.nombre, t.dni, id_cuenta, c.iban, c.saldo FROM cuentas_titulares ct JOIN titulares t ON ct.id_titular = t.id JOIN cuentas c ON ct.id_cuenta = c.id";
            PreparedStatement sentencia = con.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                asociaciones.put(new Titular(resultado.getInt("id_titular"),
                                resultado.getString("nombre"),
                                resultado.getString("dni")),
                        new Cuenta(resultado.getInt("id_cuenta"),
                                resultado.getString("iban"),
                                resultado.getDouble("saldo")
                        )
                );
            }
            ConexionDB.desconectar(con);
        } catch (SQLException e) {
            System.out.println("Error al mostrar asociación: " + e.getMessage());
        }
        return asociaciones;
    }
}
