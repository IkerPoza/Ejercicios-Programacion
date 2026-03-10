package DAO;

import Modelo.Titular;
import Utilidades.DBConnection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.ArrayList;

public class TitularDAO {
    private static final EntityManagerFactory emf = DBConnection.getEntityManagerFactory();
    public static void insertar(Titular titular) {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(titular);
            em.getTransaction().commit();
            em.close();
        }catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    public static void modificarTitular(Titular titular) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(titular);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }
    public static void borrarTitular(String dni) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Titular t = em.find(Titular.class, dni);
            if (t != null) {
                em.remove(t);
            }
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }
    public static ArrayList<Titular> listarTitulares() {
        EntityManager em = emf.createEntityManager();
        try {
            ArrayList<Titular> titulares = new ArrayList<>(em.createQuery("SELECT t FROM Titular t", Titular.class).getResultList());
            em.close();
            return titulares;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return new ArrayList<>();
        }
    }
    public static ArrayList<Titular> listarTitularesPorNombre(String nombre) {
        EntityManager em = emf.createEntityManager();
        try {
            ArrayList<Titular> titulares = new ArrayList<>(em.createQuery("SELECT t FROM Titular t WHERE t.nombre LIKE :nombre", Titular.class)
                    .setParameter("nombre", "%" + nombre + "%")
                    .getResultList());
            em.close();
            return titulares;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return new ArrayList<>();
        }
    }
    public static Titular buscarTitularPorId(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Titular titular = em.find(Titular.class, id);
            em.close();
            return titular;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return null;
        }
    }
    public static Titular buscarTitularPorDni(String dni) {
        EntityManager em = emf.createEntityManager();
        try {
            Titular titular = em.createQuery("SELECT t FROM Titular t WHERE t.dni = :dni", Titular.class)
                    .setParameter("dni", dni)
                    .getSingleResult();
            em.close();
            return titular;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return null;
        }
    }
}

