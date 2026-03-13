package Utilidades;

import jakarta.persistence.EntityManagerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static EntityManagerFactory emf;

    public static void crearEMF() {
        emf = jakarta.persistence.Persistence.createEntityManagerFactory("appTitulares");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}
