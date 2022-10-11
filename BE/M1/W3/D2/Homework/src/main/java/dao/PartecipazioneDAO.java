package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import models.Evento;
import models.Partecipazione;
import models.Persona;
import models.StatoPartecipazione;

public class PartecipazioneDAO {
	
	//TODO mancano refresh e delete

	public static void savePartecipazione(Persona persona, Evento evento, StatoPartecipazione statoPartecipazione) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventi-bis");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        
        Partecipazione part = new Partecipazione(persona, evento, statoPartecipazione);
        
        em.persist(part);
        et.commit();

        em.close();
        emf.close();
	}
	
	public static void savePartecipazione(Partecipazione part) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventi-bis");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		em.persist(part);
		et.commit();

		em.close();
		emf.close();
	}
	
	public static void findPartecipazione(int id) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventi-bis");
        EntityManager em = emf.createEntityManager();
        
        Partecipazione found = em.find(Partecipazione.class, id);
        
        if(found != null) {
        	System.out.println("Trovata partecipazione: " + found);
        }
		
        em.close();
        emf.close();
	}
	
}
