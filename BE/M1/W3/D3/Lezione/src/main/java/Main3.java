import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import models.Address;
import models.Person;

public class Main3 {

	public static void main(String[] args) {
		
		//criteriaQuery1();
		//criteriaQuery2();
		//criteriaQuery3();
		//criteriaQuery4();
		//criteriaQuery5("Davidone", 1);
		//criteriaQuery6("Davidone", 1);
		criteriaQuery7("Davidone");

	}

	public static void criteriaQuery1() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3D3");
		EntityManager em = emf.createEntityManager();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<Person> cq = cb.createQuery(Person.class);
		
		Root<Person> p = cq.from(Person.class);	
		
		//SELECT p FROM Person p
		cq.select(p);
		
		// prendi tutte le entita' di tipo person
		Query q = em.createQuery(cq);

		List<Person> list = q.getResultList();

		for (Person person : list) {
			System.out.println(person);
		}

		em.close();
		emf.close();
	}
	
	public static void criteriaQuery2() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3D3");
		EntityManager em = emf.createEntityManager();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<Person> cq = cb.createQuery(Person.class);
		
		Root<Person> p = cq.from(Person.class);	
		
		ParameterExpression<String> param = cb.parameter(String.class);
				
		//SELECT p FROM Person p WHERE name = 'Sfera'
		cq.select(p).where(
				cb.equal(p.get("name"), param)
				);
		
		// prendi tutte le entita' di tipo person
		Query q = em.createQuery(cq);
		q.setParameter(param, "Sfera");

		List<Person> list = q.getResultList();

		for (Person person : list) {
			System.out.println(person);
		}

		em.close();
		emf.close();
	}
	
	//SELECT p.name FROM Person WHERE p.id < 3
	
	public static void criteriaQuery3() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3D3");
		EntityManager em = emf.createEntityManager();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<String> cq = cb.createQuery(String.class);
		
		Root<Person> p = cq.from(Person.class);	
		
		ParameterExpression<Integer> param = cb.parameter(Integer.class);
				
		//SELECT p FROM Person p WHERE name = 'Sfera'
		cq.select(p.get("name")).where(
				cb.lessThan(p.get("id"), param)
				);
		
		// prendi tutte le entita' di tipo person
		Query q = em.createQuery(cq);
		q.setParameter(param, 3);

		List<String> list = q.getResultList();

		for (String person : list) {
			System.out.println(person);
		}

		em.close();
		emf.close();
	}
	
	
	//SELECT p.name, p.id FROM Person WHERE p.id < 3
	public static void criteriaQuery4() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3D3");
		EntityManager em = emf.createEntityManager();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
		
		Root<Person> p = cq.from(Person.class);	
		
		ParameterExpression<Integer> param = cb.parameter(Integer.class);
				

		cq.multiselect(p.get("name"), p.get("id")).where(
				cb.lessThan(p.get("id"), param)
				);
		
		// prendi tutte le entita' di tipo person
		Query q = em.createQuery(cq);
		q.setParameter(param, 3);

		List<Object[]> list = q.getResultList();

		for (Object[] person : list) {
			System.out.println(person[0] + " " + person[1]);
		}

		em.close();
		emf.close();
	}

	//SELECT p.name, p.id FROM Person WHERE name = :n AND id = :id
	public static void criteriaQuery5(String name, int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3D3");
		EntityManager em = emf.createEntityManager();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
		
		Root<Person> p = cq.from(Person.class);	
				
		Expression<String> personName = p.get("name");
		Expression<Integer> personId = p.get("id");
		
		Predicate pd1 = cb.equal(personName, name);
		Predicate pd2 = cb.equal(personId, id);
		
		cq.multiselect(p.get("name"), p.get("id")).where(
				cb.and(pd1,pd2)
				);
		
		// prendi tutte le entita' di tipo person
		Query q = em.createQuery(cq);

		List<Object[]> list = q.getResultList();

		for (Object[] person : list) {
			System.out.println(person[0] + " " + person[1]);
		}

		em.close();
		emf.close();
	}

	//SELECT p.name, p.id FROM Person WHERE name = :n AND id = :id
	public static void criteriaQuery6(String name, int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3D3");
		EntityManager em = emf.createEntityManager();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
		
		Root<Person> p = cq.from(Person.class);	
		
		ParameterExpression<String> param1 = cb.parameter(String.class);	
		ParameterExpression<Integer> param2 = cb.parameter(Integer.class);
		
		Expression<String> personName = p.get("name");
		Expression<Integer> personId = p.get("id");
		
		Predicate pd1 = cb.equal(personName, param1);
		Predicate pd2 = cb.equal(personId, param2);
		
		cq.multiselect(p.get("name"), p.get("id")).where(
				cb.and(pd1,pd2)
				);
		
		// prendi tutte le entita' di tipo person
		Query q = em.createQuery(cq);
		q.setParameter(param1, name);
		q.setParameter(param2, id);


		List<Object[]> list = q.getResultList();

		for (Object[] person : list) {
			System.out.println(person[0] + " " + person[1]);
		}

		em.close();
		emf.close();
	}

	// SELECT p.name, a.city FROM Person p JOIN p.address a WHERE name = :n
	public static void criteriaQuery7(String name) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3D3");
		EntityManager em = emf.createEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

		Root<Person> p = cq.from(Person.class);

		ParameterExpression<String> param1 = cb.parameter(String.class);


		Expression<String> personName = p.get("name");
		
		Predicate pd1 = cb.equal(personName, param1);

		Join<Person, Address> a = p.join("address", JoinType.LEFT);
		
		cq.multiselect(p.get("name"), a.get("city"))
		.where(
				pd1
				);

		// prendi tutte le entita' di tipo person
		Query q = em.createQuery(cq);
		q.setParameter(param1, name);

		List<Object[]> list = q.getResultList();

		for (Object[] person : list) {
			System.out.println(person[0] + " " + person[1]);
		}

		em.close();
		emf.close();
	}

}
