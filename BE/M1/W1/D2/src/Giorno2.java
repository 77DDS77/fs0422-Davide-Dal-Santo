
import java.util.Arrays;

public class Giorno2 {

	public static void main(String[] args) {

		// creazioen studente
		Student s1 = new Student();

		s1.name = "Davide";
		s1.lastname = "Dal Santo";
		s1.age = 25;
		s1.id = 1;
		s1.votes = new byte[] { 8, 10, 6, 1 };

		s1.sayHello2();

		System.out.println("-----------------------");
		System.out.println(s1.name + " " + s1.lastname);
		System.out.println(Arrays.toString(s1.votes));

		
		Student s2 = new Student("M", "Rossi", 100, new byte[] { 6, 9, 7, 10 });
		s2.sayHello2();
		
		System.out.println(s1.school);
		
		Student s3 = new Student("Mirco", "Paoli", 23, new byte[] { 6, 9, 7, 10 });
		Student s4 = new Student("Mirco", "Paoli", 23, new byte[] { 6, 9, 7, 10 });
		
		//ho definito io .equals per la classe student
		System.out.println(s3.equals(s4));
	}

}

/*
 * Non sto usando modificatori di visibilita' perche' sto usando quello
 * implicito secondo il quale la classe studente e' visibile all'interno di
 * tutto il package
 */
//classe
class Student {

	// attributi
	String name;
	String lastname;
	int age;
	int id;
	byte[] votes;
	
	private static int internalId = 1;
	
		//settare una proprieta' con un valore di default;
	static String school = "Epicode";
	
	//costruttorI
	//posso avere piu di un costruttore, ad esempio quello vuoto se voglio settare io i
	//valori dello studente in un secondo momento
	
	//costruttore vuoto
	Student(){};
	
	//costruttore con parametri
	Student(String name, String lastname, int age, byte[] votes){
		
		this.setId();
		
		if(checkStringLength(name, 2)) {
			this.name = name;
		}else {
			 printError("Nome", name, " e' troppo corto");
		}
		
		if(checkStringLength(lastname, 2)) {
			this.lastname = lastname;
		}else {
			printError("Cognome", lastname, " e' troppo corto");
		}
		
		if(checkAge(age, 22, 90)) {
			this.age = age;
		}else {
			printError("Eta'", ""+age, " fuori dal range consentito");
		}
		
		this.votes = votes;
	}
	
	//metodi interni
	//private perche voglio che possano essere utilizzate solo
	//all'interno della classe e non, ad esempio, dalle istanze
	private boolean checkStringLength(String s, int i) {
		return ( s.length() >= i) ? true : false;
	}
	
	private void printError(String field,String realField, String message) {
		System.out.println("Warning: " + field + message + "! (" + realField + ") ");
	}
	
	private boolean checkAge(int a, int left, int right) {
		return (a >= left && a <= right) ? true : false;
	}
	
	private void setId() {
		this.id = this.internalId++;
	}
	
	

	// metodi
	void sayHello() {
		// posso omettere il this. quando vado a prendere proprieta' della classe
		// - A discrezione del mio stile di porgrammazione
		System.out.println("Hi, I'm a student! Mi chiamo " + name + " " + this.lastname);
	}

	void sayHello2() {
		System.out.printf("Hi, I'm a student! Mi chiamo %s %s (ho %d anni) e i mie voti sono: %s %n", this.name,
				this.lastname, this.age, Arrays.toString(this.votes));
		/*
		 * for(int i = 0; i < this.votes.length; i++) { System.out.println("voto " +
		 * (i+1) + ": " + this.votes[i]); }
		 */

	}
	
	//override con la chiocciola dico,
	//"questo metodo e' una sovrascrittura del metodo equals"
	@Override
	public boolean equals(Object obj) {
		Student another = (Student)obj;
		return (
				this.name.equals(another.name) &&
				this.lastname.equals(another.lastname) &&
				this.age == another.age
				) ? true : false;
	}
	

}