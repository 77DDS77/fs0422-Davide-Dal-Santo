package models;



import utils.LogColor;

import javax.persistence.*;
import java.util.Set;

/*
Superclasse dei RIvenditori, estendera' automaticDealer e Dealer
*/
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Reseller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    
    @OneToMany(mappedBy = "reseller")
    private Set<Ticket> ticket;

    public Reseller() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    @Override
    public String toString() {
        return "|| " +
                LogColor.YELLOW( "BIGLIETTERIA" ) +
                " | " +
                LogColor.YELLOW( "N. ID '" +
                        LogColor.GREEN( id.toString() ))   + "' |\n" + " \n" +
                "|| " + LogColor.CYAN( " NOME '" +
                        LogColor.GREEN( name ) ) + '\'' +
                " ||";
    }

}
