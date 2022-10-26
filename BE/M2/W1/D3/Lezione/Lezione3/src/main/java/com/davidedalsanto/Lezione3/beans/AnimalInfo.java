package com.davidedalsanto.Lezione3.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class AnimalInfo {
	
	//@Value("${dog2.breed}")
	private String breed;
	
	//@Value("${dog2.price}")
	private double price;
}
