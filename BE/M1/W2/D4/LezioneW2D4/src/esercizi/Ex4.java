package esercizi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Ex4 {

	/*
	 * Ex 4 
	 * creare un arraylist di 10 numeri,
	 * trasformali in stream e stampa solo i numeri superiori a 20
	 */
	
	public static void main(String[] args) {
		
		List<Integer> nums = new ArrayList<>(Arrays.asList(10,20,30,24,54,12,9,79,123,1));
		
		//nums.stream().filter(n -> n > 20).forEach(System.out::println);
		 
		List<Integer> numMagg = nums.stream().filter(n -> n > 20).collect(Collectors.toCollection(LinkedList::new));
		
		System.out.println(numMagg);
		
		
		
		
	}

}
