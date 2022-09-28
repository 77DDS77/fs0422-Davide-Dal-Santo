package Esercizio1;

public class Esercizio1 {
	
	public static void stringaPariDispari(String str) {
		if(str.length() % 2 == 0) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
	}
	
	
	public static void stringaPariDispariPRO(String str) {
		System.out.println((str.length() % 2 == 0) ? true : false);
	}
	
	public static void annoBisestile(int anno) {
		if(anno % 4 == 0) {
			System.out.println("Anno bisestile");
		}else {
			System.out.println("Anno non bisestile");
		}
	}
	
	
}
