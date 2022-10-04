package esercizi;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Esercizio1 {

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		
		LinkedList<Integer> nums = new LinkedList<>();
		
		for(int i = 1; i < 5; i++) {
			System.out.println("Inserisci numero " + i + ": ");
			int x = Integer.parseInt(scan.nextLine());
			nums.add(x);
		}
		
		System.out.println(nums);
		System.out.println("Numero piu piccolo: " + Collections.min(nums));
		scan.close();

	}

}
