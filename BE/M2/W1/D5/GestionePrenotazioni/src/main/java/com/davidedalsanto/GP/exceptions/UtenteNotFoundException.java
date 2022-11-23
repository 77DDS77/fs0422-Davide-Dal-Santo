package com.davidedalsanto.GP.exceptions;

public class UtenteNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UtenteNotFoundException() {
		super("ID inserito non corrisponde a nessun utente.");
	}
}
