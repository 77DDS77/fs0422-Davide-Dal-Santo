package com.davidedalsanto.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.davidedalsanto.classes.Address;
import com.davidedalsanto.classes.JavaStudent;
import com.davidedalsanto.classes.ReactStudent;
import com.davidedalsanto.classes.Topic;

@Configuration
@PropertySource("classpath:application.properties")
public class Config_ {
	
	@Bean
	@Scope("prototype")
	public JavaStudent getJavaStudent() {
		return new JavaStudent("Mario", 'M', 
				List.of(JavaTopic1(), JavaTopic2()), 
				getAddress(), 
				7.2
				);
	}
	
	@Bean
	@Scope("prototype")
	public ReactStudent getReactStudent() {
		return new ReactStudent("Mirco", 'M', 
				List.of(ReactTopic1(), ReactTopic2()), 
				getAddress(), 
				8.7
				);
	}
		
	@Bean
	public Topic JavaTopic1() {
		return new Topic("Java Book");
	}
	@Bean
	public Topic JavaTopic2() {
		return new Topic("Java JPA");
	}
	
	@Bean
	public Topic ReactTopic1() {
		return new Topic("ReactBook");
	}
	@Bean
	public Topic ReactTopic2() {
		return new Topic("React AUTH");
	}
	
	private String aRoad = "Via roma 100";
	private String aCity = "Cinisello";
	
	@Bean
	@Scope("prototype")
	public Address getAddress() {
		return new Address(aRoad, aCity);
	}
	
}
