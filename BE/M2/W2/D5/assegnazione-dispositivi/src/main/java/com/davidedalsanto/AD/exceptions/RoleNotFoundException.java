package com.davidedalsanto.AD.exceptions;

public class RoleNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RoleNotFoundException() {
		super("No role found.");
	}
}
