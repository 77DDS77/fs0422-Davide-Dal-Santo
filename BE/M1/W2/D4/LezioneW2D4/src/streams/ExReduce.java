package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExReduce {

	public static void main(String[] args) {
		
		List<Integer> nums = new ArrayList<>(Arrays.asList(5, 4, 7, 23, 10));
		
		System.out.println( 
				nums.stream()
				.reduce(0, (current, el) -> current + el) 
				);

		List<String> words =
				new ArrayList<>(Arrays.asList("mele", "pere", "Davide"));
		
		
		System.out.println(
				words.stream()
				.reduce("valore iniziale" , (current, el) -> current + " | " 
						+ el ) + " | end"
				);
		
		//syntax .collect(Collectors.joining(" | ", "**", "**"))
		//..joining("carattere divisore", "car iniziale", "car finale)
		System.out.println(
				words.stream()
				.collect(Collectors.joining(" | ", "**", "**"))
				);
	}

}
