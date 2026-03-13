package DAO;

import Modelo.Cuenta;
import Modelo.Titular;
import Utilidades.ConexionDB;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CuentaTitularDAO {
    private static EntityManagerFactory emf = ConexionDB.getEntityManagerFactory();
    public static void crearAsociacion(Titular titular, Cuenta cuenta) {
        EntityManager em = emf.createEntityManager();
        try {
            cuenta.setTitulares(titular);
            em.getTransaction().begin();
            em.remove(cuenta);
            em.persist(cuenta);
            em.getTransaction().commit();
            em.close();
        }catch (Exception e){
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    public static void modificarAsociacionTitular(Titular titular, Cuenta cuenta, Titular nuevoTitular) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(titular);
            em.persist(cuenta);
            em.persist(nuevoTitular);
            em.getTransaction().commit();
            em.close();
        }catch(Exception e){
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    public static void modificarAsociacionCuenta(Titular titular, Cuenta cuenta, Cuenta nuevaCuenta) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(cuenta);
            em.persist(nuevaCuenta);
            em.getTransaction().commit();
            em.close();
        }catch(Exception e){
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    public static void borrarAsociacion(Titular titular, Cuenta cuenta) {
    }

    public static Map<Titular,Cuenta> mostrarAsociaciones() {
        System.out.println("Mostrando asociaciones...");
        return null;
    }

    public static ArrayList<Cuenta> mostrarCuentasPorTitular(Titular titular) {
        return null;
    }

    public static ArrayList<Titular> mostrarTitularesPorCuenta(Cuenta cuenta) {
        return null;
    }
}
