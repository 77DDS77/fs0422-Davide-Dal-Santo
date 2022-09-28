package Esercizio3;

import java.util.Scanner;

public class Esercizio3 {
	
	public static void separaEz(String s) {
		
		String[] splitted = s.split("");
		String res = String.join(",", splitted);
		System.out.println(res);
		
	}
	
	public static void separa(String s) {

		while(!s.equals(":q")) {
			String[] splitted = s.split("");
			String res = String.join(",", splitted);
			System.out.println(res);
			domandaStr();
			break;
		}
		System.out.println("Bye Bye!");
	}
	
	public static void domandaStr() {
		Scanner in = new Scanner(System.in);
		System.out.println("Inserisci una stringa");
		String s = in.nextLine();
		separa(s);
		//in.close();
	}
	
}
