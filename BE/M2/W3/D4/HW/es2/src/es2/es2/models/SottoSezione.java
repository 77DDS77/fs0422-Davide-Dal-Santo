package es2.es2.models;

import java.util.ArrayList;
import java.util.List;

public class SottoSezione {

	public List<Pagina> pagine = new ArrayList<>();

	public SottoSezione(List<Pagina> pagine) {
		this.pagine = pagine;
	}

	public List<Pagina> getPagine() {
		return pagine;
	}

	public void setPagine(List<Pagina> pagine) {
		this.pagine = pagine;
	}

	@Override
	public String toString() {
		return "\nSottoSezione [pagine=" + pagine + "]";
	}
	
	
}
