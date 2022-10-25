package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.Config;
import models.Item;
import models.Menu;
import models.Ordine;
import models.PizzaHawaiian;
import models.PizzaMargherita;
import models.Tavolo;

@SpringBootApplication
public class GodfathersPizzaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GodfathersPizzaApplication.class, args);
		
		System.out.print("Hello world");
		
		
		Menu m = new Menu("M1");
		
		Tavolo t1 = new Tavolo(1, 5, false);
		
		List<Item> odineElementi = new ArrayList<>(List.of(new PizzaMargherita(), new PizzaHawaiian()));
		
		//Ordine o1 = new Ordine(1, StatoOrdine.INCORSO, 5, t1, odineElementi);
		
		
		System.out.println(m);
		
		config1();
	}

    public static void config1() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class); 
        
        System.out.println("----------------------------------------------");
        
        Ordine o1 = ac.getBean("getOrdine", Ordine.class);
        System.out.println("ordine dal carello "+o1);

        ((AnnotationConfigApplicationContext)ac).close();
    }
	
}
