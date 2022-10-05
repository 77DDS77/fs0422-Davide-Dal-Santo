package es1;

public class Ex1 {

	public static void main(String[] args) {
		
		MyThread t1 = new MyThread("#");
		MyThread t2 = new MyThread("*");
		
		Thread tr1 = new Thread(t1);
		Thread tr2 = new Thread(t2);
		
		tr1.start();
		tr2.start();
		
	}

}


class MyThread implements Runnable{

	String simbolo;
	
	public MyThread(String simbolo) {
		this.simbolo = simbolo;
	}
	
	
	@Override
	public void run() {
		for(int i = 0; i <10 ; i++) {
			System.out.println(simbolo);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}