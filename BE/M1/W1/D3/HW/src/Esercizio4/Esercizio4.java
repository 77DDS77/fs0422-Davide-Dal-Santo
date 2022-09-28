package Esercizio4;

import java.util.Scanner;

public class Esercizio4 {
	
	public static void domandaNum() {
		Scanner in = new Scanner(System.in);
		System.out.println("Inserisci un numero intero");
		//int n = Integer.parseInt(in.nextLine());
		int n = in.nextInt();
		in.nextLine();
		countdown(n);
		//in.close();
	}
	
	private static void countdown(int n) {
		for(int i = n ; i >= 0 ; i--) {
			
			System.out.println(i);
		}
		
	}

}
