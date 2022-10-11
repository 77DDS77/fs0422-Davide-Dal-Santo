package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Persona persona;
	
	//many partecipazioni to one evento
	//no cascade perche' se cancello partec non voglio cvancellare ebvento
	@ManyToOne
	private Evento evento;
	@Enumerated(EnumType.STRING)
	private StatoPartecipazione statoPartecipazione;
	
	public Partecipazione() {}

	public Partecipazione(Persona persona, Evento evento, StatoPartecipazione statoPartecipazione) {
		super();
		this.persona = persona;
		this.evento = evento;
		this.statoPartecipazione = statoPartecipazione;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public StatoPartecipazione getStatoPartecipazione() {
		return statoPartecipazione;
	}

	public void setStatoPartecipazione(StatoPartecipazione statoPartecipazione) {
		this.statoPartecipazione = statoPartecipazione;
	}

	@Override
	public String toString() {
		return "Partecipazione [persona=" + persona + ", evento=" + evento + ", statoPartecipazione="
				+ statoPartecipazione + "]";
	};
	
	
}
