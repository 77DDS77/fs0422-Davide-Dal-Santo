package lambda;

@FunctionalInterface
interface StringOperation{
	String start(String s);
}

@FunctionalInterface
interface ArrayOperation{
	int start(int[] n);
}

public class Ex2 {

	public static void main(String[] args) {
		
		//implementazioni
		StringOperation uc = (s) -> s.toUpperCase();
		StringOperation lc = (s) -> s.toLowerCase();
		StringOperation reverse = (s) -> {
			String s2 = "";
			for(int i = s.length() -1 ; i >=0 ; i--) {
				s2 += s.charAt(i);
			}
			return s2;
		};
		
		//ArrayOperation a1 = (n) -> new int[n];
		//int[] numbers = a1.start(10);
		
		
		//utilizzo
		System.out.println(uc.start("Ciao"));
		
		doStringOp(uc, "java");
		doStringOp(lc, "JAVAMERDA");
		doStringOp(reverse, "Davide");
	}

	public static void doStringOp(StringOperation op, String s) {
		System.out.println(op.start(s));
	}
}
