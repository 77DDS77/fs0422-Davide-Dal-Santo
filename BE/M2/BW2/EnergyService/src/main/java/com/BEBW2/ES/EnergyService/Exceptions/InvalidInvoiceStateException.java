package com.BEBW2.ES.EnergyService.Exceptions;

public class InvalidInvoiceStateException extends Throwable {

    public InvalidInvoiceStateException(String msg){
        super("Cant perform this action, state must be: " + msg);
    }
}
