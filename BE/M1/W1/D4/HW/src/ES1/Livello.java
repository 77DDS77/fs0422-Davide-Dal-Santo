package ES1;

public enum Livello {
	OPERAIO(1.0),
	IMPIEGATO(1.2),
	QUADRO(1.5),
	DIRIGENTE(2.0);
	
	private final double moltiplicatoreStipendio;
	
	private Livello(double stipendio) {
		this.moltiplicatoreStipendio = stipendio;
	}
	
	public double getMoltiplicatoreStipendio() {
		return moltiplicatoreStipendio;
	}
}
