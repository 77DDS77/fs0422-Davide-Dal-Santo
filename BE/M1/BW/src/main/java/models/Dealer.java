package models;

import utils.LogColor;

import javax.persistence.Entity;

/*
Rivenditore fisico di biglietti
*/
@Entity
public class Dealer extends Reseller{

    public Dealer(){
    }

    @Override
    public String toString() {
        return "|| " +
                LogColor.YELLOW( "BIGLIETTERIA" ) +
                " | " +
                LogColor.YELLOW( "N. ID '" +
                        LogColor.GREEN( getId().toString() ))   + "' |\n" + " \n" + "|| " +
                LogColor.CYAN( " NOME '" +
                        LogColor.GREEN( getName() ) ) + '\'' +
                " ||";
    }
}

