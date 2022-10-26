package com.davidedalsanto.Lezione3.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.davidedalsanto.Lezione3.beans.AnimalInfo;
import com.davidedalsanto.Lezione3.beans.Dog;

@Configuration
@PropertySource("classpath:application.properties")
public class Conf2 {

	@Bean
	public Dog dog1() {
		Dog d = new Dog();
		d.setName("Mauro");
		//d.setAnimalInfo(dog1ai());
		
		return d;
	}
	
	@Bean
	//@Qualifier("ai1")
	public AnimalInfo dog1ai() {
		return new AnimalInfo("Dogo", 500);
	}
	
	@Bean
	//@Qualifier("ai2")
	@Primary
	public AnimalInfo dog1ai2() {
		return new AnimalInfo("Maltese", 90000);
	}
	
	@Bean
	public Dog dog2() {
		return new Dog();
	}
	
}
