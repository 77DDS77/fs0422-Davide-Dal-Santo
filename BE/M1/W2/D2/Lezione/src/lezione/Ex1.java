package lezione;

public class Ex1 {

	public static void main(String[] args) {
		
		Animal an1 = new Dog();
		Dog d1 = new Dog();
		
		an1.corri(); //dog corri
		//an1.poop(); //non lo prende perche an1 e' Animal
		d1.poop();

	}

}

class Animal{
	public void corri() {
		System.out.println("animal corri");
	}
}

class Dog extends Animal{
	public void corri() {
		System.out.println("dog corri");
	}
	
	public void poop() {
		System.out.println("pooping");
	}
}