package com.davidedalsanto.classes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class BoxTest {
	
	Box b = new Box();
	
	@Before
	public void beforeAllTests() {
		b.setX(6);
		b.setY(2);
		b.setName("scatola");
	}

	@Test
	public void testArea() {
		System.out.println("ciao");
		assertEquals("L'area dovrebbe essere 12", b.area(), 20);
	}

	@Test
	public void testName() {
		assertEquals("Il nome doverebbe essere SCATOLA", b.ucName(), "SCATOLA");
	}
}
