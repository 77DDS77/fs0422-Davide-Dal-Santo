package models;


import javax.persistence.*;

import models.dao.ResellerDAO;

import java.time.LocalDate;
import utils.LogColor;

/*
Definisce il biglietto "semplice"

Contiene una proprieta' vehicle per tracciare il mezzo su cui e' stato
	vidimato.
Contiene una proprieta' reseller per tracciare il venditore da cui e'
	stato acquistato.

Proprieta' puch e' null se non e' stato vidimato,
	se vidimato contiene la data di vidimazione.
*/
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
        
    private LocalDate releaseDate;
    private LocalDate punch;
    
    @ManyToOne
    @JoinColumn(name = "reseller_id")
    private Reseller reseller;

    public Reseller getReseller() {
        return reseller;
    }

    public void setReseller(Reseller reseller) {
        this.reseller = reseller;
    }

    public Ticket() {
		this.releaseDate = LocalDate.now();
    }

	public Long getId() {
        return id;
    }

    public LocalDate getPunch() {
        return punch;
    }

    public void setPunch(LocalDate punch) {
        this.punch = punch;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
     
     @Override
	 public String toString() {
	     return "|| " + LogColor.YELLOW( "Ticket" ) + " | " +
	    
	             LogColor.YELLOW( "N. ID '" + LogColor.GREEN( id.toString()))          
	             +"' |\n" + " \n" + "|| " +
	                
	             LogColor.CYAN( " RELEASE DATE '" + LogColor.GREEN( releaseDate+"" ) )                
	             + '\'' + " |" +
	                
	             LogColor.CYAN( " PUNCH '" + LogColor.GREEN( punch+"" ) )                
	             + '\'' + " |\n" + " \n" + "|| " + 
	                
	             LogColor.CYAN( " RESELLER " + LogColor.WHITE( ResellerDAO.getById(reseller.getId()) == null ? "null" : reseller.toString() ) );
	}
    
}
