package models.dao;

import models.AutomaticDealer;
import models.Periodicity;
import models.Reseller;
import models.SeasonTicket;
import models.Ticket;
import models.User;
import models.UserCard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.JpaUtil;
import utils.LogColor;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.time.LocalDate;
import java.util.List;

public class ResellerDAO {
    private static final Logger logger = LoggerFactory.getLogger(ResellerDAO.class);

	/*
	Metodo per salvare in database
	*/
    public static void save(Reseller object) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            em.persist(object);


            transaction.commit();
            LogColor.infoMessage( "Aperta una nuova attivita'à in citta'à: " + object);
        } catch (Exception ex) {
            em.getTransaction().rollback();

            logger.error("Error saving object: " + object.getClass().getSimpleName(), ex);
            throw ex;

        } finally {
            em.close();
        }

    }

	/*
	Semplice refresh JPA
	*/
    public static void refresh(Reseller object) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            em.refresh(object);

        } finally {
            em.close();
        }

    }

	/*
	Cerca nel database un Reseller tramite ID
	*/
    public static Reseller getById(Long id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            
            Reseller found = em.find(Reseller.class, id);
			
			if(found.equals(null)){
                return null;
            }
            return found;

        } finally {
            em.close();
        }

    }
	
	/*
	Dato un Reseller lo cerca nel database e lo elimina
	*/
    public static void delete(Reseller object) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            em.remove(em.contains(object) ? object : em.merge(object));

            LogColor.infoMessage( "L'attività" + object +  " è stata chiusa definitivamente"  );

            transaction.commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            logger.error("Error deleting object: " + object.getClass().getSimpleName(), ex);
            throw ex;

        } finally {
            em.close();
        }

    }
	
	/*
	Ritorna la lista di tutti i Reseller
	*/
    public static List<Reseller> getAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            return em.createQuery("select p from Reseller p").getResultList();

        } finally {
            em.close();
        }
    }
	
	/*
	Cerca nel database un Reseller dato il suo nome
	*/
    public static List<Reseller> getByName(String name) {

        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Reseller> cq = cb.createQuery(Reseller.class);

        Root<Reseller> b = cq.from(Reseller.class);

        Predicate pd1 = cb.like(cb.lower(b.get("name")), "%"+name.toLowerCase()+"%");

        cq.select(b).where(pd1);

        Query q = em.createQuery(cq);

        return  q.getResultList();
    }
    
    /*
	Metodo per la creazione di un biglietto utilizzabile
	*/
    public static void makeTiket(Reseller reseller) {
        if( reseller instanceof AutomaticDealer automaticDealer ) {

            if( automaticDealer.getActive() ) {

                Ticket ticket = new Ticket();
                ticket.setReseller(reseller);
                TicketDAO.save(ticket);
                LogColor.infoMessage( "Biglietto acquistato" );

            } else {
                LogColor.errorMessage( "Distributore fuori servizio!" );
            }
        } else {
            Ticket ticket = new Ticket();
            ticket.setReseller(reseller);
            TicketDAO.save(ticket);
            LogColor.infoMessage( "Biglietto acquistato" );
        }

    }

	/*
	Metodo per la creazione di un abbonamento utilizzabile
	L'utente che compra l'abbonamento deve avere una UserCard valida
	con una scadenza postuma alla scadenza dell'abbonamento che vuole comprare'
	*/
    public static void makeSeasonTiket(Reseller reseller, User user, Periodicity periodicity) {

        if( reseller instanceof AutomaticDealer automaticDealer ) {

            if( automaticDealer.getActive() ) {

                UserCardDAO dao = new UserCardDAO();
                List<UserCard> cardList = dao.getCardByUserId(user.getId());

                if(cardList.size() > 0){
                    if(LocalDate.now().compareTo(cardList.get(0).getExpireDate()) < 0) {
                        SeasonTicket ticket = new SeasonTicket();
                        ticket.setReseller(reseller);
                        ticket.setUser(user);
                        ticket.setPeriodicity(periodicity);
                        ticket.settedPeriodicity();
                        SeasonTicketDAO.save(ticket);
                        LogColor.infoMessage( "Abbonamento acquistato" );
                    } else{
                        System.out.println("Tessera scaduta, rinnovala");
                    }
                } else {
                    System.out.println("l'utente non ha la tessera!");
                }

            } else {
                LogColor.errorMessage( "Distributore fuori servizio!" );
            }
        } else {
            UserCardDAO dao = new UserCardDAO();
            List<UserCard> cardList = dao.getCardByUserId(user.getId());

            if(cardList.size() > 0){
                if(LocalDate.now().compareTo(cardList.get(0).getExpireDate()) < 0) {
                    SeasonTicket ticket = new SeasonTicket();
                    ticket.setReseller(reseller);
                    ticket.setUser(user);
                    ticket.setPeriodicity(periodicity);
                    ticket.settedPeriodicity();
                    SeasonTicketDAO.save(ticket);
                } else{
                    System.out.println("Tessera scaduta, rinnovala");
                }
            } else {
                System.out.println("l'utente non ha la tessera!");
            }
        }

    }

	/*
	Metodo per la creazione della UserCard
	con cui l'utente poi potra' comprare un abbonamento
	la tessera ha validita' un anno, un utente puo' avere
	solo una tessera
	*/
    public static void makeCard(User user){
        UserCardDAO dao = new UserCardDAO();
        List<UserCard> cardList = dao.getCardByUserId(user.getId());

        if(cardList.size() == 0){
            UserCard card = new UserCard();
            card.setUser(user);
            dao.save(card);
            LogColor.infoMessage( "Tessera acquistata :" + card );
        } else {
            LogColor.errorMessage("Gia'à la tieni la tessera imbroglione!!!!");
        }

    }
	
	/*
	Metodo per rinnovare la UserCard e 
	posticipare la sua scadenza di un anno
	*/
    public static void renewCard(UserCard card){
        LocalDate newDate = LocalDate.now().plusYears( 1 );
        UserCardDAO.refreshExpireDate( card, newDate );
    }

    public static List<AutomaticDealer> getActiveAutomaticDealers( String name ) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            Query q = em.createQuery( "select a from AutomaticDealer a where upper(a.name) " +
                    "like upper(concat('%', :nome, '%')) " );

            q.setParameter( "nome", name );

            return q.getResultList();

        } finally {
            em.close();
        }
    }

    public static void refreshActive( AutomaticDealer object, boolean isActive) {
        EntityManager em = JpaUtil.getEntityManagerFactory()
                .createEntityManager();
        try {

            AutomaticDealer ad = em.find(object.getClass(), object.getId());

            em.getTransaction().begin();

            ad.setActive(isActive);

            em.getTransaction()
                    .commit();

            LogColor.infoMessage( "Modificato stato di servizio in : " + ad );

        } finally {
            em.close();
        }

    }
}