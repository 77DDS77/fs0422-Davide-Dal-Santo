package D3;

public class Class1 {

	int x, y;
	
	public Class1() {
		this.x = 10;
		this.y = 5;
	}
	
	/*DEVO mettere il public, se lo ometto
	 *  sarebbe come mettere /package-private/
	 *  quindi leggibile solo all'interno del package
	 */
	public void stampaSomma() {
		System.out.println(this.x + this.y);
	}
	
}
