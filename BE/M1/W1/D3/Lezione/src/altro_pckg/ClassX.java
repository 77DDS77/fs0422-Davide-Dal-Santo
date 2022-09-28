package altro_pckg;
import D3.Class1;
import D3.animals.Dog;

// * importo tutto il package
import java.util.*;

public class ClassX {

	public static void main(String[] args) {
		
		/*
		 * Class1 arriva da un altro package ma con l'import
		 * e per il motivo che Class1 e' public posso usarla
		 */
		
		Class1 a = new Class1();
		
		//posso usarlo perche' su Class1 e' public
		a.stampaSomma();
		
		
		//importo da un package innestato
		Dog dog1 = new Dog();
		System.out.println(dog1.legs);
		
		
		String color = "blue"; //true true
		String color1 = new String("blue"); //false true
		
		System.out.println(color == "blue");
		System.out.println(color.equals("blue"));
		
		//ciclo for break e continue, gia li sai
		for(int i = 1; i <= 10; i++) {
			
			if( i == 4) {
				//break;
				continue;
			}
			System.out.println(i);
		}
		
		System.out.println("------------------");
		for(int i = 1; i <= 10; i++) {
			
			for(int j = 10; j>= 1; j--) {
				if(i == 4) continue;
				System.out.print(j + " / ");
			}
			
			if(i == 2)break;
			System.out.println(i);
		}
		
		
		System.out.println();
		System.out.println("------------------");
		
		char z = 'a';
		System.out.println(z == 97);
		
		
	}
	
	
}
