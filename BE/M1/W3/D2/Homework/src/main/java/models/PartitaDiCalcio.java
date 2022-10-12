package models;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("partita_di_calcio")
public class PartitaDiCalcio extends Evento{
	
	private String squadraCasa;
	private String squadraOspite;
	private String squadraVincente;
	private int golCasa;
	private int golOspite;
	

	public PartitaDiCalcio() {};
	
	public PartitaDiCalcio(String titolo, String dataEvento, 
			String descrizione, TipoEvento tipoEvento,
			int numeroMassimoPartecipanti, 
			Set<Partecipazione> partecipazioni, Location location,
			String squadraCasa, String squadraOspite, 
			int golCasa, int golOspite) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, partecipazioni, location);
		
		this.squadraCasa = squadraCasa;
		this.squadraOspite = squadraOspite;
		this.golCasa = golCasa;
		this.golOspite = golOspite;
		this.squadraVincente = setSquadraVincente();
	}



	public String getSquadraCasa() {
		return squadraCasa;
	}



	public void setSquadraCasa(String squadraCasa) {
		this.squadraCasa = squadraCasa;
	}



	public String getSquadraOspite() {
		return squadraOspite;
	}



	public void setSquadraOspite(String squadraOspite) {
		this.squadraOspite = squadraOspite;
	}



	public String getSquadraVincente() {
		return squadraVincente;
	}
	
	public void setSquadraVincenteVoid() {
		if(golCasa > golOspite) {
			squadraVincente = squadraCasa;
		}else if(golCasa == golOspite){
			squadraVincente = null;
		}else {
			squadraVincente = squadraOspite;
		}
	}


	private String setSquadraVincente() {
		if(golCasa > golOspite) {
			return squadraCasa;
		}else if(golCasa == golOspite){
			return null;
		}else {
			return squadraOspite;
		}
	}



	public int getGolCasa() {
		return golCasa;
	}



	public void setGolCasa(int golCasa) {
		this.golCasa = golCasa;
	}



	public int getGolOspite() {
		return golOspite;
	}



	public void setGolOspite(int golOspite) {
		this.golOspite = golOspite;
	}
}
