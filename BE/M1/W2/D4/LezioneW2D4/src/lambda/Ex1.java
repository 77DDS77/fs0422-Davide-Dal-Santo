package lambda;

public class Ex1 {

	public static void main(String[] args) {
		
//		Shape s = new Rectangle();
//		
//		printAreaOfShape(null ,10 ,5);
		
		printAreaOfShape(new Shape() {
			@Override
			public void printArea(int x, int y) {
				System.out.println(x * y);
			}
		}, 10, 5);
		
	}
	
	public static void printAreaOfShape(Shape s, int x, int y) {
		s.printArea(x, y);
	}

}

@FunctionalInterface
interface Shape{
	public abstract void printArea(int x, int y);
}

class Rectangle implements Shape{

	@Override
	public void printArea(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	
}