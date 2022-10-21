package models.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import models.Voyage;
import utils.JpaUtil;
import utils.LogColor;
import java.util.List;

public class VoyageDAO {

	private static final Logger log = LoggerFactory.getLogger(VoyageDAO.class);

	/*
	Salva nel databse
	*/
	public static void save(Voyage voyage) {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {
			EntityTransaction et = em.getTransaction();
			et.begin();

			em.persist(voyage);

			et.commit();

		} catch (Exception e) {
			em.getTransaction()
			.rollback();
			e.printStackTrace();
			log.error(LogColor.RED(e + ""));
		} finally {
			em.close();
		}

	}
	
	/*
	Cancella dal database data l'istanza dell'oggetto Voyage
	*/
	public static void delete(Voyage voyage) {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {
			EntityTransaction et = em.getTransaction();

			et.begin();
			Voyage found = em.find(Voyage.class, voyage.getId());

			em.remove(found);

			et.commit();

		} catch (Exception e) {
			em.getTransaction()
			.rollback();
			log.error(LogColor.RED(e.getMessage()));
		} finally {
			em.close();
		}
	}
	
	/*
	Restituisce la lista di tutti i Voyage
	*/
	public static List<Voyage> getAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            return em.createQuery("select v from Voyage v").getResultList();

        } finally {
            em.close();
        }
    }
       
    /*
	Restituisce la lista di Voyage dati ID veicolo e ID route
	(id dovrebbero esesre long, possibile ottimizzazione)
	*/
    public static List<Voyage> getRouteByIDS(int veicoloID, int routeID) {

        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            CriteriaBuilder cb = em.getCriteriaBuilder();

			CriteriaQuery<Voyage> cq = cb.createQuery(Voyage.class);

			Root<Voyage> p = cq.from(Voyage.class);

			Predicate pd1 = cb.equal(p.get("vehicle"), veicoloID);
			Predicate pd2 = cb.equal(p.get("route"), routeID);

			cq.select(p).where(pd1,pd2);

			Query q = em.createQuery(cq);

			List<Voyage> itemList = q.getResultList();

			if(itemList.size() == 0) {
				
				LogColor.errorMessage("No item found.");
			}
			
			return itemList;

        } 
        finally {
            em.close();
        }
    }
    
    /*
	Restituisce un Voyage dato il suo ID
	*/
    public static Voyage getById(Long id) {

		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {
			Voyage voyage = em.find(Voyage.class, id);

			return voyage;

		} catch (Exception e) {
			em.getTransaction()
			.rollback();
			log.error(LogColor.RED("Find voyage error: ") + e.getLocalizedMessage());

		} finally {
			em.close();
		}
		return null;
	}
	
	/*
	Metodo per cambiare il mezzo assegnato ad un Voyage
	*/
	public static void refreshVehicle(Voyage object, long newVID) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            Voyage voy = em.find(object.getClass(), object.getId());

            em.getTransaction().begin();
            voy.setVehicle(VehicleDAO.getById(newVID));
            em.getTransaction().commit();

        } finally {
            em.close();
        }

    }
    
    /*
	Metodo per cambiare la Tratta/Route assegnata ad un Voyage
	*/
    public static void refreshRoute(Voyage object, long newRID) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            Voyage voy = em.find(object.getClass(), object.getId());

            em.getTransaction().begin();
            voy.setRoute(RouteDAO.getById(newRID));
            em.getTransaction().commit();

        } finally {
            em.close();
        }

    }
    
    /*
	Metodo per cambiare il tempo medio di percorrenza di un Voyage
	*/
    public static void refreshAvgTime(Voyage object, int newAVG) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            Voyage voy = em.find(object.getClass(), object.getId());

            em.getTransaction().begin();
            voy.setTravelTime(newAVG);
            em.getTransaction().commit();

        } finally {
            em.close();
        }

    }

}
