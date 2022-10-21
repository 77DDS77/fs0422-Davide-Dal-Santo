package models.dao;

import models.User;
import models.UserCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.JpaUtil;
import utils.LogColor;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class UserCardDAO {
    private static final Logger logger = LoggerFactory.getLogger(UserCardDAO.class);

	/*
	Salva nel Database
	*/
    public void save( UserCard object) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            
            object.setUser(em.find(User.class, object.getUser().getId()));

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
	Aggiorna nel databse
	*/
    public void refresh(UserCard object) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            em.refresh(object);

        } finally {
            em.close();
        }

    }

	/*
	Aggiorna la data di scadenza della UserCard 
	*/
    public static void refreshExpireDate( UserCard object, LocalDate date ) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            UserCard card = em.find(object.getClass(), object.getId());

            em.getTransaction().begin();
            card.setExpireDate( date );
            LogColor.infoMessage( "Rinnovata tessera: " + card );
            em.getTransaction().commit();

        } finally {
            em.close();
        }

    }

	/*
	Cerca nel database la UserCard dato il suo id/numero carta
	*/
    public UserCard getById(Long id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            return em.find(UserCard.class, id);

        } finally {
            em.close();
        }

    }

	/*
	Cancella dal database
	*/
    public void delete(UserCard object) {
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
	Restituisce la lista di tutte le User Card
	*/
    public List<UserCard> getAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            return em.createQuery("select p from UserCard p").getResultList();

        } finally {
            em.close();
        }
    }

	/*
	Restituisce la lista di tutte le User Card appartentni ad uno User
	dato il suo ID
	*/
    public List<UserCard> getCardByUserId(Long id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            Query query = em.createQuery("select p from UserCard p where p.user.id = :id");

            query.setParameter("id", id);

            return query.getResultList();

        } finally {
            em.close();
        }
    }
}
