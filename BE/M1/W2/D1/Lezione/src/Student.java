
public class Student {

	private String name;
	private int age;
	
	public Student(String n, int a) {
		setName(n);
		setAge(a);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getDescrption() {
		return "nome:" + this.name + " eta': " + this.age;
	}
	
}
