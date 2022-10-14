package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import models.Every;
import models.Magazine;

public class MagazineDAO {

	public static void save(String title, String pubYear, int numPag, Every every) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoBiblioteca");
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		Magazine mag = new Magazine(title, pubYear, numPag, every);

		t.begin();

		em.persist(mag);

		t.commit();

		em.close();
		emf.close();

	}

	public static void save(Magazine mag) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoBiblioteca");
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		t.begin();

		em.persist(mag);

		t.commit();

		em.close();
		emf.close();

	}

	public static Magazine getByISBN(int isbn) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoBiblioteca");
		EntityManager em = emf.createEntityManager();

		Magazine found = em.find(Magazine.class, isbn);

		em.close();
		emf.close();

		if (found != null) {
			return found;
		}
		System.out.println("Magazine not found");
		return null;
	}

	public static void delete(Magazine b) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoBiblioteca");
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		t.begin();

		em.remove(b);

		t.commit();

		em.close();
		emf.close();

	}
}
