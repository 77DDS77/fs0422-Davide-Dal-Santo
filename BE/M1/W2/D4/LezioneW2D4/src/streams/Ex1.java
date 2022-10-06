package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ex1 {

	public static void main(String[] args) {
		
		//generazione stream a partire da array nativo
		Stream<String> s1 = Arrays.stream(
				new String[] {"prima parola", "seconda parola", "terza parola"}
				);

		s1.forEach(System.out::println);
		
		sep();
		
		//generazione stram tramite stream builder
		Stream<String> s2 = Stream.<String>builder()
					.add("Epicode")
					.add("java")
					.add("cose")
					.build();
		
		s2.forEach(( el ) -> System.out.println( el ));
		
		sep();
		
		//generazione tramite generate
		Stream.generate( () -> "elemento" )
		.limit(3)
		.forEach( el -> System.out.println(el));
		
		sep();
		
		Stream.iterate(1, n -> n+1)
		.limit(10)
		.forEach(System.out::println);
		
		sep();
		
		//generazione tramite lista
		List<String> words = new ArrayList<>();
		Stream<String> s3 = words.stream();
		s3.forEach( s -> System.out.println("el: " + s));
		
		sep();
		
		
		
	}

	static void sep() {
		System.out.println("--------------");
	}
}

class Student{
	String name;
	int[] votes;
	
	Student(String name, int[] votes){
		this.name = name;
		this.votes = votes;
	}
	
	double getAvg() {
		double sum = 0;
		for(int i = 0; i < this.votes.length; i++) {
			sum += this.votes[i];
		}
		return sum/this.votes.length;
	}
	
}
















