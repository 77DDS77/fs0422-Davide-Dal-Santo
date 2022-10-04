package lezione;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Priority {

	public static void main(String[] args) {


		PriorityQueue<Integer> q1 = new PriorityQueue<>(10, new Q1Comparator());
		q1.add(124);
		q1.add(14);
		q1.add(5);
		q1.add(85);
		q1.add(144);
		
		System.out.println(q1);
		
		while(q1.size() != 0) {
			q1.poll();
		}
		
		System.out.println(q1);
	}

}

class Q1Comparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1 > o2) return 1;
		else if(o1 < o2) return -1;
		return 0;
	}
	
}