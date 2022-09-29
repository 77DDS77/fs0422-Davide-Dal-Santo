package Animals;

public class Animal {
	
	protected String name;
	protected int age;
	
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void sayHi() {
		System.out.println("Hi I'm an animal");
	}
	
	public static void getAnimal(Animal a) {
		System.out.println(a);
	}
	
	//overrido il toString della classe Object
	// facendo questo se chiedo di printare un 
	//animal lo fara' con il formato che do io
	@Override
	public String toString() {
		return "Ciao sono un animale " 
				+ this.name;
	}

}
