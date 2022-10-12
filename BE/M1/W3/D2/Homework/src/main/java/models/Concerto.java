package models;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;

@Entity
@DiscriminatorValue("concerto")
@NamedQuery(name = "byGenere"
	, query = "SELECT c FROM Concerto c WHERE c.genere = :g")
@NamedQuery(name = "byStream"
	, query = "SELECT c FROM Concerto c WHERE c.inStreaming = :b")
public class Concerto extends Evento {
	
	@Enumerated(EnumType.STRING)
	private Genere genere;
	private boolean inStreaming;

	public Concerto() {
	}

	public Concerto(String titolo, String dataEvento, String descrizione, 
			TipoEvento tipoEvento, int numeroMassimoPartecipanti, 
			Set<Partecipazione> partecipazioni, 
			Location location, Genere genere,
			boolean inStreaming) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, partecipazioni, location);

		this.genere = genere;
		this.inStreaming = inStreaming;
	}

	public Genere getGenere() {
		return genere;
	}

	public void setGenere(Genere genere) {
		this.genere = genere;
	}

	public boolean isInStreaming() {
		return inStreaming;
	}

	public void setInStreaming(boolean inStreaming) {
		this.inStreaming = inStreaming;
	};
	
	

}
