package com.davidedalsanto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.davidedalsanto.components.Diavola;
import com.davidedalsanto.components.Pizza;
import com.davidedalsanto.components.ProsciuttoFunghi;

@Configuration
public class Config {

	@Bean
	public Diavola makeDiavola() {
		return new Diavola();
	}
	
	@Bean
	public Pizza makePF() {
		return new ProsciuttoFunghi();
	}
	
}
