package models.dao;

import models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utils.JpaUtil;
import utils.LogColor;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class UserDAO {
	private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);

	/*
	Salva nel database
	*/
	public static void save(User object) {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();
		try {

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			em.persist(object);

			transaction.commit();
			
			LogColor.infoMessage(object.toString());

		} catch (Exception ex) {
			em.getTransaction()
					.rollback();
			logger.error("Error saving object: " + object.getClass()
					.getSimpleName(), ex);
			throw ex;

		} finally {
			em.close();
		}

	}

	/*
	Aggiorna nel database
	*/
	public static void refresh(User object) {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();
		try {

			em.refresh(object);

		} finally {
			em.close();
		}

	}

	/*
	Cerca uno user nel databsae dato il suo ID
	*/
	public static User getById(Long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();
		try {

			return em.find(User.class, id);

		} finally {
			em.close();
		}

	}

	/*
	Cancella lo User dal database data l'istanza dell'oggetto
	*/
	public static void delete(User object) {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();
		try {

			EntityTransaction transaction = em.getTransaction();
			
			transaction.begin();
			
			em.remove(em.find(User.class, object.getId()));

			transaction.commit();
			
		} catch (Exception ex) {
			em.getTransaction()
					.rollback();
			logger.error("Error deleting object: " + object.getClass()
					.getSimpleName(), ex);
			throw ex;

		} finally {
			em.close();
		}

	}

	/*
	Aggiorna il name dell'utente'
	*/
	public static void refreshName(User object, String name) {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();
		try {

			User utente = em.find(object.getClass(), object.getId());

			em.getTransaction()
					.begin();
			utente.setName(name);
			em.getTransaction()
					.commit();

		} finally {
			em.close();
		}

	}

	/*
	Aggiorna il lastname dell'utente'
	*/
	public static void refreshLastName(User object, String lastName) {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();
		try {

			User utente = em.find(object.getClass(), object.getId());

			em.getTransaction()
					.begin();
			utente.setLastName(lastName);
			em.getTransaction()
					.commit();

		} finally {
			em.close();
		}

	}

	/*
	Restituisce la lista di tutti gli utenti
	*/
	public static List<User> getAll() {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();
		try {

			return em.createQuery("select p from User p")
					.getResultList();

		} finally {
			em.close();
		}
	}
	
	/*
	Restituisce la lista di utenti dati nome e cognome
	*/
	public static List<User> getUserByFullName(String name, String lastName) {

		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();
		try {

			Query query = em.createQuery("select u from User u where upper(u.name) like upper(concat('%', :nome, "
					+ "'%')) and upper(u" + ".lastName) like upper(concat('%', :cognome, '%') )");

			query.setParameter("nome", name);
			query.setParameter("cognome", lastName);
			return query.getResultList();

		} finally {
			em.close();
		}
	}
}
