package DAO;

import Modelo.Cuenta;
import Modelo.Titular;
import Utilidades.ConexionDB;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

import java.sql.*;
import java.util.ArrayList;

public class CuentaDAO {
    private static EntityManagerFactory emf = ConexionDB.getEntityManagerFactory();
    public static void crearCuenta(Cuenta cuenta) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cuenta);
            em.getTransaction().commit();
            em.close();
        }catch(Exception e){
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    public static void borrarCuenta(String iban) throws Exception{
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Cuenta cuenta = em.createQuery("SELECT c FROM Cuenta c WHERE c.iban = :iban", Cuenta.class)
                    .setParameter("iban", iban)
                    .getSingleResult();
            em.remove(cuenta);
            em.getTransaction().commit();
            em.close();
        }catch(Exception e){
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    public static void modificarSaldo(double nuevoSaldo, String iban) throws Exception{
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Cuenta cuenta = em.createQuery("SELECT c FROM Cuenta c WHERE c.iban = :iban", Cuenta.class)
                    .setParameter("iban", iban)
                    .getSingleResult();
            cuenta.setSaldo(nuevoSaldo);
            em.merge(cuenta);
            em.getTransaction().commit();
            em.close();
        }catch(Exception e){
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    public static ArrayList<Cuenta> mostrarCuentas() {
        EntityManager em = emf.createEntityManager();
        try {
            return new ArrayList<>(em.createQuery("SELECT c FROM Cuenta c", Cuenta.class).getResultList());
        }catch(Exception e){
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return null;
        }
    }

    public static Cuenta verCuentaPorId(String id) throws Exception{
        EntityManager em = emf.createEntityManager();
        try {
            Cuenta cuenta = em.find(Cuenta.class, id);
            em.close();
            return cuenta;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return null;
        }

    }

    public static Cuenta verCuentaPorIban(String iban) throws Exception{
        EntityManager em = emf.createEntityManager();
        try {
            Cuenta cuenta = em.createQuery("SELECT c FROM Cuenta c WHERE c.iban = :iban", Cuenta.class)
                    .setParameter("iban", iban)
                    .getSingleResult();
            em.close();
            return cuenta;
        }catch(Exception e){
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return null;
        }
    }

    public static ArrayList<Cuenta> mostrarCuentasPorSaldo(Double saldo) throws Exception{
        EntityManager em = emf.createEntityManager();
        try {
            return new ArrayList<>(em.createQuery("SELECT c FROM Cuenta c WHERE c.saldo >= :saldo", Cuenta.class)
                    .setParameter("saldo", saldo)
                    .getResultList());
        }catch(Exception e){
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return null;
        }
    }
}
