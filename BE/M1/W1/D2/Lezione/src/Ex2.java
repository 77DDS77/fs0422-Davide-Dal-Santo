
public class Ex2 {

	public static void main(String[] args) {
		
		Sim s1 = new Sim("3408884945");
		s1.setChiamata(new Chiamata[] {
			new Chiamata(10, "3334567890"),
			new Chiamata(6, "3334567890"),
			new Chiamata(45, "3324789564"),
			new Chiamata(58, "3925674532"),
			new Chiamata(2, "3467774545")
			
		});
		
		s1.showSim();
		s1.showCalls();
	}

}

class Chiamata{
	int durata;
	String numChiamato;
	
	Chiamata(int _durata, String _numChiamato){
		this.durata = _durata;
		this.numChiamato = _numChiamato;
	}
	
}

class Sim{
	String numTel;
	int credito;
	Chiamata[] arrChiamate;
		
	
	Sim(String _numTel){
		this.numTel = _numTel;
		this.credito = 0;
	}
	
	public void showSim(){
		System.out.printf(
				"Num: %s | Cred: %d |%n",
				this.numTel, this.credito
				);
	}
	
	public void showCalls() {
		for(Chiamata call : this.arrChiamate) {
			System.out.printf(
					"Hai chiamato il numero: %s | Durata: %d %n",
					call.numChiamato, call.durata
					);
		}
	}
	
	void setChiamata(Chiamata[] call) {
		this.arrChiamate = call;
	}
	
}
