package com.davidedalsanto.Lezione3.components;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component
@Primary
public class JavaTeacher extends Teacher {

	public void hello() {
		System.out.println("Hello sono un Java teacher");
		
	}
}
