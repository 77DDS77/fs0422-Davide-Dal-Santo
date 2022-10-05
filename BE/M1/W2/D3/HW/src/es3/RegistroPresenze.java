/*
 * 
 * NON FUNZIONA
 */


package es3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class RegistroPresenze {

	static List<Persona> reg = new ArrayList<>();
	
	public static void main(String[] args) {
		
		String f1Name = "docs/f1.txt";
		File f1 = new File(f1Name);
				
		Persona p1 = new Persona("Davide", 10);
		Persona p2 = new Persona("Mirco", 4);
		Persona p3 = new Persona("Marco", 14);
		Persona p4 = new Persona("Anna", 12);
		Persona p5 = new Persona("Giulia", 1);
		
		reg.add(p1);
		reg.add(p2);
		reg.add(p3);
		reg.add(p4);
		reg.add(p5);
		
		salvaPresenze();
		if(f1.length() != 0) {			
			leggiPresenze();
		}
	}
	
	public static void salvaPresenze() {
		
		String f1Name = "docs/f1.txt";
		String encoding = "UTF-8";
		File f1 = new File(f1Name);
		
		try {			
			for(Persona person : reg) {
				FileUtils.writeStringToFile(f1, person.toString() + "\n", encoding, true);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void leggiPresenze() {
		String f1Name = "docs/f1.txt";
		String encoding = "UTF-8";
		File f1 = new File(f1Name);
		
		try {
			String f1Content = FileUtils.readFileToString(f1, encoding);
			String[] parsedCont = f1Content.split("\n");
			
			
		for(String p : parsedCont) {
				if(!reg.contains(p)) {
					String[] splittedP = p.split("@");
					
					Persona x = new Persona(
							splittedP[0], Integer.parseInt(splittedP[1])
							);
					reg.add(x);
				}
			}
			
			System.out.println(Arrays.toString(parsedCont));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class Persona{
	String name;
	int presenze;
	
	public Persona(String n, int p) {
		this.name = n;
		this.presenze = p;
	}
	
	@Override
	public String toString() {
		return name + "@" + presenze;
	}
}
