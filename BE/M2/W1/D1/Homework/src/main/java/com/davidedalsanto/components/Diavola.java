package com.davidedalsanto.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class Diavola extends Pizza{
	
	private double prezzo = 6;
	
	private int calorie = 500;
	
	private List<String> toppings = new ArrayList<>(Arrays.asList("Salamino"));
}
