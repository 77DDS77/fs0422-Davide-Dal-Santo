package com.davidedalsanto.classes;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ReactStudent extends AbstractStudent {

	@Override
	public void hello() {
		System.out.println("Ciao sono uno studente React");
	}

	public ReactStudent() {

	}

	public ReactStudent(String name, char gender, List<Topic> topics, Address address, double avg) {
		super(name, gender, topics, address, avg);

	}

}
