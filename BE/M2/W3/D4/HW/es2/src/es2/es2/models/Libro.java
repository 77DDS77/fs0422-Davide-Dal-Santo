package es2.es2.models;

import java.util.ArrayList;
import java.util.List;

public class Libro {

	public List<Sezione> sezioni = new ArrayList<>();

	public List<String> autori;
	
	public double prezzo;

	public Libro(List<Sezione> sezioni, List<String> autori, double prezzo) {
		this.sezioni = sezioni;
		this.autori = autori;
		this.prezzo = prezzo;
	}

	public List<Sezione> getSezioni() {
		return sezioni;
	}

	public void setSezioni(List<Sezione> sezioni) {
		this.sezioni = sezioni;
	}

	public List<String> getAutori() {
		return autori;
	}

	public void setAutori(List<String> autori) {
		this.autori = autori;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	public void findTotPagineLibro() {
		int pagTot = 0;
		for (Sezione s : getSezioni()) {
			pagTot += s.getPagineSemplici().size();
			for (SottoSezione ss : s.getSottoSezione()) {
				pagTot += ss.getPagine().size();
			}
		}
		System.out.println("Pagine Totali Libro: " + pagTot);
	}

	@Override
	public String toString() {
		return "Libro [sezioni=" + sezioni + ", autori=" + autori + ", prezzo=" + prezzo + "]";
	}
	
	
}
