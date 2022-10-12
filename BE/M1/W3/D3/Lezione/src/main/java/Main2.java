import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import models.Address;
import models.Person;
import models.models_s4.S4_C2;
import models.models_s4.S4_C3;

public class Main2 {

	public static void main(String[] args) {
		
		//makePerson("Vigonza", "Padova", "Davide");
		//makePerson("Cinisello", "Milano", "Sfera");
		//makePerson("Anguillara", "Padova", "Mauro");

		//printAllPeople();
		//sep();
		//printAllPeople2();
		//sep();
		//printAllPeople3(); non va qualcosa sulla QUERY
		//findPersonByName("Davide");
		//findPersonByAddressName("Anguillara");
		//printAllPeople();
		//updatePersonById(1, "Davidone");
		//printAllPeople();
		//deletePersonById(4);
		
	}
	
	public static void sep() {
		System.out.println("*******************");
	}

	public static void makePerson(String addressName, String addressCity, String personName) {
		
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3D3");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
				
		Address a1 = new Address(addressName, addressCity);
		Person p1 = new Person(personName, a1);
		
		em.persist(p1);
		
		et.commit();
		
		em.close();
		emf.close();
		
		
	}
	
	public static void printAllPeople() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3D3");
		EntityManager em = emf.createEntityManager();
		
		//prendi tutte le entita' di tipo person
		Query q = em.createQuery(
				"SELECT p FROM Person p", Person.class
				);
		
		List<Person> list = q.getResultList();
		
		for(Person p : list) {
			System.out.println(p);
		}
		
		
		em.close();
		emf.close();
	}
	
	public static void printAllPeople2() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3D3");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery(
				"SELECT p FROM Person p JOIN p.address a", Person.class
				);
		
		List<Person> list = q.getResultList();
		
		for(Person p : list) {
			System.out.println(p.getAddress().getCity());
		}
		
		
		em.close();
		emf.close();
	}
	
	public static void printAllPeople3() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3D3");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery(
				"SELECT p.name, a.name as address_name, a.city FROM Person p JOIN p.address a", Person.class
				);
		
		List<Object[]> list = q.getResultList();
		
		for(int i = 0; i< list.size(); i++) {
			Object[] o = list.get(i);
			System.out.println(java.util.Arrays.toString(o));
		}
		
		
		em.close();
		emf.close();
	}
	
	public static void findPersonByName(String name) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3D3");
		EntityManager em = emf.createEntityManager();
		
		//prendi tutte le entita' di tipo person
		Query q = em.createNamedQuery("byName");
		q.setParameter("n", name);
		
		List<Person> list = q.getResultList();
		
		for(Person p : list) {
			System.out.println(p);
		}
		
		
		em.close();
		emf.close();
	}
	
	public static void findPersonByAddressName(String name) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3D3");
		EntityManager em = emf.createEntityManager();
		
		//prendi tutte le entita' di tipo person
		Query q = em.createNamedQuery("byAddressName");
		q.setParameter("n", name);
		
		List<String> list = q.getResultList();
		
		System.out.println("Le persone che vivono all'indirizzo " + name + " sono: ");
		for(String p : list) {
			System.out.println(p);
		}
		
		
		em.close();
		emf.close();
	}
	
	public static void updatePersonById(int id, String newName) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3D3");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();

		Query q = em.createQuery(
				"UPDATE Person p SET name = :n WHERE p.id = :id"
				);
		q.setParameter("n", newName);
		q.setParameter("id", id);
		
		//committare l'update
		q.executeUpdate();
		
		et.commit();
		
		em.close();
		emf.close();
	}
	
	public static void deletePersonById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3D3");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();

		Query q = em.createQuery(
				"DELETE Person p WHERE p.id = :id"
				);

		q.setParameter("id", id);
		
		//committare l'update
		q.executeUpdate();
		
		et.commit();
		
		em.close();
		emf.close();
	}
}
