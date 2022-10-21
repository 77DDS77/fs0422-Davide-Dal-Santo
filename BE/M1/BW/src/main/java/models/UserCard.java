package models;

import utils.LogColor;

import javax.persistence.*;
import java.time.LocalDate;

/*
Definisce la userCard unica per ogni utente

Setta automaticamente la scadenza ad un anno dall'istanziamento

Contiene la proprieta' user (OneToOne) per tracciare l'unico
	utente al quale e' associata
*/
@Entity
public class UserCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id", nullable = false)
    private Long id;
    private LocalDate releaseDate = LocalDate.now();
    private LocalDate expireDate = LocalDate.now().plusYears(1);
    
    @OneToOne
    private User user;

    public UserCard() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    @Override
	 public String toString() {
	     return "|| " + LogColor.YELLOW( "USER CARD" ) + " | " +
	    
	             LogColor.YELLOW( "N. ID " + LogColor.GREEN( id.toString()))          
	             +"' |\n" + " \n" + "|| " +
	                
	             LogColor.CYAN( " RELEASE DATE " + LogColor.GREEN( releaseDate+"" ) )                
	             + '\'' + " |" +
	                
	             LogColor.CYAN( " EXPIRATION DATE " + LogColor.GREEN( expireDate+"" ) )                
	             + '\''  + "' ||";
	}

}
