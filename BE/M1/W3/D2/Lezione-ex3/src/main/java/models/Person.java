package models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	/*
	 * la persona ha un  solo indirizzo
	 * messo sulla colonna address_id
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;
	
	/*
	 * La persona ha piu voti, ogni voto e' uan row di VOte
	 */
	@OneToMany(mappedBy = "person")
	private Set<Vote> votes;
	
	/*
	 * Hai una tabella esterna che contiene la PK di Person
	 * e la PK di Post
	 */
	@ManyToMany
	@JoinTable(
		      name = "person_post", 
		      joinColumns = @JoinColumn(name = "person_id"), 
		      inverseJoinColumns = @JoinColumn(name = "post_id")
			)
	private Set<Post> posts;
	

	public Person() {}

	public Person(String name) {
		super();
		this.name = name;
	}

	
	public Person(String name, Address address) {
		super();
		this.name = name;
		this.address = address;
	}
	
	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	public Set<Vote> getVotes() {
		return votes;
	}
	
	public void setVotes(Set<Vote> votes) {
		this.votes = votes;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Persona: " + name;
	}
}

