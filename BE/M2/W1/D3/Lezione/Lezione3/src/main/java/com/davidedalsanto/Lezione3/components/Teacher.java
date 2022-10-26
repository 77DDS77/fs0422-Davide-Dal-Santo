package com.davidedalsanto.Lezione3.components;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component
public abstract class Teacher implements TeacherActions{
	
	String name;
}
