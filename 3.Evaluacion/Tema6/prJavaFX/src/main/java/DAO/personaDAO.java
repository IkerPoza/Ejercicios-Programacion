package DAO;

import Modelo.Persona;
import Utilidades.ConexionDB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class personaDAO {
    public static void insertar (Persona persona) {
        try{
            Connection con = ConexionDB.conectar();
            String sql = "INSERT INTO personas (dni, nombre, apellido, fecha_nac, telefono) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, persona.getDni());
            ps.setString(2, persona.getNombre());
            ps.setString(3, persona.getApellido());
            ps.setDate(4, Date.valueOf(persona.getFechaNacimiento()));
            ps.setInt(5, persona.getTelefono());
            ps.executeUpdate();
            ConexionDB.desconectar(con);
        }catch (SQLException e){
            System.out.println("Error al crear titular: " + e.getMessage());
        }
    }
}
