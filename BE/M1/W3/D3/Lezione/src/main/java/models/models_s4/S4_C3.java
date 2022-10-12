package models.models_s4;

import javax.persistence.Entity;

@Entity
public class S4_C3 extends S4_C1{
	private String f4;
	
	public S4_C3() {}

	public S4_C3(String f1, String f2, String f4) {
		super(f1, f2);
		this.f4 = f4;
	}

	public String getF4() {
		return f4;
	}

	public void setF4(String f4) {
		this.f4 = f4;
	};
	
	
}
