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
public abstract class Pizza {

	private List<String> base = 
			new ArrayList<>(Arrays.asList("Pomodoro", "Mozzarella"));
	
}
