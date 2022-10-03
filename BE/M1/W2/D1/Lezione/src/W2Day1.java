
public class W2Day1 {

	public static void main(String[] args) {
		
		int[] numbers = {10,20,30,40};
		String s = null;
		
		/*
		try {
			
			System.out.println(numbers[5]);
		}
		catch(Exception e){
			System.out.println("Exception: " + e);
		}
		
		
		try {			
			System.out.println(s.length());
		}
		catch(NullPointerException e) {
			System.out.println("Null pointer");
		}
		*/

		//posso annidare un try catch all'interno
		//di un altro try
		
		try {
			System.out.println(numbers[5]);
			System.out.println(s.length());
		}
		catch(NullPointerException e){
			System.out.println("Exception: " + e.getMessage());
		}
		catch(ArrayIndexOutOfBoundsException e1) {
			System.out.println("Exception: " + e1.getMessage());
		}
		catch(Exception e2) {
			System.out.println("Exception: " + e2.getMessage());
		}
	}

}
