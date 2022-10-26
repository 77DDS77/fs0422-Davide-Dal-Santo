package com.davidedalsanto.Lezione3.beans;

import static org.junit.Assert.*;

import org.junit.Test;

public class DogTest {

	@Test
	public void test() {
		
		Dog dt = new Dog();
		AnimalInfo ai = new AnimalInfo("Staffie", 110);
		dt.setAnimalInfo(ai);
		dt.setName("Mirco");
		
		assertTrue("CONTROLLO PREZZO > 100: ", 
				dt.getAnimalInfo().getPrice() > 100);
		
	}

}
