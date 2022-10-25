package com.davidedalsanto.classes;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Component
public class Topic {
	
	private int id;
	private String topicName;
	
	private int local = 1;
	
	public Topic(String topicName) {
		this.id = local++;
		this.topicName = topicName;
	}
	
	
}
