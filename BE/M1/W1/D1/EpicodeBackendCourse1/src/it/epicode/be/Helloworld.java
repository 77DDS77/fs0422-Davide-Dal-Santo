package it.epicode.be;

import java.util.Arrays;

public class Helloworld {

	public static void main (String[] args){
		// Stampa a console  la frase
		System.out.println("This is my first Epicode Java Project!");
		
		int n1 = 10;
		int n2 = 6;
		
		String[] arr = {"uno", "due", "tre", "quattro", "cinque"};
		
		String str = "intruso";
		
		System.out.println(moltiplica(n1, n2));
		
		System.out.println(concatena("ciao ", 8));
		
		System.out.println(Arrays.toString(inserisciInArray(arr, str)));
	}
	
	public static int moltiplica(int n1, int n2) {
		return n1 * n2;
	}
	
	public static String concatena(String str, int n) {
		return str + n;
	}
	
	public static String[] inserisciInArray(String[] strArr, String str) {
		String[] res = {strArr[0], strArr[1], strArr[2], str, strArr[3], strArr[4]};
		return res; 
	}
}



