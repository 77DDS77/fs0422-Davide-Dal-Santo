package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "persone")
public class Persona {
	
	/*
	 * TODO
	 * capire relazione delle proprieta'
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	private String cognome;
	private String email;
	private String dob; //date of birth
	@Enumerated(EnumType.STRING)
	private Sesso sesso;
	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy="persona")
	private List<Partecipazione> listaPartecipazioni;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "person_races",
		joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "race_id")
	)
	private List<GaraDiAtletica> gare;
	
	public Persona() {}

	public Persona(String nome, String cognome, String email, String dob, Sesso sesso,
			List<Partecipazione> listaPartecipazioni) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.dob = dob;
		this.sesso = sesso;
		this.listaPartecipazioni = listaPartecipazioni;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Sesso getSesso() {
		return sesso;
	}

	public void setSesso(Sesso sesso) {
		this.sesso = sesso;
	}

	public List<Partecipazione> getListaPartecipazioni() {
		return listaPartecipazioni;
	}

	public void setListaPartecipazioni(List<Partecipazione> listaPartecipazioni) {
		this.listaPartecipazioni = listaPartecipazioni;
	}

	
	@Override
	public String toString() {
		return "Persona [nome=" + getNome() + ", cognome=" + getCognome() + ", email=" + getEmail() + ", dob=" + getDob() + ", sesso="
				+ getSesso() + "]";
	};
	
	public void printListaPart() {
		for (Partecipazione partecipazione : listaPartecipazioni) {
			System.out.println(partecipazione);
		}
	}
	
	
	
}
