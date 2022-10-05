package multithreading;

public class Ex1 {

	public static void main(String[] args) {
		
		C1 c1 = new C1();
		C1 c2 = new C1();

		c1.start();
		c2.start();
		
		System.out.println(Thread.currentThread().getName());
		
	}

}


class C1{
	
	public void start() {
		for(int i =1; i<= 10 ; i++) {
			System.out.println(i);
		}
	}
}