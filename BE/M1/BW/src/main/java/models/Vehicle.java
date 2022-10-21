package models;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import utils.LogColor;

/*
Definisce il Veicolo 

Contiene:
	- type: valori dati dall'enum VehicleType, puo essere BUS o TRAM
	- Set voyage: i viaggi eseguiti dal dato mezzo
	- Set ticket: biglietti vidimati dal dato mezzo
	- maintenance: data della manutenzione del mezzo durante
		la quale non sara' in servizio quindi non sara' possibile
		assegnarli altri viaggi
*/
@Entity
@Table(name = "vehicles")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private VehicleType type;

	@OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
	private Set<Voyage> voyage;

	@OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
	private Set<Ticket> ticket;

	private boolean isService;
	private LocalDate maintenance;
	private short capacity;

	public Vehicle() {
	}

	public Vehicle(VehicleType type) {
		this.type = type;
		this.setMaintenance();
		this.setCapacity(type);
		setService();
	}

	private void setCapacity(VehicleType type) {
		if (type == VehicleType.BUS)

			this.capacity = 50;
		else if (type == VehicleType.TRAM)

			this.capacity = 100;
		else
			System.err.println("Unexpected value: " + type);

	}

	public void setType(VehicleType type) {
		this.type = type;
		this.setCapacity(type);
	}

	public void setMaintenance() {
		this.maintenance = LocalDate.now()
				.plusYears(1);
	}

	public void setMaintenance(LocalDate maintenance) {
		this.maintenance = maintenance;
	}

	public short getCapacity() {
		return capacity;
	}

	public VehicleType getType() {
		return type;
	}

	public LocalDate getMaintenance() {
		return maintenance;
	}

	public Long getId() {
		return id;
	}

	public boolean getIsService() {
		if (this.isService == true) {
			this.setService();
		}

		return isService;
	}

	public void setService() {
		this.isService = (LocalDate.now()).isBefore(this.maintenance);
	}

	public void setService(boolean service) {
		boolean s = (LocalDate.now()).isBefore(this.maintenance);

		if (s && service)
			this.isService = true;
		else
			this.isService = false;

	}
	
	@Override
	public String toString() {
	     return "|| " + LogColor.YELLOW( "VEICOLO" ) + " | " +
	    
	             LogColor.YELLOW( "N. ID " + LogColor.GREEN( id.toString()))          
	             +"' |\n" + " \n" + "|| " +
	                
	             LogColor.CYAN( "CAPACITY " + LogColor.GREEN( capacity+"" ) )                
	             + '\'' + " |" +
	                
	             LogColor.CYAN( " TYPE " + LogColor.GREEN( type+"" ) )                
	             + '\'' + " |" +
	                
	             LogColor.CYAN( " MAINTENANCE " + LogColor.GREEN( maintenance+"" ) )                
	             + '\'' + " |" +
	                
	             LogColor.CYAN( " IN SERVICE " + LogColor.GREEN( isService+"" ) )                
	             + '\'' + "' ||";
	}
}
