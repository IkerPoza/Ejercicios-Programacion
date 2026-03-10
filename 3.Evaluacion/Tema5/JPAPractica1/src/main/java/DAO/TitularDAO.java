package DAO;

import Modelo.Titular;
import Utilidades.DBConnection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class TitularDAO {
    public static void insertar(Titular titular) {
        EntityManagerFactory emf = DBConnection.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(titular);
            em.getTransaction().commit();
        }catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }
}

