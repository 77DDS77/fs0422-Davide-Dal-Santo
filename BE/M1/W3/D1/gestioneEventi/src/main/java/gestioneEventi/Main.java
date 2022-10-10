package gestioneEventi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import utils.JpaUtil;

public class Main {
	
	static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction t = em.getTransaction();

	public static void main(String[] args) {
		
		Evento ev1 = new Evento("Concerto", "10-10-2022", "Concerto beneficenza", tipoEvento.PUBBLICO, 1000);
		
		insertEvento("Concerto", "10-10-2022", "Concerto beneficenza", tipoEvento.PUBBLICO, 1000);
		insertEvento("Pipoli", "10-10-2022", "Concerto a scopo di lucro", tipoEvento.PUBBLICO, 1000);
		
		getEventById(1);
		
		deleteEvent(1);

		em.close();
		emf.close();
	}
	
	public static void insertEvento(String titolo, String dataEvento, String descrizione, gestioneEventi.tipoEvento tipoEvento,
			int numeroMassimoPartecipanti) {

		Evento evento = new Evento(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
		t.begin();
		em.persist(evento);
		t.commit();
	}
	
	public static void refresh(Evento ev) {
		em.refresh(ev);
	}
	
	public static void deleteEvent(int id) {
		Evento found = em.find(Evento.class, id);
		t.begin();
		em.remove(found);
		t.commit();
	}
	
	public static void getEventById(int id) {
		Evento found = em.find(Evento.class, id);
		if(found != null) {
			System.out.println(found);
		}
	}

}
