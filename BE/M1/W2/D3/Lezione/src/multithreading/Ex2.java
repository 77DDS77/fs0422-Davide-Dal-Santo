package multithreading;

public class Ex2 {

	public static void main(String[] args) {

		ThreadBox t1 = new ThreadBox();
		ThreadBox t2 = new ThreadBox();
		ThreadBox t3 = new ThreadBox();

		t1.start();
		t2.start();
		t3.start();
	}

}


class ThreadBox extends Thread{
	
	@Override
	public void run() {
		for(int i =1; i<= 10 ; i++) {
			System.out.println("id: " + Thread.currentThread().getId() 
					+ " Name: " + Thread.currentThread().getName() + " " + i);
		}
	}
}