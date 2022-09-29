package Animals;

public class Cat extends Animal {
	
	private String color;

	public Cat(String name, int age, String color) {
		super(name, age);
		this.setColor(color);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
