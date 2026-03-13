package DAO;

import Modelo.Titular;
import Utilidades.ConexionDB;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.sql.*;
import java.util.ArrayList;

public class TitularDAO {
    private static EntityManagerFactory emf = ConexionDB.getEntityManagerFactory();
    public static void crearTitular(Titular titular) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(titular);
            em.getTransaction().commit();
            em.close();
        }catch(Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    public static void borrarTitular(String dni) throws Exception{
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Titular titular = em.createQuery("SELECT t FROM Titular t WHERE t.dni = :dni", Titular.class)
                    .setParameter("dni", dni)
                    .getSingleResult();
            em.remove(titular);
            em.getTransaction().commit();
            em.close();
        }catch(Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    public static void modificarNombre(String nuevoNombre, String dni) throws Exception{
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Titular titular = em.createQuery("SELECT t FROM Titular t WHERE t.dni = :dni", Titular.class)
                    .setParameter("dni", dni)
                    .getSingleResult();
            titular.setNombre(nuevoNombre);
            em.merge(titular);
            em.getTransaction().commit();
            em.close();
        }catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    public static void modificarDni(String dni, String dni1) throws Exception{
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Titular titular = em.createQuery("SELECT t FROM Titular t WHERE t.dni = :dni", Titular.class)
                    .setParameter("dni", dni)
                    .getSingleResult();
            titular.setDni(dni1);
            em.merge(titular);
            em.getTransaction().commit();
            em.close();
        }catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    public static void mostrarTitulares(ArrayList<Titular> titulares){
        EntityManager em = emf.createEntityManager();
        try {
            titulares.addAll(em.createQuery("SELECT t FROM Titular t", Titular.class).getResultList());
        }catch(Exception e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    public static Titular verTitularPorId(int id){
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Titular.class, id);
        }catch(Exception e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return null;
        }
    }

    public static void verTitularPorNombre(String nombre, ArrayList<Titular> titulares){
        EntityManager em = emf.createEntityManager();
        try {
            titulares.addAll((em.createQuery("SELECT t FROM Titular t WHERE t.nombre = :nombre", Titular.class))
                    .setParameter("nombre", nombre)
                    .getResultList());
        }catch (Exception e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    public static Titular verTitularPorDni(String dni){
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT t FROM Titular t WHERE t.dni = :dni", Titular.class)
                    .setParameter("dni", dni)
                    .getSingleResult();
        }catch (Exception e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return null;
        }
    }
}
