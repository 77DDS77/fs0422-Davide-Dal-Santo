package com.danieleterr.springjpa.springjpa.exceptions;

public class PageException extends RuntimeException{

	public PageException(String msg) {
		super("Page Exception: " + msg);
	}
}
