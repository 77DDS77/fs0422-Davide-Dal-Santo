
public class Ex1 {

	public static void main(String[] args) {
		
		Rettangolo r1 = new Rettangolo(10,5);
		Rettangolo r2 = new Rettangolo(20,10);
		r1.showRettangolo();
		r2.showRettangolo();
		
		sumRects(r1, r2);
		
	}
	
	public static void sumRects(Rettangolo r1, Rettangolo r2) {
		
		int doublePerim = r1.getPerimetro() + r2.getPerimetro();
		int doubleArea = r1.getArea() + r2.getArea();
		
		System.out.printf(
				"La somma dei perimitri e': %d | La somma delle aree e': %d %n",
				doublePerim, doubleArea
				);
	}

}

class Rettangolo{
	int altezza;
	int larghezza;
	
	Rettangolo(int _altezza, int _larghezza){
		this.altezza = _altezza;
		this.larghezza = _larghezza;
	}
	
	public void showRettangolo() {
		int perimetro = (this.altezza * 2) + (this.larghezza * 2);
		int area = this.altezza * this.larghezza;
		System.out.printf(
				"Perimetro: %d | Area: %d %n",
				perimetro, area
				);
	}
	
	public int getPerimetro() {
		return (this.altezza * 2) + (this.larghezza * 2);
	}
	
	public int getArea() {
		return this.altezza * this.larghezza;
	}
}
