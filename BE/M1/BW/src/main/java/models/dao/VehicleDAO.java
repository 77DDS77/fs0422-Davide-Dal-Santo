package models.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import models.Ticket;
import models.Vehicle;
import models.Voyage;
import utils.JpaUtil;
import utils.LogColor;

public class VehicleDAO {

	private static final Logger log = LoggerFactory.getLogger(VehicleDAO.class);

	/*
	Salva nel database
	*/
	public static void save(Vehicle vehichle) {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {
			EntityTransaction et = em.getTransaction();
			et.begin();

			em.persist(vehichle);

			et.commit();

		} catch (Exception e) {
			em.getTransaction()
					.rollback();
			e.printStackTrace();
			log.error(LogColor.RED(e + " vehichle"));
		} finally {
			em.close();
		}
	}

	/*
	Cerca Vehicle dato il suo ID
	*/
	public static Vehicle getById(Long id) {

		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {
			Vehicle vehichle = em.find(Vehicle.class, id);

			return vehichle;

		} catch (Exception e) {
			em.getTransaction()
					.rollback();
			log.error(LogColor.RED("Find vehichle error: ") + e.getLocalizedMessage());

		} finally {
			em.close();
		}
		return null;
	}

	/*
	Restituisce la lista di tutti i Vehicle
	*/
	public static List<Vehicle> getAll() {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();
		try {

			return em.createQuery("select v from Vehicle v")
					.getResultList();

		} catch (Exception e) {
			LogColor.errorMessage(e.toString());
		} finally {
			em.close();
		}
		return null;
	}

	/*
	Cancella dal database data l'istanza dell'oggetto Vehicle
	*/
	public static void delete(Vehicle object) {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();
		try {

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			em.remove(em.contains(object) ? object : em.merge(object));

			transaction.commit();
		} catch (Exception ex) {
			em.getTransaction()
					.rollback();
			log.error("Error deleting object: " + object.getClass()
					.getSimpleName(), ex);
			throw ex;

		} finally {
			em.close();
		}

	}

	/*
	Aggiorna nel database
	*/
	public static void refresh(Vehicle vehicle) {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {
			EntityTransaction t = em.getTransaction();

			t.begin();

			Vehicle oldVehicle = em.find(Vehicle.class, vehicle.getId());

			oldVehicle.setMaintenance(vehicle.getMaintenance());
			oldVehicle.setService(vehicle.getIsService());

			em.flush();

			t.commit();

		} catch (Exception e) {
			em.getTransaction()
					.rollback();
			log.error(LogColor.RED("Remove vehicle error: ") + e.getLocalizedMessage());
		} finally {
			em.close();
		}
	}

	/*
	Metodo per la vidimazione di un biglietto
	*/
	public static boolean punch(Ticket ticket, Vehicle vehicle) {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();
		boolean isValid = false;

		try {
			EntityTransaction t = em.getTransaction();
			t.begin();

			Ticket oldTicket = em.find(Ticket.class, ticket.getId());

			if (oldTicket.getVehicle() == null && oldTicket.getPunch() == null) {
				oldTicket.setPunch(LocalDate.now());
				oldTicket.setVehicle(vehicle);

				em.flush();

				t.commit();
				
				isValid = true;
			}else {
				throw new Exception("Biglietto già obliterato"); 
			}
		
		} catch (Exception e) {
			em.getTransaction()
					.rollback();
			System.err.println("Errore nel punch del biglietto: " + e);
			isValid = false;
		} finally {
			em.close();
		}
		return isValid;
	}
	
	/*
	Metodo per tracciare quante volte un Veicolo X ha percorso una Tratta Y
	e il suo tempo medio di percorrenza
	*/
	public static void vehicleTracker(Long veicoloID, Long routeID){
		 EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            CriteriaBuilder cb = em.getCriteriaBuilder();

			CriteriaQuery<Voyage> cq = cb.createQuery(Voyage.class);

			Root<Voyage> p = cq.from(Voyage.class);

			Predicate pd1 = cb.equal(p.get("vehicle"), veicoloID);
			Predicate pd2 = cb.equal(p.get("route"), routeID);
			
			cq.select(p.get("travelTime")).where(pd1,pd2);

			Query q = em.createQuery(cq);

			List<Integer> itemList = q.getResultList(); 

			
			
			double avgTot = (itemList.stream().reduce(0,  (subtotal, element) -> subtotal + element)) / itemList.size();
			
			if(itemList.size() == 0) {
				LogColor.infoMessage("Nessun viaggio trovato.");
			}else {
				
			LogColor.infoMessage("Il veicolo con id: " + LogColor.GREEN(veicoloID+"")
				+ " ha percorso la tratta con id: " + LogColor.GREEN(routeID+"") + " => " + LogColor.YELLOW(itemList.size()+"") +
				(itemList.size() == 1 ? " volta, " : " volte, ")
				+ "con un tempo medio di percorrenza di: " + LogColor.YELLOW(avgTot+"") + " min");
			}
        } 
        finally {
            em.close();
        }
	}

}










