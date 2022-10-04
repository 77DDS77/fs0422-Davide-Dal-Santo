package lezione;

import java.util.LinkedList;

public class LinkedListe {

	public static void main(String[] args) {
		
		LinkedList<String> l1 = new LinkedList<>();
		
		
		l1.add("primo");
		l1.add("secondo");
		l1.add("terzo");
		
		l1.addFirst("primissimo");
		l1.addLast("ultimo");
		
		System.out.println(l1);
		
		for(int i = 0; i < l1.size(); i++) {
			System.out.println(l1.get(i) + " ");
		}
		
		System.out.println("---------------");
		
		String firstElement = l1.peek();
		System.out.println(firstElement);
		
		System.out.println(l1.poll());
		System.out.println(l1);
		
		int s = l1.size();
		for(int i = 0; i < s; i++) {
			System.out.println("Ho rimosso: " + l1.pollFirst());
			System.out.println("Situazioen attuale: " + l1);
			System.out.println("------");
		}
	}
}
