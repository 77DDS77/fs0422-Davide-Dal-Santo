package config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import models.Item;
import models.Ordine;
import models.PizzaHawaiian;
import models.PizzaMargherita;
import models.StatoOrdine;
import models.Tavolo;

@Configuration
@PropertySource("classpath:application.properties")
public class Config {
	
	Tavolo t = new Tavolo(1, 5, false);
	List<Item> elementi = new ArrayList<>();
	
	@Value("${costoPerCoperto}")
	double coperto;
	
	@Bean
	public Ordine getOrdine() {
		elementi.add(new PizzaHawaiian());
		elementi.add(new PizzaMargherita());
		return new Ordine(1, StatoOrdine.INCORSO, 5, t, elementi, coperto);
	}
}
