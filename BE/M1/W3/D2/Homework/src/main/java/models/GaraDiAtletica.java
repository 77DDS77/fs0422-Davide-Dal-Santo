package models;

import java.util.Random;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("gara_di_atletica")
public class GaraDiAtletica extends Evento{
	
	@ManyToMany(mappedBy = "gare")
	Set<Persona> setAtleti;
	
	@ManyToOne
	@JoinColumn(name = "id_person")
	Persona vincitore;
	
	
	public GaraDiAtletica() {}


	public GaraDiAtletica(String titolo, String dataEvento, 
			String descrizione, TipoEvento tipoEvento,
			int numeroMassimoPartecipanti, 
			Set<Partecipazione> partecipazioni, Location location,
			Set<Persona> setAtleti) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, partecipazioni, location);
		
		this.setAtleti = setAtleti;
		this.vincitore = setVincitore();
	}


	public Set<Persona> getSetAtleti() {
		return setAtleti;
	}


	public void setSetAtleti(Set<Persona> setAtleti) {
		this.setAtleti = setAtleti;
	}


	public Persona getVincitore() {
		return vincitore;
	}

	public void setVincitoreVoid() {
		Random rand = new Random();
		int randWinner = rand.nextInt(setAtleti.size());
		Persona[] winnerPool = 
				setAtleti.toArray(new Persona[setAtleti.size()]);
		vincitore = winnerPool[randWinner];
	};

	private Persona setVincitore() {
		Random rand = new Random();
		int randWinner = rand.nextInt(setAtleti.size());
		Persona[] winnerPool = 
				setAtleti.toArray(new Persona[setAtleti.size()]);
		return winnerPool[randWinner];
	};
	
	
	
}
