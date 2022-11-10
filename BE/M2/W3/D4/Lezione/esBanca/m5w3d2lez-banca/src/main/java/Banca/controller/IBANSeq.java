package Banca.controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
public class IBANSeq {

	@Id
	@SequenceGenerator(name = "IBAN_seq", initialValue = 100, allocationSize = 100)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IBAN_seq")
	private Long id;
	
	
}
