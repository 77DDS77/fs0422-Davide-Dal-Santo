package com.davidedalsanto.Lezione3;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.davidedalsanto.Lezione3.beans.Dog;
import com.davidedalsanto.Lezione3.classes.Person;
import com.davidedalsanto.Lezione3.components.School;
import com.davidedalsanto.Lezione3.config.Conf2;

@SpringBootApplication
public class Lezione3Application {

	public static void main(String[] args) {
		SpringApplication.run(Lezione3Application.class, args);

		//config1();
		//config2();
		//el1();
		//el2();
		//el3();
		config3();
	}

	public static void config1() {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.davidedalsanto.Lezione3.components");
		ctx.refresh();

		School s = ctx.getBean("sc", School.class);
		System.out.println(s);

		ctx.close();
	}

	public static void config2() {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Conf2.class);
		
		Dog d1 = ctx.getBean("dog1", Dog.class);
		System.out.println("D1: " + d1);

		ctx.close();
	}
	
	public static void el1() {
		ExpressionParser parser = new SpelExpressionParser();
		Expression e1 = parser
				.parseExpression("'ciao sono un corso Java'.toUpperCase()");
		String s1 = (String)e1.getValue();
		System.out.println(s1);
	}
	
	public static void el2() {
		ExpressionParser parser = new SpelExpressionParser();
		Expression e1 = parser
				.parseExpression("10*5");
		int s1 = (int)e1.getValue();
		System.out.println(s1);
	}
	
	public static void el3() {
		ExpressionParser parser = new SpelExpressionParser();
		Expression e1 = parser
				.parseExpression("'javascript'.length() == 11");
		boolean s1 = (boolean)e1.getValue();
		System.out.println(s1);
	}
	
	//COSE CON XML(Person e Address
	public static void config3() {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("beans.xml");
		
		Person p1 = ctx.getBean("person1", Person.class);
		System.out.println(p1);
		
		ctx.close();
	}
}






