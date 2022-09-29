package Animals;

public class Ex2 {

	public static void main(String[] args) {
		
		Animal animale1 = new Animal("Animale", 10);
		Dog dog1 = new Dog("Cane", 8, "Lab");
		Cat cat1 = new Cat("Gatto", 4, "nero");
		
		
		animale1.sayHi();
		dog1.sayHi();
		
		//poliomorfismo
		/*
		 * posso raggruppare piu oggetti di classe diverse
		 * a patto che appartengano alla stessa
		 * superclasse
		 */
		Animal[] animali = {animale1, dog1, cat1};
		
		for(Animal anim : animali) {
			polyMethod(anim);
		}
		
		Animal.getAnimal(animale1);
		Animal.getAnimal(dog1);
		Animal.getAnimal(cat1);
			
	}

	//polimorfismo su metodi
	public static void polyMethod(Animal a) {
		System.out.println(a.name);
	}
	
	
}
