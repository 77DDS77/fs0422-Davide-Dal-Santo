package models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import utils.MagazineDAO;

@Entity
@Table(name = "magazines")
public class Magazine extends Item {

	@Column(name = "periodicity")
	@Enumerated(EnumType.STRING)
	private Every every;

	public Magazine() {
	}

	public Magazine(String title, String pubYear, int numPag, Every every) {
		super(title, pubYear, numPag);

		this.every = every;
	}

	public Every getEvery() {
		return every;
	}

	public void setEvery(Every every) {
		this.every = every;
	}

	@Override
	public String toString() {
		return "Magazine [every=" + every + "]";
	}


}
