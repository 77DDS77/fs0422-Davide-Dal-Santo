package models;

import java.util.Set;
import utils.LogColor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
Definisce la rotta che un mezzo puo fare,
ha inizio, fine e tempo di percorrenza.
Un mezzo puo' avere una sola rotta ma
piu' mezzi possono condividere la stesa rotta
*/
@Entity
@Table(name = "routes")
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String start;
	private String finish;
	private int travelTime;

	@OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
	private Set<Voyage> voyage;

	public Route() {
	}

	public Route(String start, String finish, int travelTime) {
		this.start = start;
		this.finish = finish;
		this.travelTime = travelTime;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String s) {
		this.start = s;
	}

	public String getFinish() {
		return finish;
	}

	public void setFinish(String f) {
		this.finish = f;
	}
	
	public int getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(int tt) {
		this.travelTime = tt;
	}

	
	public long getId() {
		return id;
	}
	
	@Override
    public String toString() {
        return "|| " +
                LogColor.YELLOW( "Route" ) 
                + " | " + LogColor.YELLOW( "N. ID '" +
                        LogColor.GREEN( id+"" ))   + "' |\n \n|| " +
                LogColor.CYAN( "Start '" +
                        LogColor.GREEN( start ) ) + "\' |" +
                LogColor.CYAN( " Finish '" +
                        LogColor.GREEN( finish ) )  + "\'" +
                LogColor.CYAN( " Travel Time '" +
                        LogColor.GREEN( travelTime+"" ) )  + "\'"
                + " ||";
    }
	
}
