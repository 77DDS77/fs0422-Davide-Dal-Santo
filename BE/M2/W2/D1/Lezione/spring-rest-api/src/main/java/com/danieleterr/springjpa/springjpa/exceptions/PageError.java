package com.danieleterr.springjpa.springjpa.exceptions;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PageError{

	private String msg;
	private HttpStatus status;
		
}
