package models.models_s4;

import javax.persistence.Entity;

@Entity
public class S4_C2 extends S4_C1{
	
	private String f3;
	
	public S4_C2() {}

	public S4_C2(String f1, String f2, String f3) {
		super(f1, f2);
		this.f3 = f3;
	}

	public String getF3() {
		return f3;
	}

	public void setF3(String f3) {
		this.f3 = f3;
	};
	
	
}
