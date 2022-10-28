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
 * indirizzo
 * citta
 * */
@Entity
@Table(name = "edifici")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Edificio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//capire se cosi ok o fare entita'
	private String indirizzo;
	
	private String city;
	
	@OneToMany(mappedBy = "edificio")
	private List<Postazione> postazioni;
}
