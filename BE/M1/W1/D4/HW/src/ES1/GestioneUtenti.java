package ES1;

public class GestioneUtenti {

	public static void main(String[] args) {
		
		Dipendente d1 = new Dipendente(0, Dipartimento.PRODUZIONE);
		Dipendente d2 = new Dipendente(1, Dipartimento.PRODUZIONE);
		Dipendente d3 = new Dipendente(2, Livello.IMPIEGATO,Dipartimento.AMMINISTRAZIONE);
		Dipendente d4 = new Dipendente(3, Livello.DIRIGENTE,Dipartimento.VENDITE);
		
		//promozioni
		d1.promuovi();
		d3.promuovi();
		
		//stato dipendenti
		Dipendente.stampaDati(d1);
		Dipendente.stampaDati(d2);
		Dipendente.stampaDati(d3);
		Dipendente.stampaDati(d4);
		
		System.out.println("Totale stipendi: " 
		+ (d1.getStipendio() + d2.getStipendio() + d3.getStipendio() + d4.getStipendio()));
		
	}
	
}
