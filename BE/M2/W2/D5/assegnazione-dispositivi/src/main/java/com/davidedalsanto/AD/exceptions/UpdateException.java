package com.davidedalsanto.AD.exceptions;

public class UpdateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UpdateException() {
		super("Something went wrong, update FAILED");
	}
}
