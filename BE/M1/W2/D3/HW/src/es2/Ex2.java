package es2;

import java.util.ArrayList;
import java.util.Random;

public class Ex2 {

	public static void main(String[] args) {

		int totSum;

		ArrayList<Integer> res = new ArrayList<>();
		
		Random rnd = new Random();
		
		for(int i = 0 ; i < 3000; i++) {
			res.add(rnd.nextInt(101));
		}
		
		MyThread t1 = new MyThread(0, res);
		MyThread t2 = new MyThread(1000, res);
		MyThread t3 = new MyThread(2000, res);
		
		/*
		Thread tr1 = new Thread(t1, "t1");
		Thread tr2 = new Thread(t2, "t2");
		Thread tr3 = new Thread(t3, "t3");
		
		tr1.start();
		tr2.start();
		tr3.start();
		
		System.out.println(t1.getSum() + " " + tr1.getName());
		System.out.println(t2.getSum() + " " + tr2.getName());
		System.out.println(t3.getSum() + " " + tr3.getName());
		*/
		
		t1.run();
		t2.run();
		t3.run();
		System.out.println( "Sum 1: " + t1.getSum() );
		System.out.println( "Sum 2: " + t2.getSum() );
		System.out.println( "Sum 3: " + t3.getSum() );
		
		try {
			t1.join();
			t2.join();
			t3.join();
			totSum = t1.getSum() + t2.getSum() + t3.getSum();
			System.out.println("Somma totale: " + totSum);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}


class MyThread extends Thread{
	
	int inizio;
	int fine;
	ArrayList<Integer> arr;
	int sum;

	public MyThread(int iniz, ArrayList<Integer> arr) {
		this.inizio = iniz;
		this.fine = this.inizio + 1000;
		this.arr = arr;
	}
	
	
	@Override
	public void run() {
		
		for(int i = this.inizio; i < this.fine ; i++) {
			this.sum += arr.get(i);
		}		
	}
	
	
	
	
	public int getSum() {
		return this.sum;
	}
}