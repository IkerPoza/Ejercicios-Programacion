package DAO;

import Modelo.Titular;
import Utilidades.ConexionDB;

import java.sql.*;
import java.util.ArrayList;

public class TitularDAO {
    public static void crearTitular(Titular titular) {
        try{
            Connection con = ConexionDB.conectar();
            String sql = "INSERT INTO titulares (nombre, dni) VALUES (?, ?)";
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setString(1, titular.getNombre());
            sentencia.setString(2, titular.getDni());
            sentencia.executeUpdate();
            ConexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al crear titular: " + e.getMessage());
        }
    }

    public static void borrarTitular(String dni) throws Exception{
        try{
            Connection con = ConexionDB.conectar();
            PreparedStatement sentencia = con.prepareStatement("DELETE FROM titulares WHERE dni = ?");
            sentencia.setString(1, dni);
            int exito = sentencia.executeUpdate();
            ConexionDB.desconectar(con);
            if (exito == 0) {
                throw new Exception();
            }
        }catch (SQLException e){
            System.out.println("Error al borrar titular: " + e.getMessage());
        }
    }

    public static void modificarNombre(String nuevoNombre, String dni) throws Exception{
        try{
            Connection con = ConexionDB.conectar();
            PreparedStatement sentencia = con.prepareStatement("UPDATE titulares SET nombre = ? WHERE dni = ?");
            sentencia.setString(1, nuevoNombre);
            sentencia.setString(2, dni);
            int exito = sentencia.executeUpdate();
            if (exito == 0) {
                throw new Exception();
            }
            ConexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al modificar titular: " + e.getMessage());
        }
    }

    public static void modificarDni(String dni, String dni1) throws Exception{
        try{
            Connection con = ConexionDB.conectar();
            PreparedStatement sentencia = con.prepareStatement("UPDATE titulares SET dni = ? WHERE dni = ?");
            sentencia.setString(1, dni);
            sentencia.setString(2, dni1);
            int exito = sentencia.executeUpdate();
            if (exito == 0) {
                throw new Exception();
            }
            ConexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al modificar titular: " + e.getMessage());
        }
    }

    public static void mostrarTitulares(ArrayList<Titular> titulares){
        try{
            Connection con = ConexionDB.conectar();
            Statement sentencia = con.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM titulares");
            while (resultado.next()){
                titulares.add(new Titular(resultado.getInt("id"),
                        resultado.getString("nombre"),
                        resultado.getString("dni")));
            }
            ConexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al mostrar titulares: " + e.getMessage());
        }

    }

    public static Titular verTitularPorId(int id){
        Titular titular = null;
        try{
            Connection con = ConexionDB.conectar();
            PreparedStatement sentencia = con.prepareStatement("SELECT * FROM titulares WHERE id = ?");
            sentencia.setInt(1, id);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()){
                titular = new Titular(resultado.getInt("id"),
                        resultado.getString("nombre"),
                        resultado.getString("dni"));
            }
            ConexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al mostrar titular por ID: " + e.getMessage());
        }
        return titular;
    }

    public static void verTitularPorNombre(String nombre, ArrayList<Titular> titulares){
        try{
            Connection con = ConexionDB.conectar();
            PreparedStatement sentencia = con.prepareStatement("SELECT * FROM titulares WHERE nombre = ?");
            sentencia.setString(1, nombre);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()){
                titulares.add(new Titular(resultado.getInt("id"),
                        resultado.getString("nombre"),
                        resultado.getString("dni")));
            }
        }catch (SQLException e){
            System.out.println("Error al mostrar titular por nombre: " + e.getMessage());
        }
    }

    public static Titular verTitularPorDni(String dni){
        try {
            Connection con = ConexionDB.conectar();
            PreparedStatement sentencia = con.prepareStatement("SELECT * FROM titulares WHERE dni = ?");
            sentencia.setString(1, dni);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                return new Titular(resultado.getInt("id"),
                        resultado.getString("nombre"),
                        resultado.getString("dni"));
            }
            ConexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al mostrar titular por DNI: " + e.getMessage());
        }
        return null;
    }
}
