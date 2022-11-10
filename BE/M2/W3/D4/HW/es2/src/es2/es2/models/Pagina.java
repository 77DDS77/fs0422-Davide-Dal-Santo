package es2.es2.models;

public class Pagina {
	
	public String content;
	public int numPagina;
	public String getContent() {
		return content;
	}
	
	public Pagina(String content, int numPagina) {
		this.content = content;
		this.numPagina = numPagina;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public int getNumPagina() {
		return numPagina;
	}
	public void setNumPagina(int numPagina) {
		this.numPagina = numPagina;
	}

	@Override
	public String toString() {
		return "\nPagina [content=" + content + ", numPagina=" + numPagina + "]";
	}
	
	
}
