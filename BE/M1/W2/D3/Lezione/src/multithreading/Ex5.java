package multithreading;

public class Ex5 {

	public static void main(String[] args) {

		/*
		Counter c1 = new Counter();
		
		ThreadBox3 tb1 = new ThreadBox3("A", c1);
		ThreadBox3 tb2 = new ThreadBox3("B", c1);

		tb1.start();
		tb2.start();
		*/
		
		ThreadBox4 tb3 = new ThreadBox4("C");
		ThreadBox4 tb4 = new ThreadBox4("D");
		
		tb3.start();
		tb4.start();
		
	}

}

class Counter{
	
	private int count = 1;
	
	synchronized public void increaseCount(String tn) {
		for (int i = 1 ; i< 10 ; i++) {
			System.out.println(this.count + " " + tn);
			this.count++;
		}
	}
	
}


class ThreadBox3 extends Thread{
	
	Counter counter;
	String name;
	
	ThreadBox3(String name, Counter counter){
		this.name = name;
		this.counter = counter;
	}
	
	@Override
	public void run() {
		this.counter.increaseCount(this.name);
	}
	
	
}


class Counter2{
	
	private static int count = 1;
	
	synchronized static public void increaseCount(String tn) {
		for (int i = 1 ; i< 10 ; i++) {
			System.out.println(count + " " + tn);
			count++;
		}
	}
	
}

class ThreadBox4 extends Thread{
	
	Counter counter;
	String name;
	
	ThreadBox4(String name){
		this.name = name;

	}
	
	@Override
	public void run() {
		Counter2.increaseCount(this.name);
	}
	
	
}


