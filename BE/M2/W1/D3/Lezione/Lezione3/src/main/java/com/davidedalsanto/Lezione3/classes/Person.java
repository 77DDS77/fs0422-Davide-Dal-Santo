package com.davidedalsanto.Lezione3.classes;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//COSE CON XML

@Getter
@Setter
@ToString
public class Person {
	
	private String name;
	
	@Autowired
	private Address address;
}
