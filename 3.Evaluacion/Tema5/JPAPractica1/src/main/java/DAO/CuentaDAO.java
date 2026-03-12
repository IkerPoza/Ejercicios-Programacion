package DAO;

import Modelo.Cuenta;
import Utilidades.DBConnection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.ArrayList;

public class CuentaDAO {
    private static EntityManagerFactory emf = DBConnection.getEntityManagerFactory();

    public static void insertar(Cuenta cuenta) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cuenta);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    public static void borrarCuenta(String iban) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Cuenta c = em.createQuery("SELECT c FROM Cuenta c WHERE c.iban = :iban", Cuenta.class)
                    .setParameter("iban", iban)
                    .getSingleResult();
            if (c != null) {
                em.remove(c);
            }
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    public static void modificarCuenta(Cuenta cuenta) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(cuenta);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    public static ArrayList<Cuenta> mostrarCuentas() {
        EntityManager em = emf.createEntityManager();
        try {
            ArrayList<Cuenta> cuentas = new ArrayList<>(em.createQuery("SELECT c FROM Cuenta c", Cuenta.class).getResultList());
            em.close();
            return cuentas;
        }catch(Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            return new ArrayList<>();
        }
    }

    public static Cuenta buscarCuentaPorId(int id) {
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

    public static Cuenta buscarCuentaPorIban(String iban) {
        EntityManager em = emf.createEntityManager();
        try {
            Cuenta cuenta = em.createQuery("SELECT c FROM Cuenta c WHERE c.iban = :iban", Cuenta.class)
                    .setParameter("iban", iban)
                    .getSingleResult();
            em.close();
            return cuenta;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return null;
        }
    }

    public static ArrayList<Cuenta> listarCuentasPorSaldo(int saldoMinimo) {
        EntityManager em = emf.createEntityManager();
        try {
            ArrayList<Cuenta> cuentas = new ArrayList<>(em.createQuery("SELECT c FROM Cuenta c WHERE c.saldo >= :saldoMinimo", Cuenta.class)
                    .setParameter("saldoMinimo", saldoMinimo)
                    .getResultList());
            em.close();
            return cuentas;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return new ArrayList<>();
        }
    }
}
