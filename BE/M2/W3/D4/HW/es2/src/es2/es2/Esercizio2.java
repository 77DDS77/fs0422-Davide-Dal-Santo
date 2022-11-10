package es2.es2;

import java.util.ArrayList;
import java.util.List;

import es2.es2.models.Libro;
import es2.es2.models.Pagina;
import es2.es2.models.Sezione;
import es2.es2.models.SottoSezione;

/*
 * Esercizio #2 (composite)
Modellare questo dominio: 
â€“ Un libro Ã¨ composto da pagine,
 eventualmente organizzate in sezioni. 
 Ogni sezione puÃ² contenere sottosezioni (una o piÃ¹) e pagine semplici. 
â€“ EÊ¼ possibile stampare una pagina singola,
una sezione o lÊ¼intero libro.
- Il libro ha una lista di autori
- Il libro ha un prezzo
- Ogni sezione ha un numero di pagine che Ã¨ dato dalla somma
 delle pagine dei suoi sottoelementi
- Deve essere possibile chiedere al libro il numero totale di pagine
*/

public class Esercizio2 {

	public static void main(String[] args) {

		Libro l = makeLibro();
		System.out.println(l);
		l.findTotPagineLibro();;
	}

	
	public static List<Pagina> makePagine() {
		Pagina p1 = new Pagina("Lorem", 1);
		Pagina p2 = new Pagina("Lorem", 3);
		Pagina p3 = new Pagina("Lorem", 3);
		Pagina p4 = new Pagina("Lorem", 4);
		Pagina p5 = new Pagina("Lorem", 5);
		Pagina p6 = new Pagina("Lorem", 6);
		Pagina p7 = new Pagina("Lorem", 7);
		Pagina p8 = new Pagina("Lorem", 8);
		
		List<Pagina> pagine = new ArrayList<>();
		pagine.add(p1);
		pagine.add(p2);
		pagine.add(p3);
		pagine.add(p4);
		pagine.add(p5);
		pagine.add(p6);
		pagine.add(p7);
		pagine.add(p8);
		return pagine;
	}
	
	public static SottoSezione makeSottoSezione() {
		return new SottoSezione(makePagine());
	}
	
	public static Sezione makeSezione() {
		List<SottoSezione> sottoSezioni = new ArrayList<>();
		sottoSezioni.add(makeSottoSezione());
		sottoSezioni.add(makeSottoSezione());
		sottoSezioni.add(makeSottoSezione());
		return new Sezione(sottoSezioni, makePagine());
	}
	
	public static Libro makeLibro() {
		List<Sezione> sezioni = new ArrayList<>();
		sezioni.add(makeSezione());
		sezioni.add(makeSezione());
		sezioni.add(makeSezione());
		List<String> autori = new ArrayList<>();
		autori.add("Marco");
		autori.add("Mirco");
		autori.add("Mauro");
		return new Libro(sezioni, autori, 10);
	}
	
	
}









