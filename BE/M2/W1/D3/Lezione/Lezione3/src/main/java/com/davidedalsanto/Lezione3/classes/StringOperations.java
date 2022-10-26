package com.davidedalsanto.Lezione3.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StringOperations {

	private String str;
	
	public int getLength() {
		return str.length()*2;
	}
}
