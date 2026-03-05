package DAO;

import Modelo.Vuelo;
import Utilidades.conexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class vueloDAO {
    public static void altaVuelo(Vuelo vuelo) {
        try{
            Connection con = conexionDB.conectar();
            String sql = "INSERT INTO vuelos (cod_vuelo, fecha_salida, destino, procedencia) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, vuelo.getCodVuelo());
            ps.setDate(2, java.sql.Date.valueOf(vuelo.getFechaSalida()));
            ps.setString(3, vuelo.getDestino());
            ps.setString(4, vuelo.getProcedencia());
            ps.executeUpdate();
            conexionDB.desconectar(con);
        }catch (SQLException e){
                System.out.println("Error al crear vuelo: " + e.getMessage());
        }
    }

    public static void bajaVuelo(String codVuelo) {
        try{
            Connection con = conexionDB.conectar();
            String sql = "DELETE FROM vuelos WHERE cod_vuelo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, codVuelo);
            ps.executeUpdate();
            conexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al borrar vuelo: " + e.getMessage());
        }
    }

    public static void modificarCodigo(String codVuelo, String nuevoCodigo) {
        try{
            Connection con = conexionDB.conectar();
            String sql = "UPDATE vuelos SET cod_vuelo = ? WHERE cod_vuelo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nuevoCodigo);
            ps.setString(2, codVuelo);
            ps.executeUpdate();
            conexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al modificar codigo de vuelo: " + e.getMessage());
        }
    }

    public static void modificarFechaSalida(String codVuelo, LocalDate nuevaFecha) {
        try{
            Connection con = conexionDB.conectar();
            String sql = "UPDATE vuelos SET fecha_salida = ? WHERE cod_vuelo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, java.sql.Date.valueOf(nuevaFecha));
            ps.setString(2, codVuelo);
            ps.executeUpdate();
            conexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al modificar fecha de salida: " + e.getMessage());
        }
    }

    public static void modificarDestino(String codVuelo, String nuevoDestino) {
        try{
            Connection con = conexionDB.conectar();
            String sql = "UPDATE vuelos SET destino = ? WHERE cod_vuelo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nuevoDestino);
            ps.setString(2, codVuelo);
            ps.executeUpdate();
            conexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al modificar destino: " + e.getMessage());
        }
    }

    public static void modificarProcedencia(String codVuelo, String nuevoProcedencia) {
        try{
            Connection con = conexionDB.conectar();
            String sql = "UPDATE vuelos SET procedencia = ? WHERE cod_vuelo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nuevoProcedencia);
            ps.setString(2, codVuelo);
            ps.executeUpdate();
            conexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al modificar procedencia: " + e.getMessage());
        }
    }

    public static Vuelo buscarVuelo(String codVuelo) {
        Vuelo vuelo = null;
        try{
            Connection con = conexionDB.conectar();
            String sql = "SELECT * FROM vuelos WHERE cod_vuelo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, codVuelo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                vuelo = new Vuelo(
                        rs.getString("cod_vuelo"),
                        rs.getDate("fecha_salida").toLocalDate(),
                        rs.getString("destino"),
                        rs.getString("procedencia")
                );
            }
            conexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al buscar vuelo: " + e.getMessage());
        }
        return vuelo;
    }

    public static ArrayList<Vuelo> vueloDestino(String destino) {
        ArrayList<Vuelo> vuelos = new ArrayList<>();
        try{
            Connection con = conexionDB.conectar();
            String sql = "SELECT * FROM vuelos WHERE destino = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, destino);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vuelo vuelo = new Vuelo(
                        rs.getString("cod_vuelo"),
                        rs.getDate("fecha_salida").toLocalDate(),
                        rs.getString("destino"),
                        rs.getString("procedencia")
                );
                vuelos.add(vuelo);
            }
            conexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al buscar vuelos por destino: " + e.getMessage());
        }
        return vuelos;
    }

    public static ArrayList<Vuelo> vueloProcedencia(String procedencia) {
        ArrayList<Vuelo> vuelos = new ArrayList<>();
        try{
            Connection con = conexionDB.conectar();
            String sql = "SELECT * FROM vuelos WHERE procedencia = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, procedencia);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vuelo vuelo = new Vuelo(
                        rs.getString("cod_vuelo"),
                        rs.getDate("fecha_salida").toLocalDate(),
                        rs.getString("destino"),
                        rs.getString("procedencia")
                );
                vuelos.add(vuelo);
            }
            conexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al buscar vuelos por procedencia: " + e.getMessage());
        }
        return vuelos;
    }

    public static ArrayList<Vuelo> vueloFechaSalida(LocalDate fechaSalida) {
        ArrayList<Vuelo> vuelos = new ArrayList<>();
        try{
            Connection con = conexionDB.conectar();
            String sql = "SELECT * FROM vuelos WHERE fecha_salida = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, java.sql.Date.valueOf(fechaSalida));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vuelo vuelo = new Vuelo(
                        rs.getString("cod_vuelo"),
                        rs.getDate("fecha_salida").toLocalDate(),
                        rs.getString("destino"),
                        rs.getString("procedencia")
                );
                vuelos.add(vuelo);
            }
            conexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al buscar vuelos por fecha de salida: " + e.getMessage());
        }
        return vuelos;
    }
}
