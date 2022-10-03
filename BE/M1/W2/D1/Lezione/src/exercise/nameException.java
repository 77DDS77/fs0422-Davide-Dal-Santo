package exercise;

public class nameException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errName;

	public nameException(String msg, String eN) {
		super(msg);
		this.setErrName(eN);
	}

	public String getErrName() {
		return errName;
	}

	public void setErrName(String errName) {
		this.errName = errName;
	}
	
	
}
