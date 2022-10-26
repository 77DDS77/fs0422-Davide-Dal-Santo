package com.davidedalsanto.Lezione3.components;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component
public class MathTeacher extends Teacher{
	
	@Override
	public void hello() {
		System.out.println("Hello sono un math teacher");
		
	}
	
}
