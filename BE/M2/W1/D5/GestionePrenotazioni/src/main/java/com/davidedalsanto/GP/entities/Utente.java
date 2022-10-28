package com.davidedalsanto.GP.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * id
 * nome completo
 * mail
 * 
 * puo avere piu prenotazioni 
 * in corso ma non oiu di una postazione per giorno
 * */

@Entity
@Table(name = "utenti")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String fullname;
	
	private String email;
	
	@OneToMany(mappedBy = "utente")
	private Prenotazione prenotazioni;
}
