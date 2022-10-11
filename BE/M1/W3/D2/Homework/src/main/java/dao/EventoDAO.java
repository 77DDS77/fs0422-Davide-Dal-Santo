package dao;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import models.Evento;
import models.Location;
import models.Partecipazione;
import models.TipoEvento;

public class EventoDAO {
	
	//TODO mancano refresh e delete

	//devi avere location e partecipazione pronti
	public static void saveEvento(String titolo, String dataEvento, 
			String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, 
			Set<Partecipazione> partecipazioni, Location location) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventi-bis");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        
        Evento event = new Evento(titolo, dataEvento, descrizione, 
        		tipoEvento, numeroMassimoPartecipanti, 
        		partecipazioni, location);
        
        em.persist(event);
        et.commit();

        em.close();
        emf.close();
	}
	
	public static void saveEvento(Evento event) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventi-bis");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        et.begin();
                
        em.persist(event);
        et.commit();

        em.close();
        emf.close();
	}
	
	
	public static void findEvento(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventi-bis");
        EntityManager em = emf.createEntityManager();
        
        Evento found = em.find(Evento.class, id);
        
        if(found != null) {
        	System.out.println("Trovato: " + found);
        }
        em.close();
        emf.close();
	}
	
	
}
