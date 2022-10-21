package models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import models.Route;
import utils.JpaUtil;
import utils.LogColor;

public class RouteDAO {
	private static final Logger log = LoggerFactory.getLogger(RouteDAO.class);

	/*
	Salva nel database
	*/
	public static void save(Route route) {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {
			EntityTransaction et = em.getTransaction();
			et.begin();

			em.persist(route);

			et.commit();

		} catch (Exception e) {
			em.getTransaction()
			.rollback();
			e.printStackTrace();
			log.error(LogColor.RED(e + " route"));
		}
		finally {
			em.close();
		}
	}
	
	/*
	Cancella dal database dato un oggetto Route
	*/
	public static void delete(Route object) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            em.remove(em.contains(object) ? object : em.merge(object));

            transaction.commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            log.error("Error deleting object: " + object.getClass().getSimpleName(), ex);
            throw ex;

        } finally {
            em.close();
        }

    }
	
	/*
	Cerca nel database dato l'id di una Route
	*/
	public static Route getById(Long id) {

		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {
			Route route = em.find(Route.class, id);

			return route;

		} catch (Exception e) {
			em.getTransaction()
			.rollback();
			log.error(LogColor.RED("Find route error: ") + e.getLocalizedMessage());

		} finally {
			em.close();
		}
		return null;
	}
	
	/*
	Restituisce la lista di tutte le Route
	*/
	public static List<Route> getAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            return em.createQuery("select r from Route r").getResultList();

        } finally {
            em.close();
        }
    }
    
    /*
	Restituisce la lista di Route date:
		- inizio tratta
		- fine tratta
	*/
    public static List<Route> getRouteBySF(String inizio, String fine) {

        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            Query query = em.createQuery( "select u from Route u where upper(u.start) like UPPER(concat('%', :inizio, '%')) and upper(u" +
                                                         ".finish) LIKE UPPER(concat('%', :fine, '%'))");

            query.setParameter( "inizio", inizio );
            query.setParameter( "fine", fine );
            return query.getResultList();

        } finally {
            em.close();
        }
    }
    
    /*
	Aggiorna l'inizio della tratta
	*/
    public static void refreshStart(Route object, String start) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            Route route = em.find(object.getClass(), object.getId());

            em.getTransaction().begin();
            route.setStart( start );
            em.getTransaction().commit();

        } finally {
            em.close();
        }

    }
    
    /*
	Aggiorna la fine della tratta
	*/
    public static void refreshFinish(Route object, String finish) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            Route route = em.find(object.getClass(), object.getId());

            em.getTransaction().begin();
            route.setFinish( finish );
            em.getTransaction().commit();

        } finally {
            em.close();
        }

    }
    
    /*
	Aggiorna il travel time della tratta
	*/
    public static void refreshTT(Route object, int tt) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            Route route = em.find(object.getClass(), object.getId());

            em.getTransaction().begin();
            route.setTravelTime( tt );
            em.getTransaction().commit();

        } finally {
            em.close();
        }

    }

}
