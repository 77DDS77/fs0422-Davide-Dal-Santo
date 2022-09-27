import java.util.Date;

public class Ex3 {

	public static void main(String[] args) {
		
		Articolo pantaloni = new Articolo("Pantaloni belli", 50.0f, 3);
		Articolo tShirt = new Articolo("T-shirt manica corta", 20.0f, 10);
		
		Cliente davide = new Cliente("Davide", "Dal Santo", "d@d.com", new Date());
		
		Carrello carDavide = new Carrello(davide);
		carDavide.setArticoli(new Articolo[] {tShirt, pantaloni});
		carDavide.printCarrello();
		
	}

}

class Articolo {
	int idArt;
	String descArt;
	float prezzo;
	int disp;
	
	private static int internalId = 1;
	
	Articolo(String _descArt, float _prezzo, int _disp){
		this.setId();
		this.descArt = _descArt;
		this.prezzo = _prezzo;
		this.disp = _disp;
	}
	
	private void setId() {
		this.idArt = internalId++;
	}
}

class Cliente{
	int idCliente;
	String name;
	String lastname;
	String email;
	Date date;
	
	private static int internalId = 1;
	
	Cliente(String _name, String _lastname, String _email, Date _date){
		this.setId();
		this.name = _name;
		this.lastname = _lastname;
		this.email = _email;
		this.date = new Date();
	}
	
	private void setId() {
		this.idCliente = internalId++;
	}
	
}

class Carrello{
	Cliente clienteAssociato;
	Articolo[] articoli;
	float prezzoTot;
	
	Carrello(Cliente c){
		this.clienteAssociato = c;
	}
	
	public void setArticoli(Articolo[] arr){
		this.articoli = arr;
		
		for(Articolo art : arr) {
			this.prezzoTot += art.prezzo;
		}
	}
	
	public void printCarrello() {
		for(Articolo art : this.articoli) {
			System.out.printf(
					"%s | prezzo: %f %n",
					art.descArt, art.prezzo
					);
		}
		System.out.println("Costo totale: " + this.prezzoTot + " euri");
	}
	
	
	
	
	
	
}
