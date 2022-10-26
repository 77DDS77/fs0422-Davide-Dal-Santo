package config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import models.Item;
import models.Ordine;
import models.Pizza;
import models.PizzaBase;
import models.PizzaHawaiian;
import models.PizzaMargherita;
import models.Prosciutto;
import models.StatoOrdine;
import models.Tavolo;

@Configuration
@PropertySource("classpath:application.properties")
public class Config {
	
	@Bean
	//@Scope("prototype")
	public Tavolo getTavolo() {
		return new Tavolo(1, 5, true);
	}
	
	@Value("${costoPerCoperto}")
	double coperto;
		
	@Bean
	@Scope("prototype")
	public Ordine getOrdine() {
		List<Item> elementi = new ArrayList<>();
		elementi.add(getPizzaHawaiian());
		elementi.add(getPizzaMargherita());
		return new Ordine(1, StatoOrdine.INCORSO, 5, getTavolo(), elementi, coperto);
	}
	
	@Bean
	@Scope("prototype")
	public PizzaHawaiian getPizzaHawaiian() {
		return new PizzaHawaiian();
	}
	
	@Bean
	@Scope("prototype")
	public PizzaMargherita getPizzaMargherita() {
		return new PizzaMargherita();
	}
	
	@Bean
	@Scope("prototype")
	public PizzaBase getPizza() {
		return new PizzaBase();
	}
	
	//===============
	
	@Bean
	public Prosciutto getProsciutto() {
		return new Prosciutto();
	}
	
	@Bean
	@Scope("prototype")
	public Pizza getPizzaProsciutto() {
		Pizza p = getPizza();
		p.setNome("Prosciuttina");
		p.setCalorie(300d);
		p.setPrezzo(6.5d);
		p.setFamilySize(false);
		p.addTopping(getProsciutto());
		return p;
	}
}
