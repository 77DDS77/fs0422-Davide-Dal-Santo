package com.davidedalsanto.Lezione3.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Box {
	
	private int width;
	private int height;
	
	public int area() {
		return width * height;
	}
}
