package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = "byName"
	, query = "SELECT p FROM Person p WHERE p.name = :n")
@NamedQuery(name = "byAddressName",
		query = "SELECT p.name FROM Person p JOIN p.address a WHERE a.name = :n")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;
	
	public Person() {}

	

	public Person(String name, Address adress) {
		super();
		this.name = name;
		this.address = adress;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name 
				+ ", address=" + address + "]";
	};
	
	
}
