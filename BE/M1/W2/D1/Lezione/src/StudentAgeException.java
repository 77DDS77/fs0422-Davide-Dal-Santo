
public class StudentAgeException extends RuntimeException{

	public StudentAgeException(String msg) {
		super(msg);
		System.out.println("operazioni interne...");
	}
}
