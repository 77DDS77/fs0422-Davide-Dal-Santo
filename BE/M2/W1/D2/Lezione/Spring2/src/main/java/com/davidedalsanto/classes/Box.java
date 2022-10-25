package com.davidedalsanto.classes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Box {
	private int x;
	private int y;
	private String name;
	
	
	public Box(int x, int y, String name) {
		this.x = x;
		this.y = y;
		this.name = name;
	}
	
	public int area() {
		return x*y;
	}
	
	public String ucName() {
		return name.toUpperCase();
	}
	
	
}
