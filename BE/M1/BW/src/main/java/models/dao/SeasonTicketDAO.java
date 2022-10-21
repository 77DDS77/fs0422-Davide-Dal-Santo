package models.dao;


import models.SeasonTicket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SeasonTicketDAO {

    private static final Logger logger = LoggerFactory.getLogger(SeasonTicketDAO.class);

	/*
	Salva nel database
	*/
    public static void save(SeasonTicket object) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            em.persist(object);

            transaction.commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();

            logger.error("Error saving object: " + object.getClass().getSimpleName(), ex);
            throw ex;

        } finally {
            em.close();
        }

    }

	/*
	Aggiorna nel database
	*/
    public void refresh(SeasonTicket object) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            em.refresh(object);

        } finally {
            em.close();
        }

    }
	
	/*
	Cerca nel databse dato l'id
	*/
    public static SeasonTicket getById(Long id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            return em.find(SeasonTicket.class, id);

        } finally {
            em.close();
        }

    }

	/*
	Cancella dal database dato un oggetto SeasonTicket
	*/
    public static void delete(SeasonTicket object) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            em.remove(em.contains(object) ? object : em.merge(object));

            transaction.commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            logger.error("Error deleting object: " + object.getClass().getSimpleName(), ex);
            throw ex;

        } finally {
            em.close();
        }

    }

	/*
	Restituisce la lista di tutti gli abbonamenti (season ticket)
	*/
    public static List<SeasonTicket> getAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            return em.createQuery("select p from SeasonTicket p").getResultList();

        } finally {
            em.close();
        }
    }

	/*
	Restituisce la lista di tutti gli abbonamenti (season ticket)
	emessi in un certo range di tempo
	*/
    public List<SeasonTicket> getSeasonTicketByReseller(Long id, LocalDate initialDate, LocalDate endDate) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

        try {

            Query query = em.createQuery("select p from SeasonTicket p where p.reseller.id = :id");
            query.setParameter("id", id);

            List<SeasonTicket> ticketsFinded = query.getResultList();
            List<SeasonTicket> ticketsRange = new ArrayList<>();

            for (SeasonTicket t : ticketsFinded) {
                if (t.getReleaseDate().compareTo(initialDate) > 0 && t.getReleaseDate().compareTo(endDate) < 0) {
                    ticketsRange.add(t);
                }
            }

            return ticketsRange;

        } finally {
            em.close();
        }
    }
}
