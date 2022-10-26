package com.davidedalsanto.Lezione3.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.ToString;

@ToString
@Component("sc")
public class School {
	
	private String name;
	
	/*
	 * Qui adesso ho due possibili Teacher e spring non sa
	 * quale mettere, quindi posso
	 * 
	 * 1.
	 * 	@Qualifier("mathTeacher")
	 * e do la precedenza a mathTeacher
	 * 
	 * 2.
	 *  @Primary 
	 * su mathTeacher o JavaTeacher per dargli la precedenza
	 * 
	 * */
	@Autowired
	private Teacher t;
}
