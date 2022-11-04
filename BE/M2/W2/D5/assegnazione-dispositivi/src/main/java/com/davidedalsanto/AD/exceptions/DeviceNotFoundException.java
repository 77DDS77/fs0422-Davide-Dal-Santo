package com.davidedalsanto.AD.exceptions;

public class DeviceNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DeviceNotFoundException() {
		super("No device found.");
	}
}
