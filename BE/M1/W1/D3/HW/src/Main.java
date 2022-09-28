import java.util.Scanner;

import Esercizio1.Esercizio1;
import Esercizio2.Esercizio2;
import Esercizio3.Esercizio3;
import Esercizio4.Esercizio4;

//esercizi pome

public class Main {

	public static void main(String[] args) {
		
		System.out.println("------ESERCIZIO 1");
		
		String str = "Ciao";
		Esercizio1.stringaPariDispari(str);
		
		
		System.out.println("------ESERCIZIO 1.2");
		
		Esercizio1.annoBisestile(2020);
		
		
		System.out.println("------ESERCIZIO 2");
		
		Scanner in = new Scanner(System.in);
		System.out.println("Digita un numero tra 0 e 3");
		int n = in.nextInt();
		in.nextLine();

		Esercizio2.intToString(n);
		
		System.out.println("------ESERCIZIO 3");
		Esercizio3.domandaStr();
		
		System.out.println("------ESERCIZIO 4");
		Esercizio4.domandaNum();
		
		
		in.close();
	}

}
