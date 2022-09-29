package ES1;

public class Dipendente {
	
	private static double stipendioBase = 1000.0;
	private int matricola;
	private double stipendio;
	private double importoOrarioStraordinario;
	private Livello Livello; //enum
	private Dipartimento Dipartimento; //enum

	//COSTRUTTORI
	public Dipendente(int matricola, Dipartimento Dipartimento) {
		this.matricola = matricola;
		this.setDipartimento(Dipartimento);
		this.stipendio = this.stipendioBase;
		this.setImportoOrarioStraordinario(30);
		this.Livello = Livello.OPERAIO;
	}
	
	public Dipendente(
			
			int matricola,
			double stipendio,
			double importoOrarioStraordinario,
			Livello Livello,
			Dipartimento Dipartimento
			
			) {
		this.matricola = matricola;
		this.stipendio = stipendio;
		this.setImportoOrarioStraordinario(importoOrarioStraordinario);
		this.Livello = Livello;
		this.setDipartimento(Dipartimento);
	}
	
	public Dipendente(
			
			int matricola,
			Livello Livello,
			Dipartimento Dipartimento
			
			) {
		this.matricola = matricola;
		this.Livello = Livello;
		this.stipendio = stipendioBase * Livello.getMoltiplicatoreStipendio();
		this.setDipartimento(Dipartimento);
	}

	//GETTER & SETTER
	public int getMatricola() {
		return matricola;
	}

	public double getStipendio() {
		return stipendio;
	}

	public double getImportoOrarioStraordinario() {
		return importoOrarioStraordinario;
	}

	public void setImportoOrarioStraordinario(double importoOrarioStraordinario) {
		this.importoOrarioStraordinario = importoOrarioStraordinario;
	}
	
	public Livello getLivello() {
		return Livello;
	}

	public Dipartimento getDipartimento() {
		return Dipartimento;
	}

	public void setDipartimento(Dipartimento dipartimento) {
		Dipartimento = dipartimento;
	}
	
	
	//METODI
	
	@Override
	public String toString(){
		return "Dipendente: " + this.matricola + " | Dipartimento: " 
				+ this.Dipartimento + " | Livello: " + this.Livello
				+ " | Stipendio: " + this.stipendio;
	}
	
	//stampa dati dipendente
	static public void stampaDati(Dipendente dipendente) {
		System.out.println(dipendente);
	}
	
	//promozione + update stipendio
	public String promuovi() {
		
		switch(this.Livello) {
		case OPERAIO:
			this.Livello = Livello.IMPIEGATO;
			this.stipendio = Dipendente.stipendioBase * 1.2;
			return this.toString();
		case IMPIEGATO:
			this.Livello = Livello.QUADRO;
			this.stipendio = Dipendente.stipendioBase * 1.5;
			return this.toString();
		case QUADRO:
			this.Livello = Livello.DIRIGENTE;
			this.stipendio = Dipendente.stipendioBase * 2;
			return this.toString();
		case DIRIGENTE:
			Error err1 = new Error("ERRORE< NON PUO ESSERE PROMOSSO");
			throw err1;
		default:
			Error err2 = new Error("ERRORE NON E' UN DIPENDENTE");
			throw err2;
		}
	}
	
	
	//metodi statici
	static double calcolaPaga(Dipendente d) {
		return d.stipendio;
	}
	
	static double calcolaPaga(Dipendente d, int oreStraord) {
		return d.stipendio + (oreStraord * d.importoOrarioStraordinario);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
