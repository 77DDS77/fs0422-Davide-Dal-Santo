package models.models_s3;

import javax.persistence.Entity;

@Entity
public class S3_C2 extends S3_C1{
	
	private String f3;
	
	public S3_C2() {}

	public S3_C2(String f1, String f2, String f3) {
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
