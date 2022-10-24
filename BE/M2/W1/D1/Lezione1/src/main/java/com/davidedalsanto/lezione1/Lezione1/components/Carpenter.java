package com.davidedalsanto.lezione1.Lezione1.components;

public class Carpenter extends Work{
	{
		setName("Carpentiere");
		setSalary(1500);
	}

	@Override
	public void hello() {
		System.out.println("sono un carpentiere");
		
	}

}
