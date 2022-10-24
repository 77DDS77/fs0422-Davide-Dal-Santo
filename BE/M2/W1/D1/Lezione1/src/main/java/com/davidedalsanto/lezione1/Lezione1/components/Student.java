package com.davidedalsanto.lezione1.Lezione1.components;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component //springbot
public class Student {
	
	private String name;
	private int[] votes;
	private Address address;
	private Work work;
	
	public Student(String name, int[] votes) {
		this.name = name;
		this.votes = votes;
	}

	public Student(String name, Address address) {
		this.name = name;
		this.address = address;
	}

	public Student(String name, int[] votes, Address address) {
		super();
		this.name = name;
		this.votes = votes;
		this.address = address;
	}
	
	public Student(String name, Work workl) {
		this.name = name;
		this.work = workl;
	}

	
}	
