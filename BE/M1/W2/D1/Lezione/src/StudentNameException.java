
public class StudentNameException extends RuntimeException {

	public StudentNameException(String msg) {
		super(msg);
		System.out.println("operazioni interne...");
	}
}
