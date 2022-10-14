package utils;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import models.User;

public class UserDAO {

	public static void save(String name, String lastName, LocalDate dob) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoBiblioteca");
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		User user = new User(name, lastName, dob);

		t.begin();

		em.persist(user);
		user.setCard(user.getId());
		
		t.commit();

		em.close();
		emf.close();

	}

	public static void save(User user) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoBiblioteca");
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		t.begin();

		em.persist(user);
		user.setCard(user.getId());

		t.commit();

		em.close();
		emf.close();

	}

	public static User getById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoBiblioteca");
		EntityManager em = emf.createEntityManager();

		User found = em.find(User.class, id);

		em.close();
		emf.close();

		if (found != null) {
			return found;
		}
		System.out.println("User not found");
		return null;
	}

	public static void delete(User u) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoBiblioteca");
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		t.begin();

		em.remove(u);

		t.commit();

		em.close();
		emf.close();

	}
}
