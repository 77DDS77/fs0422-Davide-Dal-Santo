package esercizi;

@FunctionalInterface
interface Math{
	double run(double x, double y);
}

public class Ex3 {
	
	/*
	 * Ex 3
	 * creare un'interfaccia funzionale chiamata Math con un 
	 * metodo double run(double x, double y)
	 * creare 4 istanze di tale interfaccia per sommare, 
	 * moltiplicare, dividere e sommare/poi/moltiplicare
	 */

	public static void main(String[] args) {
		
		Math add = (x, y) -> x + y;
		Math times = (x,y) -> x*y;
		Math divide = (x,y) -> x/y;
		Math parkour =  (x,y) -> add.run(x,y) * times.run(x, y);

	}

}
