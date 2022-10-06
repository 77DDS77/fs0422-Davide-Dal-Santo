package esercizi;
import java.util.function.Function;

public class Ex2 {

	/*
	 * Ex 2 
	 * creare una funzione che, 
	 * prendendo una stringa in ingresso, restituisce il suo
	 * carattere finale
	 * testare con 3 valori differenti
	 */
	
	public static void main(String[] args) {
		
		Function<String, Character> lastChar = (s) -> s.charAt(s.length() -1);

		System.out.println(lastChar.apply("Ciao"));
	}

}
