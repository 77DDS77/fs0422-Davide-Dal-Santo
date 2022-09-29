package D4;

public class Student {

	private String name;
	private int age;
	
	private studentGender gender;
	private String lastname;
	
	public Student() {
		
	}
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Student(String name, int age, studentGender gender, String lastname) {
		//questo this == Student(String name, int age)
		// fa riferimento al costruttore con due parametri
		//DEVE ESERE LA PRIMA ISTRUZIOEN DEL COSTRUTTORE
		this(name, age);
		
		this.setGender(gender);
		this.setLastname(lastname);
	}
	
	/*
	 * private, non  raggiungibili dall'esterno quindi: getter/setter
	 * 
	 * con getter e setter posso far modificare
	 *  dall'esterno le mie proprieta' private
	 */
	
	
	//getter:
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	//setter:
	public void setAge(int n) {
		if(n > 0 && n < 120) {
			this.age = n;
		}else {
			this.printError("Anno fuori campo");
		}
	}
	
	public void setName(String n) {
		if(n.length() > 0) {			
			this.name = n;
		}else {
			this.printError("Nome troppo corto");
		}
	}
	
	public void setGender(studentGender g) {
		this.gender = g;
	}
	
	public void setLastname(String ln) {
		if(ln.length() > 0) {			
			this.lastname = ln;
		}else {
			this.printError("Cognome troppo corto");
		}
	}
	
	//metodi:
	
	//public perche' metodo di utility, voglio che sia
	//usato all'esterno
	public void sayHello() {
		System.out.println("Ciao sono, " + this.name);
	}
	
	//private, non voglio che sia usato 
	//al di fuori di questa classe
	private void printError(String msg) {
		System.out.println(msg);
	}
	
	//
	
	
	
	
	
	
	
	
}
