package lezione;
import java.util.*;

public class ArrayListe {

	public static void main(String[] args) {
		
		ArrayList<String> words = new ArrayList<>();
		
		words.add("primo");
		words.add("secondo");
		words.add("terzo");
		
		System.out.println(words);
		
		System.out.println(words.get(2));
		
		words.remove(0);
		
		System.out.println(words);
		
		
		System.out.println("------------------------");
		
		
		Person p1 = new Person("Mario", 24);
		Person p2 = new Person("Piero", 41);
		
		System.out.println(words.contains("primo")); // true
		
		ArrayList<Person> people = new ArrayList<>();
		
		people.add(p1);
		people.add(p2);
		
		ArrayList<Person> peopleClone = (ArrayList<Person>)people.clone();
		
		System.out.println(people.equals(peopleClone)); //true
		
		System.out.println(people.contains(p1)); //true
		
		
		System.out.println("------------------------");
		
		
		ArrayList<Integer> numbers = new ArrayList<>();
		
		numbers.add(12);
		numbers.add(51);
		numbers.add(783);
		numbers.add(562);
		
		System.out.println(numbers);
		numbers.remove(3);
		System.out.println(numbers);
		numbers.remove((Integer)12);
		System.out.println(numbers);


		System.out.println("------------------------");
		
		
		ArrayList< ArrayList<String> > arrDiArr = new ArrayList<>();
		
		arrDiArr.add(new ArrayList<>(Arrays.asList("red", "blue", "Green")));
		arrDiArr.add(new ArrayList<>(Arrays.asList("black", "white", "yellow")));
		arrDiArr.add(new ArrayList<>(Arrays.asList("red", "blue", "Green")));
		System.out.println(arrDiArr);
		
		for(int i = 0; i< arrDiArr.size(); i++) {
			System.out.print("Riga "+ (i+1));
			
			for(int j = 0; j < arrDiArr.get(i).size(); j++) {
				System.out.print(arrDiArr.get(i).get(j) + " ");
			}
			System.out.println();
		}
		
	}


}


class Person{
	
	String name;
	int age;
	
	Person(String n, int a){
		this.name = n;
		this.age = a;
	}
	
	@Override
	public String toString() {
		return this.name + " " + this.age;
	}
	
	@Override
	public boolean equals(Object obj){
		Person p = (Person)obj;
		return this.name.equals(p.name) && this.age == p.age;
	}
}














