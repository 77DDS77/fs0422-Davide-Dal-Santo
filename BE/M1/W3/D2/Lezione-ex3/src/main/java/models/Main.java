package models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		
		//insertPerson("Mirco");
		findPerson(1);
		findPersonVotes(1);
		findPersonFromVoteId(2);
		printPersonPosts(1);
		findPersonFromPostId(1);
		
	}
	
	public static void insertPerson(String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex3");
        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();

        et.begin();
        
        Address a = new Address("Via Roma 1", "Milano");

        Person p = new Person(name, a);

        em.persist(p);
        et.commit();

        em.close();
        emf.close();
    }

	public static void findPerson(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex3");
        EntityManager em = emf.createEntityManager();

        Person p = em.find(Person.class, id);
        
        if(p != null) {
        	System.out.println("*********"+p.getAddress().getCity());
        }

        em.close();
        emf.close();
    }
	
	public static void findPersonVotes(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex3");
        EntityManager em = emf.createEntityManager();

        Person p = em.find(Person.class, id);
        
        if(p != null) {
        	for(Vote v : p.getVotes()) {
        		System.out.println("Voto di: " + p.getName() + " -> " + v.getVote());
        	}
        }

        em.close();
        emf.close();
    }
	
	public static void findPersonFromVoteId(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex3");
        EntityManager em = emf.createEntityManager();

        Vote v = em.find(Vote.class, id);
        
        if(v != null) {
        	System.out.println("Il voto appartiene a: "+v.getPerson().getName());
        }

        em.close();
        emf.close();
    }
	
	public static void printPersonPosts(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex3");
        EntityManager em = emf.createEntityManager();

        Person p = em.find(Person.class, id);
        
        if(p != null) {
        	System.out.println("Post di: "+ p.getName());
        	for(Post post : p.getPosts()) {
        		System.out.println("Post: " + post.getText());
        	}
        }

        em.close();
        emf.close();
    }
	
	public static void findPersonFromPostId(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex3");
        EntityManager em = emf.createEntityManager();

        Post p = em.find(Post.class, id);
        
        if(p != null) {
        	System.out.println("Post: "+ p.getText());
        	for(Person pers : p.getPeople()) {
        		System.out.println("Post di: " + pers.getName());
        	}
        }

        em.close();
        emf.close();
    }
	
}
