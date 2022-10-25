package com.davidedalsanto;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.davidedalsanto.classes.Calc;
import com.davidedalsanto.classes.CalcTest;

@SpringBootApplication
public class Spring2Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring2Application.class, args);
		
		calcTest();
		
	}
	
	public static void calcTest() {
		Result r = JUnitCore.runClasses(CalcTest.class);
		
		for(Failure f : r.getFailures()) {
			System.out.println(f);
		}
		
		System.out.println("Tutti i test sono passati? " + r.wasSuccessful());
	}

}
