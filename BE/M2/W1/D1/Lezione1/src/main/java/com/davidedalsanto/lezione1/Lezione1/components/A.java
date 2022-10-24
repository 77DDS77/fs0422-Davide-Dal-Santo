package com.davidedalsanto.lezione1.Lezione1.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.ToString;

@ToString
@Component
public class A {
	
	@Autowired
	private B b;
}
