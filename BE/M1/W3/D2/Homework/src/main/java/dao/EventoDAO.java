package dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import models.Concerto;
import models.Evento;
import models.GaraDiAtletica;
import models.Genere;
import models.Location;
import models.Partecipazione;
import models.PartitaDiCalcio;
import models.Persona;
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
	
	public static void getConcertiPerGenere(Genere genere) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventi-bis");
		EntityManager em = emf.createEntityManager();
		

		Query q = em.createNamedQuery("byGenere");
		q.setParameter("g", genere);
		
		List<Concerto> list = q.getResultList();
		
		if(list.size() == 0) {
			System.out.println("***NESSUN CONCERTO TROVATO***");
		}else {			
			for(Concerto p : list) {
				System.out.println(p);
			}
		}
		
		
		em.close();
		emf.close();
	}
	
	public static void getConcertiInStreaming(boolean stream) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventi-bis");
		EntityManager em = emf.createEntityManager();
		

		Query q = em.createNamedQuery("byStream");
		q.setParameter("b", stream);
		
		List<Concerto> list = q.getResultList();
		
		if(list.size() == 0) {
			System.out.println("***NESSUN CONCERTO TROVATO***");
		}else {			
			for(Concerto p : list) {
				System.out.println(p);
			}
		}
		
		
		em.close();
		emf.close();
	}
	
	public static void getPartiteVinteInCasa(String squadra) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventi-bis");
		EntityManager em = emf.createEntityManager();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<Object> cq = cb.createQuery(Object.class);
		
		Root<PartitaDiCalcio> p = cq.from(PartitaDiCalcio.class);	
		
		Expression<String> squadraVincente = p.get("squadraVincente");
		Expression<String> squadraCasa = p.get("squadraCasa");

		Predicate pd1 = cb.equal(squadraVincente, squadra);
		Predicate pd2 = cb.equal(squadraCasa, squadra);
		
		cq.select(squadraVincente).where(cb.and(pd1,pd2));
		
		// prendi tutte le entita' di tipo person
		Query q = em.createQuery(cq);

		List<Object> list = q.getResultList();
		
		System.out.println("La squadra "+ squadra + " ha vinto "+ list.size() + " partite in casa.");

		em.close();
		emf.close();
	}
	
	public static void getPartiteVinteInTrasferta(String squadra) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventi-bis");
		EntityManager em = emf.createEntityManager();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<Object> cq = cb.createQuery(Object.class);
		
		Root<PartitaDiCalcio> p = cq.from(PartitaDiCalcio.class);	
		
		Expression<String> squadraVincente = p.get("squadraVincente");
		Expression<String> squadraTrasferta = p.get("squadraOspite");

		Predicate pd1 = cb.equal(squadraVincente, squadra);
		Predicate pd2 = cb.equal(squadraTrasferta, squadra);
		
		cq.select(squadraVincente).where(cb.and(pd1,pd2));
		
		// prendi tutte le entita' di tipo person
		Query q = em.createQuery(cq);

		List<Object> list = q.getResultList();
		
		System.out.println("La squadra "+ squadra + " ha vinto "+ list.size() + " partite in trasferta.");

		em.close();
		emf.close();
	}
	
	public static void getPartitePareggiate(String squadra) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventi-bis");
		EntityManager em = emf.createEntityManager();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<Object> cq = cb.createQuery(Object.class);
		
		Root<PartitaDiCalcio> p = cq.from(PartitaDiCalcio.class);	
		
		Expression<String> squadraCasa = p.get("squadraCasa");
		Expression<String> squadraTrasferta = p.get("squadraOspite");
		Expression<String> squadraVincente = p.get("squadraVincente");

		Predicate pd1 = cb.equal(squadraCasa, squadra);
		Predicate pd2 = cb.equal(squadraTrasferta, squadra);
		Predicate pd3 = cb.equal(squadraVincente, "pareggio");
		
		//pd1 or pd2 and pd3
		cq.select(p.get("id")).where(cb.and(cb.or(pd1,pd2), pd3));		
		
		Query q = em.createQuery(cq);

		System.out.println("here");
		List<Object> list = q.getResultList();
		
		System.out.println("La squadra "+ squadra + " ha pareggiato "+ list.size() + " partite.");

		em.close();
		emf.close();
	}

	
	public static void getGareDiAtleticaPerVincitore(Persona vincitore) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventi-bis");
		EntityManager em = emf.createEntityManager();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
		
		Root<GaraDiAtletica> p = cq.from(GaraDiAtletica.class);	
		
		Expression<Persona> vincitoreGara = p.get("vincitore");
		
		System.out.println(vincitoreGara.in());
		
		//pd1 or pd2 and pd3
		cq.select(p.get("vincitore")).where(cb.equal(p.get("vincitore"), vincitore));		
		
		Query q = em.createQuery(cq);

		List<Object> list = q.getResultList();
		
		System.out.println(list.size());
		


		em.close();
		emf.close();
	}
	
}



















