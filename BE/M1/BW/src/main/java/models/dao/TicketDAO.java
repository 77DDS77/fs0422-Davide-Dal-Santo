package models.dao;

import models.Ticket;
import models.Voyage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.JpaUtil;
import utils.LogColor;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {

    private static final Logger logger = LoggerFactory.getLogger( TicketDAO.class );

	/*
	Salva nel database
	*/
    public static void save( Ticket object ) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            em.persist( object );

            transaction.commit();
        } catch( Exception ex ) {
            em.getTransaction().rollback();

            logger.error( "Error saving object: " + object.getClass().getSimpleName(), ex );
            throw ex;

        } finally {
            em.close();
        }

    }

	/*
	Aggiorna nel database
	*/
    public void refresh( Ticket object ) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            em.refresh( object );

        } finally {
            em.close();
        }

    }

	/*
	Cerca nel database dato l'id del Ticket
	*/
    public static Ticket getById( Long id ) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            return em.find( Ticket.class, id );

        } finally {
            em.close();
        }

    }

	/*
	Cancella dal database
	*/
    public static void delete( Ticket object ) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            em.remove( em.contains( object ) ? object : em.merge( object ) );

            transaction.commit();
        } catch( Exception ex ) {
            em.getTransaction().rollback();
            logger.error( "Error deleting object: " + object.getClass().getSimpleName(), ex );
            throw ex;

        } finally {
            em.close();
        }

    }

	/*
	Restituisce la lista di tutti i ticket
	*/
    public static List<Ticket> getAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            return em.createQuery( "select p from Ticket p" ).getResultList();

        } finally {
            em.close();
        }
    }

	/*
	Restituisce la lista di tutti i ticket emessi da un reseller 
	in un certo range di tempo
	*/
    public List<Ticket> getTicketByReseller( Long id, LocalDate initialDate, LocalDate endDate ) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
        	
            Query query = em.createQuery( "select p from Ticket p where p.reseller.id = :id" );
            query.setParameter( "id", id );
            
            List<Ticket> ticketsFinded = query.getResultList();
            List<Ticket> ticketsRange = new ArrayList<>();
            
            for( Ticket t : ticketsFinded ) {
                if( t.getReleaseDate().compareTo( initialDate ) > 0 && t.getReleaseDate().compareTo( endDate ) < 0 ) {
                    ticketsRange.add( t );
                }
            }
            return ticketsRange;
        } finally {
            em.close();            
        }
    }

	/*
	Restituisce la lista di tutti i ticket vidimati/obliterati 
	da un veicolo dato il suo ID
	*/
	public static List<Ticket> punchedTicketsByVehicle(Long vehicleID) {

        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            CriteriaBuilder cb = em.getCriteriaBuilder();

			CriteriaQuery<Ticket> cq = cb.createQuery(Ticket.class);

			Root<Ticket> p = cq.from(Ticket.class);

			Predicate pd1 = cb.equal(p.get("vehicle"), vehicleID);

			cq.select(p).where(pd1);

			Query q = em.createQuery(cq);

			List<Ticket> itemList = q.getResultList();

			if(itemList.size() == 0) {				
				LogColor.infoMessage("Nessun biglietto è stato obliterato su questo mezzo in questo periodo di tempo.");					
			}
			
			return itemList;

        } 
        finally {
            em.close();
        }
	}
	
	/*
	Restituisce la lista di tutti i ticket venduti 
	dato un range di tempo
	*/
	public static List<Ticket> punchedTicketsByRangeOfTime(LocalDate initialDate, LocalDate endDate) {

        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            CriteriaBuilder cb = em.getCriteriaBuilder();

			CriteriaQuery<Ticket> cq = cb.createQuery(Ticket.class);

			Root<Ticket> p = cq.from(Ticket.class);

			Predicate pd1 = cb.between(p.get("punch"), initialDate, endDate);

			cq.select(p).where(pd1);

			Query q = em.createQuery(cq);

			List<Ticket> itemList = q.getResultList();

			if(itemList.size() == 0) {				
				LogColor.infoMessage("Nessun biglietto è stato obliterato in questo periodo di tempo.");					
			}
			
			return itemList;

        } 
        finally {
            em.close();
        }
	}

}
