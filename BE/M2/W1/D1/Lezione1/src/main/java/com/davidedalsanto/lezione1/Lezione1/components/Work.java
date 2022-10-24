package com.davidedalsanto.lezione1.Lezione1.components;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class Work {
	
	private String name;
	private double salary;

	public abstract void hello();
}
