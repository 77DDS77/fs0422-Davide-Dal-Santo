package com.BEBW2.ES.EnergyService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {
		"com.BEBW2.ES.EnergyService",
		"com.BEBW2.ES.EnergyService.*"
})
public class EnergyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnergyServiceApplication.class, args);
		System.out.println("CHIEDIMI SE SONO FELICE");

	}

}
