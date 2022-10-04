package lezione;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Hashmap {

	public static void main(String[] args) {
		
		HashMap<String, String> m1 = new HashMap<>();
		
		m1.put("name", "Luigi");
		m1.put("lastname", "Rossi");
		m1.put("role", "Developer");
		
		for(Map.Entry mEntry : m1.entrySet()){
		      System.out.print("key: "+ mEntry.getKey() + " & Value: ");
		      System.out.println(mEntry.getValue());
		    }
		
		
		System.out.println(m1.values());
		
		System.out.println(m1.get("name") + " " + m1.get("lastname"));
		
		System.out.println("-----------------");
		
		HashMap<String, ArrayList<Integer>> studenti = new HashMap<>();
		
		studenti.put("davide", new ArrayList<>(Arrays.asList(8,9,7)));
		studenti.put("piero", new ArrayList<>(Arrays.asList(5,7,7)));
		studenti.put("marco", new ArrayList<>(Arrays.asList(9,7,5)));
		
		
		for(Map.Entry set : studenti.entrySet()) {
			System.out.println("Studente: " + set.getKey()
			+ " Voti: " + set.getValue());
		}
		
		
	}

}
