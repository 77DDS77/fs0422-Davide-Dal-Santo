package com.BEBW2.ES.EnergyService.Exceptions;

public class CantModifyInvoiceException extends Throwable {

    public CantModifyInvoiceException(){
        super("Can't modify this Invoice because it's state is either INVIATA or ACCETTATA");
    }
}
