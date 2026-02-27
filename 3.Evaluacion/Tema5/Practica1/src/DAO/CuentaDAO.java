package DAO;

import Modelo.Cuenta;
import Modelo.Titular;
import Utilidades.ConexionDB;

import java.sql.*;
import java.util.ArrayList;

public class CuentaDAO {
    public static void crearCuenta(Cuenta cuenta) {
        try{
            Connection con = ConexionDB.conectar();
            String sql = "INSERT INTO cuentas (iban, saldo) VALUES (?, ?)";
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setString(1, cuenta.getIban());
            sentencia.setDouble(2, cuenta.getSaldo());
            sentencia.executeUpdate();
            ConexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al crear cuenta: " + e.getMessage());
        }
    }

    public static void borrarCuenta(String iban) throws Exception{
        try{
            Connection con = ConexionDB.conectar();
            PreparedStatement sentencia = con.prepareStatement("DELETE FROM cuentas WHERE iban = ?");
            sentencia.setString(1, iban);
            int exito = sentencia.executeUpdate();
            ConexionDB.desconectar(con);
            if (exito == 0) {
                throw new Exception();
            }
        }catch (SQLException e){
            System.out.println("Error al borrar cuenta: " + e.getMessage());
        }
    }

    public static void modificarSaldo(double nuevoSaldo, String iban) throws Exception{
        try{
            Connection con = ConexionDB.conectar();
            PreparedStatement sentencia = con.prepareStatement("UPDATE cuentas SET saldo = ? WHERE iban = ?");
            sentencia.setDouble(1, nuevoSaldo);
            sentencia.setString(2, iban);
            int exito = sentencia.executeUpdate();
            if (exito == 0) {
                throw new Exception();
            }
            ConexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al modificar cuenta: " + e.getMessage());
        }
    }

    public static ArrayList<Cuenta> mostrarCuentas() {
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        try{
            Connection con = ConexionDB.conectar();
            Statement sentencia = con.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM cuentas");
            while (resultado.next()){
                cuentas.add(new Cuenta(resultado.getInt("id"),
                        resultado.getString("iban"),
                        resultado.getDouble("saldo")));
            }
            ConexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al mostrar titulares: " + e.getMessage());
        }
        return cuentas;
    }

    public static Cuenta verCuentaPorId(String id) throws Exception{
        Cuenta cuenta = null;
        try{
            Connection con = ConexionDB.conectar();
            PreparedStatement sentencia = con.prepareStatement("SELECT * FROM cuentas WHERE id = ?");
            sentencia.setString(1, id);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()){
                cuenta = new Cuenta(resultado.getInt("id"),
                        resultado.getString("iban"),
                        resultado.getDouble("saldo"));
            } else {
                throw new Exception();
            }
            ConexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al mostrar cuenta por ID: " + e.getMessage());
        }
        return cuenta;
    }

    public static Cuenta verCuentaPorIban(String iban) throws Exception{
        Cuenta cuenta = null;
        try{
            Connection con = ConexionDB.conectar();
            PreparedStatement sentencia = con.prepareStatement("SELECT * FROM cuentas WHERE iban = ?");
            sentencia.setString(1, iban);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()){
                cuenta = new Cuenta(resultado.getInt("id"),
                        resultado.getString("iban"),
                        resultado.getDouble("saldo"));
            } else {
                throw new Exception();
            }
            ConexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al mostrar cuenta por IBAN: " + e.getMessage());
        }
        return cuenta;
    }

    public static ArrayList<Cuenta> mostrarCuentasPorSaldo(Double saldo) throws Exception{
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        try{
            Connection con = ConexionDB.conectar();
            PreparedStatement sentencia = con.prepareStatement("SELECT * FROM cuentas WHERE saldo > ?");
            sentencia.setDouble(1, saldo);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()){
                cuentas.add(new Cuenta(resultado.getInt("id"),
                        resultado.getString("iban"),
                        resultado.getDouble("saldo")));
            }
            ConexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al mostrar cuentas con saldo mayor a " + saldo + ": " + e.getMessage());
        }
        if (cuentas.isEmpty()) {
            throw new Exception();
        }
        return cuentas;
    }
}
