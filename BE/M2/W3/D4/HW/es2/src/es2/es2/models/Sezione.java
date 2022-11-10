package es2.es2.models;

import java.util.ArrayList;
import java.util.List;

public class Sezione {

	public List<SottoSezione> sottoSezione = new ArrayList<>();
	public List<Pagina> pagineSemplici = new ArrayList<>();
	public int numPagineTotale;
	
	public Sezione(List<SottoSezione> sottoSezione, List<Pagina> pagineSemplici) {
		this.sottoSezione = sottoSezione;
		this.pagineSemplici = pagineSemplici;
		setNumPagineTotale();
	}
	
	
	public List<SottoSezione> getSottoSezione() {
		return sottoSezione;
	}
	public void setSottoSezione(List<SottoSezione> sottoSezione) {
		this.sottoSezione = sottoSezione;
	}
	public List<Pagina> getPagineSemplici() {
		return pagineSemplici;
	}
	public void setPagineSemplici(List<Pagina> pagineSemplici) {
		this.pagineSemplici = pagineSemplici;
	}
	public int getNumPagineTotale() {
		return numPagineTotale;
	}
	public void setNumPagineTotale() {
		int calc = 0;
		
		if(sottoSezione.size() > 0) {			
			for (SottoSezione ss : sottoSezione) {
				calc += ss.getPagine().size();
			} 
		}
		
		calc += pagineSemplici.size();
		
		this.numPagineTotale = calc;
	}


	@Override
	public String toString() {
		return "\nSezione [sottoSezione=" + sottoSezione + ", pagineSemplici=" + pagineSemplici + ", numPagineTotale="
				+ numPagineTotale + "]";
	}
	
}
