package DAO;

import Modelo.Pasajero;
import Utilidades.conexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class pasajeroDAO {
    public static void altaPasajero(Pasajero pasajero) {
        try{
            Connection con = conexionDB.conectar();
            String sql = "INSERT INTO pasajeros (dni, nombre, telefono, cod_vuelo) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pasajero.getDni());
            ps.setString(2, pasajero.getNombre());
            ps.setString(3, pasajero.getTelefono());
            ps.setString(4, pasajero.getVuelo());
            ps.executeUpdate();
            conexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al crear pasajero: " + e.getMessage());
        }
    }

    public static void bajaPasajero(String dni) {
        try{
            Connection con = conexionDB.conectar();
            String sql = "DELETE FROM pasajeros WHERE dni = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ps.executeUpdate();
            conexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al borrar pasajero: " + e.getMessage());
        }
    }

    public static void modificarDni(String dni, String nuevoDni) {
        try{
            Connection con = conexionDB.conectar();
            String sql = "UPDATE pasajeros SET dni = ? WHERE dni = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nuevoDni);
            ps.setString(2, dni);
            ps.executeUpdate();
            conexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al modificar DNI del pasajero: " + e.getMessage());
        }
    }

    public static void modificarNombre(String dni, String nuevoNombre) {
        try{
            Connection con = conexionDB.conectar();
            String sql = "UPDATE pasajeros SET nombre = ? WHERE dni = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nuevoNombre);
            ps.setString(2, dni);
            ps.executeUpdate();
            conexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al modificar nombre del pasajero: " + e.getMessage());
        }
    }

    public static void modificarTelefono(String dni, String nuevoTelefono) {
        try{
            Connection con = conexionDB.conectar();
            String sql = "UPDATE pasajeros SET telefono = ? WHERE dni = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nuevoTelefono);
            ps.setString(2, dni);
            ps.executeUpdate();
            conexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al modificar telefono del pasajero: " + e.getMessage());
        }
    }

    public static void modificarVuelo(String dni, String nuevoVuelo) {
        try{
            Connection con = conexionDB.conectar();
            String sql = "UPDATE pasajeros SET cod_vuelo = ? WHERE dni = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nuevoVuelo);
            ps.setString(2, dni);
            ps.executeUpdate();
            conexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al modificar vuelo del pasajero: " + e.getMessage());
        }
    }

    public static Pasajero buscarPasajero(String dni) {
        Pasajero pasajero = null;
        try{
            Connection con = conexionDB.conectar();
            String sql = "SELECT * FROM pasajeros WHERE dni = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pasajero = new Pasajero(
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("cod_vuelo")
                );
            }
            conexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al buscar pasajero: " + e.getMessage());
        }
        return pasajero;
    }

    public static ArrayList<Pasajero> buscarPasajeros() {
        ArrayList<Pasajero> pasajeros = new ArrayList<>();
        try{
            Connection con = conexionDB.conectar();
            String sql = "SELECT * FROM pasajeros";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pasajero pasajero = new Pasajero(
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("cod_vuelo")
                );
                pasajeros.add(pasajero);
            }
            conexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al buscar pasajeros: " + e.getMessage());
        }
        return pasajeros;
    }
}
