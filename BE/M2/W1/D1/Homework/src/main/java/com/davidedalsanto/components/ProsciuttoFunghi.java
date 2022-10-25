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
public class ProsciuttoFunghi extends Pizza{
	
	private double prezzo = 8;
	
	private int calorie = 900;
	
	private List<String> toppings = new ArrayList<>(Arrays.asList("Prosciutto", "Funghi"));
}
