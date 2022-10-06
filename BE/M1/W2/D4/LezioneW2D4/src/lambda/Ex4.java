package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex4 {

	public static void main(String[] args) {
		
		List<String> words = 
				new ArrayList<>(Arrays.asList("mela", "armadillo", "epicode"));
		words.removeIf(s -> s.charAt(0) == 'a');
		words.forEach((s) -> System.out.println(s));

		Map<String, String> m1 = new HashMap();
		
		m1.put("k1", "v1");
		m1.put("k2", "v2");
		m1.put("k3", "v3");
		
		m1.forEach((k, v) -> System.out.println("key: " + k + " value: " + v));
	}

}
