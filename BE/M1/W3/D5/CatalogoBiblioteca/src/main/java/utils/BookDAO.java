package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import models.Book;

public class BookDAO {

    public static void save(String title, String pubYear, int numPag, String author, String genre) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoBiblioteca");
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        
     
        Book book = new Book(title, pubYear, numPag, author, genre);
        
        t.begin();
        
        em.persist(book);
        
        t.commit();
        
        em.close();
        emf.close();
        
    }
    
    public static void save(Book book) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoBiblioteca");
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
               
        t.begin();
        
        em.persist(book);
        
        t.commit();
        
        em.close();
        emf.close();
        
    }
    
    public static Book getByISBN(int isbn) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoBiblioteca");
        EntityManager em = emf.createEntityManager();
        
        Book found = em.find(Book.class, isbn);
        
        em.close();
        emf.close();
        
        if(found != null) {        	
        	return found;
        }
        System.out.println("Book not found");
        return null;
    }
    
    public static void delete(Book b) {
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
