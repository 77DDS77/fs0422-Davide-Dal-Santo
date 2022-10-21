package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import utils.LogColor;

/*
Definsce il viaggio di un mezzo

Contiene:
	- vehicle: mezzo al quale e' stato asegnato questo viaggio 
		(many viaggi posso essere asegnati ad un mezzo)
	- route: tratta assegnata a questo viaggio
		(many viaggi posso essere assegnati ad una tratta)
*/
@Entity
@Table(name = "voyage")
public class Voyage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;
	
	@ManyToOne
	@JoinColumn(name = "route_id")
	private Route route;
		
	private int travelTime;
	
	public Voyage() {
	}

	public Voyage(Vehicle vehicle, Route route, int travelTime) {
		this.vehicle = vehicle;
		this.route = route;
		this.travelTime = travelTime;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public int getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(int averageTime) {
		this.travelTime = averageTime;
	}

	public long getId() {
		return id;
	}
	
	@Override
	public String toString() {
	     return "|| " + LogColor.YELLOW( "VOYAGE" ) + " | " +
	    
	             LogColor.YELLOW( "N. ID " + LogColor.GREEN( id+""))          
	             +"' |\n" + " \n" + "|| " +
	                
	             LogColor.CYAN( "VEICOLO " + LogColor.GREEN( vehicle.toString() ) )                
	             + '\'' + " |" +
	                
	             LogColor.CYAN( " ROUTE " + LogColor.GREEN( route.toString() ) )                
	             + '\'' + " |" +
	                
	             LogColor.CYAN( " AVERAGE TRAVEL TIME " + LogColor.GREEN( travelTime+"" ) )                
	             + '\'' + "' ||";
	}
	
	
	

}
