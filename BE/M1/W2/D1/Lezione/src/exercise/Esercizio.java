package exercise;

import java.util.Scanner;

public class Esercizio {

	public static void main(String[] args) {
		
		Student s1 = studentMaker();
		Student s2 = studentMaker();
		
		System.out.println(StudentComparator.compare(s1, s2));
		
	}

	public static Student studentMaker() {
		Scanner in = new Scanner(System.in);
		String name = "";

		System.out.println("inserisci nome studente: ");
		
		try {
			name = in.nextLine();
			int nameL = name.length();
			if(nameL < 3 || nameL > 10) {
				throw new nameException("Nome deve avere minimo 3 caratteri max 10", name);
			}
		}catch(nameException e){
			System.out.println("Errore: " + e.getMessage() 
			+ " valore fornito: " + e.getErrName());
		}

		int i = 0;
		int[] voti = new int[3];
		do {
			System.out.println("Inserisci voto: ");
			try {
				int voto = Integer.parseInt(in.nextLine());	
				if(voto < 1 || voto > 10) {
					throw new VotesException("Voto errato, valore da 1 a 10 ", voto);
				}
				voti[i] = voto;
				i++;
			}
			catch(NumberFormatException e) {
				System.out.println(e.getMessage());
			}
			catch(VotesException e) {
				System.out.println(e.getMessage());
			}
			
		} while (i != 3);
		
		
		in.close();
		return new Student(name, voti);
	}
	
	
}

