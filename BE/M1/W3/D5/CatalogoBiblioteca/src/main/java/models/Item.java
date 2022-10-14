package models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
//@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "item_type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "items")
public abstract class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int isbn;
	
	private String title;
	
	@Column(name = "pub_year")
	private String pubYear;
	
	@Column(name = "num_pag")
	private int numPag;
	
	@OneToOne(mappedBy = "itemLoaned")
	private Loan loanedItem;
	
	public Item() {}

	public Item(String title, String pubYear, int numPag) {
		super();
		this.title = title;
		this.pubYear = pubYear;
		this.numPag = numPag;
	}

	public int getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPubYear() {
		return pubYear;
	}

	public void setPubDate(String pubYear) {
		this.pubYear = pubYear;
	}

	public int getNumPag() {
		return numPag;
	}

	public void setNumPag(int numPag) {
		this.numPag = numPag;
	}

	@Override
	public String toString() {
		return "Item [isbn=" + isbn + ", title=" + title 
				+ ", pubYear=" + pubYear + ", numPag=" + numPag + "]";
	}
	
	
}
