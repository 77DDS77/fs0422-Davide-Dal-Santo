package com.davidedalsanto.Lezione3.beans;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Dog {

	private String name;
	
	@Autowired
	private AnimalInfo animalInfo;
}
