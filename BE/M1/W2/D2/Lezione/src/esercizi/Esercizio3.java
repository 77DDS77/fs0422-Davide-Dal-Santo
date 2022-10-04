package esercizi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Esercizio3 {

	public static void main(String[] args) {
		
		Item i1 = new Item("Davide", new ArrayList<>( Arrays.asList(1, 3, 5, 6)));
		Item i2 = new Item("Mario", new ArrayList<>( Arrays.asList(5, 7, 5, 8)));
		Item i3 = new Item("Mirco", new ArrayList<>( Arrays.asList(14, 632, 23, 63)));
		Item i4 = new Item("Piero", new ArrayList<>( Arrays.asList(76, 435 ,1, 645)));
		Item i5 = new Item("Luca", new ArrayList<>( Arrays.asList(76,32, 643,8)));
		
		PriorityQueue<Item> pq1 = new PriorityQueue<>(new QueueClear());
		
		pq1.add(i1);
		pq1.add(i2);
		pq1.add(i3);
		pq1.add(i4);
		pq1.add(i5);
				
		while(pq1.size() > 0) {
			System.out.println(pq1.poll());
			System.out.println(pq1);
		}
				
	}
	
}

class QueueClear implements Comparator<Item> {
	
	@Override
	public int compare(Item x, Item y) {
		return x.getBestValue() - y.getBestValue();
	}

}
