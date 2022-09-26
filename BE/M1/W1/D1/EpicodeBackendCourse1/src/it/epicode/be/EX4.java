package it.epicode.be;
import java.lang.Math;

public class EX4 {

	public static void main(String[] args) {
		
		System.out.println("Perimetro rettangolo: " + perimetroRettangolo(2.5f, 7.5f));
		
		System.out.println(pariDispari(2));
		
		System.out.println(pariDispariPro(3));

		System.out.println(areaTriangolo(2.5f, 6.5f, 8.0f));
	}

	public static float perimetroRettangolo(float l1, float l2) {
		return (l1 * 2) + (l2 * 2);
	}
	
	public static int pariDispari(int n) {
		return n % 2;
	}
	
	public static String pariDispariPro(int n) {
		return n % 2 == 0 ? "Pari" : "Dispari";
	}
	
	public static float areaTriangolo(float l1, float l2, float l3) {
		float p = (l1 + l2 + l3)/2;
		return (float) Math.sqrt(p * (p - l1) * (p - l2) * (p - l3));
	}
	
	
}
