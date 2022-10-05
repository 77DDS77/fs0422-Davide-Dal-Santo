package multithreading;

public class Ex4 {

	public static void main(String[] args) {
		
		
		ThreadBox2 tb = new ThreadBox2();
		Thread t1 = new Thread(tb, "thread-1");
		
		t1.start();
		
		for(int i = 1 ; i <= 10 ; i++) {
			System.out.println(i);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}


class ThreadBox2 implements Runnable{

	@Override
	public void run() {
		try {
			for(int i =1; i<= 10 ; i++) {
				System.out.println("id: " + Thread.currentThread().getId() 
						+ " Name: " + Thread.currentThread().getName() + " " + i);
				Thread.sleep(800);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		
	}
	
}