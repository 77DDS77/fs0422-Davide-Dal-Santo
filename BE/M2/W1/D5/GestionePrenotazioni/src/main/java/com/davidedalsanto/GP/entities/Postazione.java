package com.davidedalsanto.GP.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * id
 * descrizione
 * tipo
 * num mass occupanti
 * edificio
 * */
@Entity
@Table(name = "postazioni")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Postazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String descrizione;
	
	@Enumerated(EnumType.STRING)
	private TipoPostazione tipo;
	
	@ManyToOne
	@JoinColumn(name = "edificio_id")
	private Edificio edificio;
}
