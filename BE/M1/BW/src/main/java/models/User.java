package models;

import utils.LogColor;

import java.util.Set;

import javax.persistence.*;

/*
Definisce lo User

Coniente setSeason, Set di abbonamenti acquistati dall'utente

Contiene userCard unica per ogni utente
*/
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    private String name;
    private String lastName;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<SeasonTicket> setSeason;
    
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserCard userCard;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "|| " + LogColor.YELLOW( "Utente" ) + " | " +
    
                LogColor.YELLOW( "N. ID '" + LogColor.GREEN( id.toString()))          
                +"' |\n" + " \n" + "|| " +
                
                LogColor.CYAN( "NOME '" + LogColor.GREEN( name ) )                
                + '\'' + " |" +
                
                LogColor.CYAN( " COGNOME '" + LogColor.GREEN( lastName ) )                
                + '\'' + "' ||";

    }
}