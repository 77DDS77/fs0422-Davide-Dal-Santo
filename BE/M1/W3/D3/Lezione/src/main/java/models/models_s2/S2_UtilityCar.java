package models.models_s2;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class S2_UtilityCar extends S2_Car{

	@Column(name = "for_family")
	private boolean forFamily;
	
	@Column(name = "comfort_lvl")
	private int comfortLevel;
	
	public S2_UtilityCar() {}

	public S2_UtilityCar(String name, String brand, boolean ff, int cl) {
		super(name, brand);
		this.forFamily = ff;
		this.comfortLevel = cl;
	}

	public boolean isForFamily() {
		return forFamily;
	}

	public void setForFamily(boolean forFamily) {
		this.forFamily = forFamily;
	}

	public int getComfortLevel() {
		return comfortLevel;
	}

	public void setComfortLevel(int comfortLevel) {
		this.comfortLevel = comfortLevel;
	};
	
	
}
