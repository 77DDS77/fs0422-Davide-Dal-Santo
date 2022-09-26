package it.epicode.be;
import java.util.Scanner;

public class EX3 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Come ti chiami?");
		String name = in.nextLine();
		
		System.out.println("Dove sei nato?");
		String born = in.nextLine();
		
		System.out.println("Qual'e' il tuo cibo preferito?");
		String food = in.nextLine();
		
		System.out.printf("Ti chiami: %s | Sei nato a: %s | Ti piace mangare: %s %n", name, born, food);
		
		System.out.printf("Ti piace mangare: %s | Sei nato a: %s | Ti chiami: %s", food, born, name);
		
		in.close();

	}

}
