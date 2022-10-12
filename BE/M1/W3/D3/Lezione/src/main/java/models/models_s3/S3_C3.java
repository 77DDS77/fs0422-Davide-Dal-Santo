package models.models_s3;

import javax.persistence.Entity;

@Entity
public class S3_C3 extends S3_C1{
	private String f4;
	
	public S3_C3() {}

	public S3_C3(String f1, String f2, String f4) {
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
