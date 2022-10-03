
public class StudentMaker {
	
	public static Student make(String n, int a) {
		if( n.length() < 2) {
			throw new StudentNameException("Nome troppo corto");
		}
		else if(a < 1 || a > 100) {
			throw new StudentAgeException("Eta non valida");
		}
		
		return new Student(n, a);
	}
	
}
