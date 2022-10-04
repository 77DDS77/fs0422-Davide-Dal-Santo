package esercizi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Esercizio2 {
	public static void main(String[] args) {
		
		Item i1 = new Item("Davide", new ArrayList<>( Arrays.asList(1, 3, 5, 6)));
		
		System.out.println(i1.getBestValue());
		
	}
}


class Item {
	String name;
	ArrayList<Integer> values;

	Item(String n, ArrayList<Integer> v) {
		this.name = n;
		this.values = v;
	}

	public int getBestValue() {
		return Collections.max(this.values);
	}

	@Override
	public String toString() {
		return name + ": " + values;
	}

}