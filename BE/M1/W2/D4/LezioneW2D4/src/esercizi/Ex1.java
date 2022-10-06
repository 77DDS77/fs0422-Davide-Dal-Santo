package esercizi;

import java.util.function.Predicate;

public class Ex1 {

	/*
	 * Ex 1
	 * creare con l'apposita strategia, 
	 * un predicato che permette di stabilire se la stringa passata 
	 * in ingresso è palindroma.
	 * testare con 3 valori differenti
	 */
	
	public static void main(String[] args) {
		
		Predicate<String> isPalindrome = (s) -> {
			
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) != s.charAt((s.length()-1)-i)) {
					return false;
				}
			}
			return true;
			
		};
		
		System.out.println(isPalindrome.test("itopinonavevanonipoti"));
	}

}
