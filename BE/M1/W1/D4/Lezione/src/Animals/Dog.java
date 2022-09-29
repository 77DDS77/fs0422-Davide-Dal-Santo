package Animals;

public class Dog extends Animal {
	
	private String race;

	public Dog(String name, int age, String race) {
		super(name, age);
		this.setRace(race);
	}

	//se una proprieta' e' private devo avere
	// getter e setter
	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	@Override
	public void sayHi() {
		System.out.println("Hi I'm a Dog!");
	}
}
