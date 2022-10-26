package com.davidedalsanto.Lezione3.beans;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.davidedalsanto.Lezione3.classes.Box;

/*
 * Parametrizzare test
 * */


@RunWith(Parameterized.class)
public class BoxTest {

	private int a, b, c;
	
	public BoxTest(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	@Parameters
	public static Collection params() {
		return Arrays.asList(new Object[][] {
			{25, 5, 5},// ok
			{10, 5, 2},// ok
			{16, 8, 3},// no
			{76, 8, 2} // no
		});
	}
	
	@Test
	public void test() {
		Box b1 = new Box(b,c);
		
		assertEquals(a, b1.area());
	}

}
