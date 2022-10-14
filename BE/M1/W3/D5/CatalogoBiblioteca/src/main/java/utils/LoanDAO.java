package utils;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import models.Every;
import models.Item;
import models.Loan;
import models.Magazine;
import models.User;

public class LoanDAO {

	public static void save(User user, Item itemLoaned) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoBiblioteca");
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		Loan loan = new Loan(user, itemLoaned);

		t.begin();

		em.persist(loan);

		t.commit();

		em.close();
		emf.close();

	}

	public static void save(Loan loan) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoBiblioteca");
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		t.begin();

		em.persist(loan);

		t.commit();

		em.close();
		emf.close();

	}

	public static Loan getById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoBiblioteca");
		EntityManager em = emf.createEntityManager();

		Loan found = em.find(Loan.class, id);

		em.close();
		emf.close();

		if (found != null) {
			return found;
		}
		System.out.println("Loan not found");
		return null;
	}


	public static void endLoan(int loanId) {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoBiblioteca");
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		Loan found = em.find(Loan.class, loanId);
		
		if(found.getActualReturnDate() == null) {

			t.begin();

			found.setActualReturnDate(LocalDateTime.now());
			
			int compare = found.getReturnDate().compareTo(found.getActualReturnDate());
			
			if (compare > 0) {
				System.out.println("Thanks for returning in time");
			} else {
				System.out.println("You're late on the return!");
			}
			
			
			t.commit();
			
			
		}else {
			System.out.println("Loan alredy closed.");
		}

		em.close();
		emf.close();
		
	}

	//BETA might fly out of the window
	public static void endLoan(Loan loan) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoBiblioteca");
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        t.begin();
        
        // create update
        CriteriaUpdate<Loan> update = cb.
        createCriteriaUpdate(Loan.class);
 
        // set the root class
        Root e = update.from(Loan.class);
 
        // set update and where clause
        update.set("actualReturnDate", LocalDateTime.now());
        update.where(cb.equal(e.get("id"), loan.getId()));
 
        // perform update
        em.createQuery(update).executeUpdate();
        
        em.flush();
        t.commit();
        
        em.close();
        emf.close();
      
    }
}
