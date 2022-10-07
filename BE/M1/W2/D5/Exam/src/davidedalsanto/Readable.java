package davidedalsanto;

//abstract class shared by books and magazines
public abstract class Readable {
	
	private String ISBNCode;
	private String title;
	private String pubYear;
	private int numPag;
	
	public Readable(String ISBNCode, String title, String pubYear, int numPag) {
		this.setISBN(ISBNCode);
		this.setTitle(title);
		this.setPubYear(pubYear);
		this.setNumPag(numPag);
	}

	
	
	//getters & setters
	
		//ISBN
	public String getISBN() {
		return ISBNCode;
	}

	public void setISBN(String iSBNCode) {
		ISBNCode = iSBNCode;
	}

		//title
	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}

		//pubYear
	public String getPubYear() {
		return pubYear;
	}



	public void setPubYear(String pubYear) {
		this.pubYear = pubYear;
	}

		//numPag
	public int getNumPag() {
		return numPag;
	}



	public void setNumPag(int numPag) {
		this.numPag = numPag;
	}
	
	
	
}	
