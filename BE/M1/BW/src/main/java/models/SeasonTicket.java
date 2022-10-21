package models;


import javax.persistence.*;
import java.time.LocalDate;
import utils.LogColor;

/*
Definisce l'abbonamento che lo User puo'
acquistare in biglietteria

Un utente puo acquistare piu abbonamenti,
	un abbonamento appartiene ad un solo utente.
Un reseller puo' vendere piu season ticket,
	un season ticket e' venduto da solo un reseller
	
Validita' impostata con il metodo settedPeriodicity() 
in base al valore dell'enum Periodicity
*/
@Entity
public class SeasonTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_abbonamento", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "numero_tessera")
    private User user;
    @ManyToOne
    @JoinColumn(name = "reseller_id")
    private Reseller reseller;
    private LocalDate expireDate;
    
    @Enumerated(EnumType.STRING)
    private Periodicity periodicity;
    private LocalDate releaseDate = LocalDate.now();


    public Reseller getReseller() {
        return reseller;
    }

    public void setReseller(Reseller reseller) {
        this.reseller = reseller;
    }

    public SeasonTicket(){

    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

	/*
	Metodo per settare la validita e quindi la data di scadenza 
	dell'abbonamento in base al valore di Enum.Periodicity
	*/
    public void settedPeriodicity(){
        if (periodicity == Periodicity.WEEKLY){
            expireDate = LocalDate.now().plusWeeks(1);
        } else if (periodicity == Periodicity.MONTHLY) {
            expireDate = LocalDate.now().plusMonths(1);
        } else if (periodicity == Periodicity.YEARLY) {
            expireDate = LocalDate.now().plusYears(1);
        } else {
            expireDate = LocalDate.now().plusWeeks(1);
        }
    }

    @Override
	public String toString() {
	     return "|| " + LogColor.YELLOW( "Season Ticket" ) + " | " +
	    
	             LogColor.YELLOW( "N. ID " + LogColor.GREEN( id.toString()))          
	             +"' |\n" + " \n" + "|| " +
	                
	             LogColor.CYAN( "USER " + LogColor.GREEN( user.toString() ) )                
	             + '\'' + " |" +
	                
	             LogColor.CYAN( " RESELLER " + LogColor.GREEN( reseller.toString() ) )                
	             + '\'' + " |" +
	                
	             LogColor.CYAN( " EXPIRATION DATE " + LogColor.GREEN( expireDate+"" ) )                
	             + '\'' + " |" +
	                
	             LogColor.CYAN( " PERIODICITY " + LogColor.GREEN( periodicity+"" ) )                
	             + '\'' + " |" +
	                
	             LogColor.CYAN( " RELEASE DATE " + LogColor.GREEN( releaseDate+"" ) )                
	             + '\'' + "' ||";
	}
}
