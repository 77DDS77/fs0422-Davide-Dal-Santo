package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import models.Partecipazione;
import models.Persona;
import models.Sesso;

public class PersonaDAO {
	
	//TODO mancano refresh e delete

	public static void savePersona(String nome, String cognome, String email, 
			String dob, Sesso sesso,List<Partecipazione> listaPartecipazioni) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventi-bis");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        
        Persona pers = new Persona(nome, cognome, email, dob, sesso, listaPartecipazioni);
	
        em.persist(pers);
        et.commit();

        em.close();
        emf.close();
	}
	
	public static void savePersona(Persona pers) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventi-bis");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        	
        em.persist(pers);
        et.commit();

        em.close();
        emf.close();
	}
	
	public static Persona findPersona(int id) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventi-bis");
        EntityManager em = emf.createEntityManager();
        
        Persona found = em.find(Persona.class, id);
        
        if(found != null) {
        	System.out.println("Trovata persona: " + found);
        }
		
        em.close();
        emf.close();
        return found;
	}
	
}
