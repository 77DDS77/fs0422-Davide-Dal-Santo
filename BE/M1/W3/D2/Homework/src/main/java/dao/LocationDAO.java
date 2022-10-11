package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import models.Location;

public class LocationDAO {
	
	//TODO mancano refresh e delete

	public static void saveLocation(String nome, String citta) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventi-bis");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        
        Location loc = new Location(nome, citta);
        
        em.persist(loc);
        et.commit();

        em.close();
        emf.close();
	}
	
	public static void saveLocation(Location loc) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventi-bis");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		em.persist(loc);
		et.commit();

		em.close();
		emf.close();
	}
	
	public static void findLocation(int id) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventi-bis");
        EntityManager em = emf.createEntityManager();
        
        Location found = em.find(Location.class, id);
        
        if(found != null) {
        	System.out.println("Trovata location: " + found);
        }
		
        em.close();
        emf.close();
	}
	
}
