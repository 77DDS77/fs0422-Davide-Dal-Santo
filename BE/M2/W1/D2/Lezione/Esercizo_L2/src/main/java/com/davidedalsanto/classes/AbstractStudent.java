package com.davidedalsanto.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

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
public abstract class AbstractStudent implements Student{

	private int id;
	private String name;
	private char gender;
	
	//@Autowired
	private List<Topic> topics;
	
	@Autowired
	private Address address;
	private double avg;
	
	private int local = 1;
	
	public void addTopic(Topic topic) {
		topics.add(topic);
	}
	
	public AbstractStudent(String name, char gender, List<Topic> topics, Address address, double avg) {
		this.id = local++;
		this.name = name;
		this.gender = gender;
		this.topics = topics;
		this.address = address;
		this.avg = avg;
		
	}
}
