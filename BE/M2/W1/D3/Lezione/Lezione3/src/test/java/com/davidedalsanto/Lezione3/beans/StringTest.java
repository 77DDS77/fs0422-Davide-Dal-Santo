package com.davidedalsanto.Lezione3.beans;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.davidedalsanto.Lezione3.classes.StringOperations;

@RunWith(Parameterized.class)
public class StringTest {
	
	private String str;
	private int l;
	
	public StringTest(String str, int l) {
		super();
		this.str = str;
		this.l = l;
	}

	@Parameters
	public static Collection params() {
		return Arrays.asList(new Object[][] {
			{"ciao", 8},// ok
			{"Mario", 10},// ok
			{"Popi", 3},// no
			{"Enrico maggico", 12}, // no
			{"Enrico non maggico", 12} // no
		});
	}

	@Test
	public void test() {
		StringOperations so = new StringOperations(str);
		
		assertEquals(l, so.getLength());
	}

}
