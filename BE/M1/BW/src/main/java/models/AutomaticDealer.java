package models;


import utils.LogColor;

import javax.persistence.Entity;

/*
Classe per rivenditori automatici di biglietti
- il rivenditore puo' essere attivo o no
*/
@Entity
public class AutomaticDealer extends Reseller{
 private boolean active = true;

    public AutomaticDealer() {
    }

    @Override
    public String toString() {
        return "|| " +
                LogColor.YELLOW( "BIGLIETTERIA AUTOMATICA" ) +
                " | " +
                LogColor.YELLOW( "N. ID '" +
                        LogColor.GREEN( getId().toString() ))   + "' |\n" + " \n" + "|| " +
                LogColor.CYAN( " NOME '" +
                        LogColor.GREEN( getName() ) ) + '\'' +
                LogColor.CYAN( " IN SERVIZIO '" +
                        LogColor.GREEN( active ? "SI" : "NO" ) ) + '\'' +
                " ||";
    }

    public boolean isActive() {
        return active;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
