package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import models.Book;
import models.Item;
import models.Loan;
import models.User;

public class ArchiveDAO {

	//methods on book/magazine DAO 
	//TODO probably going to change to a single Item method
	//public static void addToCatalog() {}
	//public static void removeByISBN() {}
	//public static void findByISBN() {}
	
	public static void findByPubYear(String year) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoBiblioteca");
		EntityManager em = emf.createEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Item> cq = cb.createQuery(Item.class);

		Root<Item> p = cq.from(Item.class);

		Predicate pd1 = cb.equal(p.get("pubYear"), year);

		cq.select(p.get("pubYear")).where(pd1);

		Query q = em.createQuery(cq);

		List<Item> itemList = q.getResultList();

		if(itemList.size() == 0) {
			System.out.println("No item found.");
		}
		for(Item i : itemList) {
			System.out.println("Found: " + i);
		}
		
		em.close();
		emf.close();

	}
	
	public static void findByAuthor(String author) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoBiblioteca");
		EntityManager em = emf.createEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Book> cq = cb.createQuery(Book.class);

		Root<Book> b = cq.from(Book.class);

		Predicate pd1 = cb.equal(b.get("author"), author);

		cq.select(b.get("author")).where(pd1);

		Query q = em.createQuery(cq);

		List<Item> itemList = q.getResultList();

		if(itemList.size() == 0) {
			System.out.println("No item found.");
		}
		for(Item i : itemList) {
			System.out.println("Found: " + i);
		}
		
		em.close();
		emf.close();
	}
	
	//or part of it
	public static void findByTitle(String title) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoBiblioteca");
		EntityManager em = emf.createEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<String> cq = cb.createQuery(String.class);

		Root<Book> b = cq.from(Book.class);

		Predicate pd1 = cb.like(b.get("title"), "%"+title+"%");

		cq.select(b.get("title")).where(pd1);

		Query q = em.createQuery(cq);

		List<String> itemList = q.getResultList();

		if(itemList.size() == 0) {
			System.out.println("No item found.");
		}
		for(String i : itemList) {
			System.out.println("Found: " + i);
		}
		
		em.close();
		emf.close();
	}
	
	//userId == userCard
	public static void elementOnLoanByCard(int userId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoBiblioteca");
		EntityManager em = emf.createEntityManager();

		User found = em.find(User.class, userId);
		
		if(found != null) {
			CriteriaBuilder cb = em.getCriteriaBuilder();

			CriteriaQuery<Item> cq = cb.createQuery(Item.class);

			Root<Loan> b = cq.from(Loan.class);

			//trova loan di userid inserito
			Predicate pd1 = cb.equal(b.get("user"), userId);
			
			//loan senza data di return 
			Predicate pd2 = cb.isNull(b.get("actualReturnDate"));

			
			cq.select(b.get("id")).where(cb.and(pd1,pd2));

			Query q = em.createQuery(cq);

			List<Integer> itemList = q.getResultList();

			if(itemList.size() == 0) {
				System.out.println("User has no Item on loan.");
			}
			System.out.println("Items on Loan on card:" + userId);
			for(Integer i : itemList) {
				String iter = "\n Title: " + ((Item)(LoanDAO.getById(i).getItemLoaned())).getTitle() 
						+ "\n ISBN: " + ((Item)(LoanDAO.getById(i).getItemLoaned())).getIsbn();
				System.out.println("\nFound: " + LoanDAO.getById(i) +  iter);
				sep();
			}
		}else {
			System.out.println("User id is not valid.");
		}

		em.close();
		emf.close();
	}
	
	//Expired or non returnd loans
	public static void findOffLoans() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoBiblioteca");
		EntityManager em = emf.createEntityManager();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Item> cq = cb.createQuery(Item.class);

		Root<Loan> b = cq.from(Loan.class);
		
		//loan senza data di return 
		Predicate pd1 = cb.isNull(b.get("actualReturnDate"));
		
		cq.select(b.get("id")).where(pd1);

		Query q = em.createQuery(cq);

		List<Integer> itemList = q.getResultList();

		if(itemList.size() == 0) {
			System.out.println("There are no Loans unreturned.");
		}
		System.out.println("All items currently on Loan:");
		for(Integer i : itemList) {
			String iter = "\n Title: " + ((Item)(LoanDAO.getById(i).getItemLoaned())).getTitle() 
					+ "\n ISBN: " + ((Item)(LoanDAO.getById(i).getItemLoaned())).getIsbn();
			System.out.println("\nFound: " + LoanDAO.getById(i) +  iter);
			sep();
		}
		
	}
	
	private static void sep() {
		System.out.println("\n------------------------------");
	}
}
