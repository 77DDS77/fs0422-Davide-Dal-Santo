package multithreading;

public class Ex3 {

	public static void main(String[] args) {
		
		Dog d1 = new Dog();
		Dog d2 = new Dog();
		
		Thread t1 = new Thread(d1, "tread_a");
		Thread t2 = new Thread(d2, "tread_b");
		
		t1.start();
		t2.start();

	}

}


class Animal {
	public void verso() {
		System.out.println("Verso");
	}
}

class Dog extends Animal implements Runnable{

	@Override
	public void run() {
		for(int i =1; i<= 10 ; i++) {
			System.out.println("id: " + Thread.currentThread().getId() 
					+ " Name: " + Thread.currentThread().getName() + " " + i);
			
		}
		
	}
	
}