package lambda;
import java.util.function.Predicate;
import java.util.function.Function;

public class Ex3 {

	public static void main(String[] args) {
		
		//Predicate (.test)
		//implementazioni
		Predicate<Integer> greaterThanZero = (n) -> n > 0;
		Predicate<Integer> isEven = (n) -> n % 2 == 0;

		
		//utilizzi
		System.out.println(greaterThanZero.test(10));
		System.out.println(greaterThanZero.test(-10));
		
		System.out.println(
				"Maggiore di zero e even: " 
				+ greaterThanZero.and(isEven).test(33)
						);
		
		tests(isEven, 9);
		tests( (n) -> n% 2 != 0, 3);
		
		
		//Function (.apply)
		//implementazioni
		Function<String, Integer> fn1 = (s) -> s.length();
		Function<Integer, Integer> fn2 = (n) -> n*2;
		
		
		//utilizzi
		System.out.println("Stringa lunga: " + fn1.apply("tre"));
		applyFn( fn1, "sike");
		System.out.println("Moltiplicazione: " + fn2.apply(6));
		//prende la length con fn1 and then la moltiplica con fn2
		System.out.println("SuperSaijan: " + fn1.andThen(fn2).apply("java"));
		
	}
	
	public static void tests(Predicate<Integer> testType, int n) {
		System.out.println("Risultato: " + testType.test(n));
	}
	
	public static void applyFn(Function<String, Integer> fn, String s) {
		System.out.println("applyFn: " + fn.apply(s));
	}

}
