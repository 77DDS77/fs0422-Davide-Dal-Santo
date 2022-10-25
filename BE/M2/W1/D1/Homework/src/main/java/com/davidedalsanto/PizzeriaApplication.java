package com.davidedalsanto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.davidedalsanto.components.Diavola;
import com.davidedalsanto.components.Pizza;
import com.davidedalsanto.components.ProsciuttoFunghi;
import com.davidedalsanto.config.Config;


@SpringBootApplication
public class PizzeriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzeriaApplication.class, args);
	
		List<Pizza> menu = test();
		for(Pizza p : menu) {
			System.out.println(p);
		}
	}
	
	private static List<Pizza> test() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		
		/*
		 * Student s1 = ctx.getBean("getStudent", Student.class);
			System.out.println(s1);
		 * */
		
		List<Pizza> menu = new ArrayList<>();
		
		Pizza diav = ctx.getBean("makeDiavola", Diavola.class);
		menu.add(diav);
		
		Pizza pf = ctx.getBean("makePF", ProsciuttoFunghi.class);
		menu.add(pf);
		
		((AnnotationConfigApplicationContext)ctx).close();
		
		return menu;
	}

}
