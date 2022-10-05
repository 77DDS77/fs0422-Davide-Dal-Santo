/*
 * ex 1
creare 3 thread: due con l'estensione dell'apposita classe, 
uno con l'implementazione dell'apposita interfaccia
Le tre classi da creare si chiamano T1, T2, T3

I loro metodi "run" creano rispettivamente:
- un'iterazione tra x e y (valori indicati dall'utente)
- un logging in console tramite logback di un array di caratteri 
generato da una parola inserita dall'utente (in senso invertito). 
ogni carattere deve essere loggato ogni 2 secondi
- la generazione di un'istanza della classe Rettangolo(base, altezza) 
che estende la classe Forma, e il richiamo del suo metodo stampaArea()
fornire ai 3 thread un nome a piacere, e all'interno di ogni 
metodo run stampare il nome del thread in azione
 */

package EsClasse;

import java.util.Scanner;

public class Esercitazione {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		boolean loop = false;
		
		do {
			try {
				
				System.out.println("Inserisci primo valore");
		
				int x = Integer.parseInt(in.nextLine());
		
				System.out.println("Inserisci secondo valore");
		
				int y = Integer.parseInt(in.nextLine());
				
				System.out.println("Inserisci il noime del thread");
				
				String name = in.nextLine();
				
				T1 trd1 = new T1(x,y, name);

				trd1.start();
				
			}catch(Exception e) {
				loop = true;
			}
			
		}while(loop);
				
		in.close();
	}

}
