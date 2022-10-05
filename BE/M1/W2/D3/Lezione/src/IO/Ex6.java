package IO;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class Ex6 {

	public static void main(String[] args) {
		
		String f1Name = "docs/f1.txt";
		String encoding = "UTF-8";
		File f1 = new File(f1Name);
		
		Scanner in = new Scanner(System.in);
		
		if(f1.exists()) {
			System.out.println("il file " + f1Name + " esiste");
			System.out.println(f1.getName());
			System.out.println(f1.getPath());
			System.out.println(f1.length()); //byte del file
			System.out.println(f1.lastModified());
			
			System.out.println("Scrivi testo: ");
			String text = in.nextLine();
			
			try {
				FileUtils.writeStringToFile(f1, "\n"+text, encoding, true);
			} catch (IOException e) {
				System.out.println("Errore nella scrittura del file");
			}
			
		}else {
			System.out.println("il file " + f1Name + " non esiste");
		}

		
		in.close();
		
		try {
			String f1Content = FileUtils.readFileToString(f1, encoding);
			System.out.println("Contenunto: " + f1Content);
		} catch (IOException e) {
			System.out.println("Errore nella lettura del file");
		}
	}

}
