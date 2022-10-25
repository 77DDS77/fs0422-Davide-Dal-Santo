package com.davidedalsanto.classes;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class CalcTest {

	Calc c = new Calc();

	@Test
	public void testSum() {
		assertEquals("La somma dovrebbe essere 10", c.sum(5, 5), 10);
	}

	@Test
	//@Ignore
	public void testDiff() {
		assertEquals("La Differenza dovrebbe essere 10", c.diff(5, 4), 10);
	}

	@Test
	public void test1() {
		String s = "ciao";
		String s2 = "ciao";

		assertSame("Senza costruttore dovrebbero essere identici", s, s2);
	}

	@Test
	//@Ignore
	public void test2() {
		String s = new String("ciao");
		String s2 = new String("ciao");

		// falso
		assertSame("Con il costruttore dovrebbero essere identici", s, s2);
	}

}
