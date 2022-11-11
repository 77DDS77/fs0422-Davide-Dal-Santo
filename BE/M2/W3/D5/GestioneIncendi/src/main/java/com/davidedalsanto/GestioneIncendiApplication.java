package com.davidedalsanto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.davidedalsanto.models.ControlCenter;
import com.davidedalsanto.models.SmokeDetector;

@SpringBootApplication
public class GestioneIncendiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestioneIncendiApplication.class, args);
		
		ControlCenter cc = new ControlCenter();
		
		//(id lat, long, smoke level)
		SmokeDetector sm1 = new SmokeDetector(1L, 22.7, 18.4, 0);
		sm1.addObserver(cc);
		
		sm1.detectFire();
		sm1.setSmokeLevel(4);
		sm1.detectFire();
		sm1.setSmokeLevel(6);
		sm1.detectFire();

	}

}
