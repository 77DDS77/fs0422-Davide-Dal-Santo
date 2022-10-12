import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Persistence;
import javax.persistence.Query;

import models.models_s2.S2_FastCar;
import models.models_s2.S2_UtilityCar;
import models.models_s3.S3_C1;
import models.models_s3.S3_C2;
import models.models_s3.S3_C3;
import models.models_s4.S4_C2;
import models.models_s4.S4_C3;
import models_s1.S1_Cat;
import models_s1.S1_Dog;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
		 * Tutto su un atabella
		 */
		//s1();
		
		//s2();
		//s2Query();
		
		//s3();
		
		s4();
		
		
	}

	public static void s1() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3D3");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();

		S1_Dog d1 = new S1_Dog("Fufi", 5, "Mario");
		S1_Dog d2 = new S1_Dog("Nala", 1, "Greta");
		
		S1_Cat c1 = new S1_Cat("Baffo", 5, 100);
		S1_Cat c2 = new S1_Cat("Micio", 8, 70);
		
		em.persist(d1);
		em.persist(d2);
		em.persist(c1);
		em.persist(c2);
		
		et.commit();
		
		em.close();
		emf.close();
	}
	
	public static void s2() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3D3");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		S2_FastCar fc1 = new S2_FastCar("Micra", "Nissan", 150.0, 50.0);
		S2_FastCar fc2 = new S2_FastCar("GTR", "Nissan", 320.0, 700.0);
		
		S2_UtilityCar uc1 = new S2_UtilityCar("Camry", "Toyota", true, 8);
		S2_UtilityCar uc2 = new S2_UtilityCar("Sharan", "VW", true, 10);
		
		em.persist(fc1);
		em.persist(fc2);
		em.persist(uc1);
		em.persist(uc2);
		
		et.commit();
		
		em.close();
		emf.close();
	}
	
	public static void s2Query() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3D3");
		EntityManager em = emf.createEntityManager();

		try {
			Query q = em.createNativeQuery(
					"SELECT s2_car.id as ciao, name, brand, for_family, comfort_lvl\r\n"
					+ "FROM s2_car JOIN s2_utilitycar ON s2_utilitycar.id = s2_car.id\r\n"
					+ "WHERE s2_utilitycar.id = 3"
					);
			
			List<Object[]> res = q.getResultList();
			
			for(int i = 0; i< res.size(); i++) {
				Object[] o = res.get(i);
				System.out.println("ID: "+ o[0] );
				System.out.println("Name: "+ o[1] );
				System.out.println("Brand: "+ o[2] );
				System.out.println("For Family: "+ o[3] );
				System.out.println("Comfort Level: "+ o[4] );
			}
		}
		catch(Exception e ) {
			
		}
		finally {			
			em.close();
			emf.close();
		}
	}

	public static void s3() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3D3");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		S3_C1 ca = new S3_C1("ao", "che e'");
		S3_C1 cb = new S3_C1("bo", "non so");
		
		S3_C2 c1 = new S3_C2("Ciao", "io", "sono");
		S3_C2 c2 = new S3_C2("Tuo", "padre", "Luke");
		
		S3_C3 c3 = new S3_C3("Sono", "stufo", "di");
		S3_C3 c4 = new S3_C3("pagare", "gli", "alimenti");
		
		em.persist(ca);
		em.persist(cb);
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		em.persist(c4);
		
		et.commit();
		
		em.close();
		emf.close();
	}
	
	public static void s4() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3D3");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
				
		S4_C2 c1 = new S4_C2("Ciao", "io", "sono");
		S4_C2 c2 = new S4_C2("Tuo", "padre", "Luke");
		
		S4_C3 c3 = new S4_C3("Sono", "stufo", "di");
		S4_C3 c4 = new S4_C3("pagare", "gli", "alimenti");
		
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		em.persist(c4);
		
		et.commit();
		
		em.close();
		emf.close();
	}


}




















