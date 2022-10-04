package lezione;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Sorted {
	public static void main(String[] args) {
		
		ArrayList<String> words =
				new ArrayList<>(Arrays.asList(
						"albero", "mela", "epicode", "java"));
		
		
		Collections.sort(words, new StringLengthComparator());
		System.out.println(words);
		
		System.out.println("--------------");
		
		ArrayList<Person> people = new ArrayList<>(
				Arrays.asList(new Person("Mario", 30),
						new Person("Piero", 53),
						new Person("Alberto", 14)
						));
		
		System.out.println("pre ordinamento: " + people);
		Collections.sort(people, new PersonComparator());
		System.out.println("post ordinamento: " + people);
		
		Collections.sort(people, new PersonComparator() {
			@Override
			public int compare(Person o1, Person o2) {
				return super.compare(o1, o2) * -1;
			}
		});
		System.out.println("post override on the go: " + people);
		
		
		System.out.println("--------------");
	}
}


class StringLengthComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		
		int o1l = o1.length();
		int o2l = o2.length();
		
		if(o1l > o2l) return 1;
		else if(o1l < o2l) return -1;
		
		return 0;
	}
	
}

class PersonComparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		
		if(o1.age > o2.age) return 1;
		else if(o1.age < o2.age) return -1;
		
		return 0;
	}
	
}