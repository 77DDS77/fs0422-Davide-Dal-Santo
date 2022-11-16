package com.BEBW2.ES.EnergyService.Exceptions;

public class ComuneNotFoundException extends Throwable {

    public ComuneNotFoundException(String comune){
        super("Comune with name: " + comune + " is not found.");
    }
}
