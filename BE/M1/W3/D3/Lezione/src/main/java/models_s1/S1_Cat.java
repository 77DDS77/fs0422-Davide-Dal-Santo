package models_s1;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MyCat")
public class S1_Cat extends S1_animal{
	
	private int jumpHeight;
	
	public S1_Cat() {}

	public S1_Cat(String name, int age, int jh) {
		super(name, age);
		this.setJumpHeight(jh);
	}

	public int getJumpHeight() {
		return jumpHeight;
	}

	public void setJumpHeight(int jumpHeight) {
		this.jumpHeight = jumpHeight;
	};
	
	
}
