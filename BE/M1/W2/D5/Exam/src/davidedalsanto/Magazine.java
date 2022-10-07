package davidedalsanto;

public class Magazine extends Readable{
	
	//MagPer enum value
	private MagPer periodicity;

	public Magazine(String ISBNCode, String title, String pubYear, int numPag, MagPer periodicity) {
		super(ISBNCode, title, pubYear, numPag);
		// TODO Auto-generated constructor stub
		this.setPeriodicity(periodicity);
	}

	//getters & setters
	public MagPer getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(MagPer periodicity) {
		this.periodicity = periodicity;
	}
	
	//toString Override for easy print on console
		@Override
		public String toString() {
			return "Magazine: ISBNCode: " + getISBN() + " | Title: " + getTitle() + 
					" | Year of publication: " + getPubYear() +
					" | Page count: " + getNumPag() +
					" | Periodicity: " + getPeriodicity() + " ||";
			
		} 

}
