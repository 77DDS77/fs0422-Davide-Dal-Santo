package models.models_s2;

import javax.persistence.Entity;

@Entity
public class S2_FastCar extends S2_Car{

	private double speed;
	
	private double acceleration;
	
	public S2_FastCar() {};
	
	public S2_FastCar(String name, String brand, double speed, double acceleration) {
		super(name, brand);
		this.speed = speed;
		this.acceleration = acceleration;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(double acceleration) {
		this.acceleration = acceleration;
	}
	
	
}
