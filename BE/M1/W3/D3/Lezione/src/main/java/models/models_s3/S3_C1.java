package models.models_s3;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class S3_C1 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String f1;
	private String f2;
	
	public S3_C1(){}

	public S3_C1(String f1, String f2) {
		super();
		this.f1 = f1;
		this.f2 = f2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getF1() {
		return f1;
	}

	public void setF1(String f1) {
		this.f1 = f1;
	}

	public String getF2() {
		return f2;
	}

	public void setF2(String f2) {
		this.f2 = f2;
	};
	
	
}
