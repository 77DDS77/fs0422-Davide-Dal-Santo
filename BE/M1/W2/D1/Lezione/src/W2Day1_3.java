import java.util.Scanner;

public class W2Day1_3 {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int x = 0;
		int y = 0;
		
		System.out.println("Scrivi x: ");
		try {			
			 x = Integer.parseInt(in.nextLine());
		}
		catch( NumberFormatException e) {
			System.out.println("deve essere un numero");
		}
		
		System.out.println("Scrivi y: ");
		try {			
			 y = Integer.parseInt(in.nextLine());
		}
		catch( NumberFormatException e) {
			System.out.println("deve essere un numero");
		}
		
		System.out.println("Risultato: " + (x+y));
		
		in.close();
	}
}
