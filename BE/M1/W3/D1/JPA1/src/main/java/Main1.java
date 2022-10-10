import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import models.Student;

public class Main1 {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA1");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction t = em.getTransaction();

	public static void main(String[] args) {
		System.out.println("Here");

		//insertStudent("Mario", "Rossi", "5,2,4");
		findStudent(2);
		
		
		//collegamento con file persistence.xml
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA1");
		
		//direttore delle nostre entita
		//cerca le annotazioni @entity
		//EntityManager em = emf.createEntityManager();
		
		Student s = new Student("Davide", "Dal Santo", "2,3,4,5");
		
		//creo transazione
		//EntityTransaction t = em.getTransaction();
		
		//inizialiszzo trans
		//t.begin();
		
		//mettere nella entity manager cosa abbiamo fatto
		//em.persist(s);
		
		//committare
		//t.commit();
		
		//chiudere sia em sia emf
		em.close();
		emf.close();
		
	}
	
	public static void insertStudent(String name, String lastname, String votes) {
		
		Student sNew = new Student(name, lastname, votes);
		t.begin();
		em.persist(sNew);
		t.commit();
	}
	
	public static void findStudent(int id) {
		Student found = em.find(Student.class, id);
		if(found != null) {
			System.out.println(found);
		}
	}

}


















