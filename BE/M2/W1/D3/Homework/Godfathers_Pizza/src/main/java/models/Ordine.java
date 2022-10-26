package models;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Ordine {
	
	private int numeroOrdine;
	private StatoOrdine statoOrdine;
	private int coperti;
	private String oraOrdine = LocalDateTime.now().getHour() + " " + LocalDateTime.now().getMinute();
	private Tavolo tavoloAssociato;
	private List<Item> elementiOrdinati;
	private double costoTotale;
	
	private double costoPerCoperto;

	public Ordine(int numeroOrdine, StatoOrdine statoOrdine, int coperti, Tavolo tavoloAssociato,
			List<Item> elementiOrdinati, double costoPerCoperto) {
		this.numeroOrdine = numeroOrdine;
		this.statoOrdine = statoOrdine;
		this.coperti = coperti;
		this.oraOrdine = LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute();
		this.tavoloAssociato = tavoloAssociato;
		this.tavoloAssociato.setOccupato(true);
		this.elementiOrdinati = elementiOrdinati;
		this.costoPerCoperto = costoPerCoperto;
		this.costoTotale = setCostoTotale();
	}
	
	private double setCostoTotale() {
		double sum = 0;
		for(Item i : this.elementiOrdinati) {
			sum += i.getPrezzo();
		}
		sum += coperti * this.costoPerCoperto;
		return sum;
	}
	
	
}
