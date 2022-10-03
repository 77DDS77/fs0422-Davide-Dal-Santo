
public class W2Day1_2 {

	public static void main(String[] args) {
		
		int x= 10;
		int y = 1;
		
		if( y > 0) {			
			System.out.println(x/y);
		}else{
			//throw new DivisionByNegative("no div per zero");
			
			DivisionByNegative exc = new DivisionByNegative("no div per zero");
			System.out.println((exc.getExcGenerated()));
			throw exc;
		}
		
		try {		
			m1();
		}
		catch(Exception e ) {
			System.out.println(e);
		}
		

	}
	
	public static void m1() throws EpicodeException {
		
		int x = 10;
		
		if(x == 10) {
			throw new EpicodeException("test");
		}
		
	}

}

class DivisionByNegative extends ArithmeticException{
	
	private static int excGenerated = 0;
	
	public DivisionByNegative(String message) {
		super(message);
		excGenerated++;
	}
	
	public int getExcGenerated() {
		return excGenerated;
	}
}

class EpicodeException extends Exception{
	public EpicodeException(String msg) {
		super(msg);
	}
}