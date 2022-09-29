package D4;

public class ex1 {

	public static void main(String[] args) {

		Student studente1 = new Student();
		
		studente1.setAge(25);
		studente1.setName("Davide");
		
		System.out.println(studente1.getName() + " " + studente1.getAge());
		
		Student s2 = new Student("Mario", 65);
		
		s2.setAge(32);
		
		System.out.println(s2.getName() + " " + s2.getAge());

		//settare il gender con l'enum
		Student s3 = new Student("Pippo", 12, studentGender.M, "Franco");
	}

}
