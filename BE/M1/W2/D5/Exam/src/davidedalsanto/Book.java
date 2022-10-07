package davidedalsanto;

public class Book extends Readable{

	private String author;
	private String genre;
	
	public Book(String ISBNCode, String title, String pubYear, int numPag, String author, String genre) {
		super(ISBNCode, title, pubYear, numPag);
		this.author = author;
		this.genre = genre;
	}

	//getters & setters
	
		//author
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

		//genre
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	//toString Override for easy print on console
	@Override
	public String toString() {
		return "Book: ISBNCode: " + getISBN() + " | Title: " + getTitle() + 
				" | Author: " + getAuthor() + " | genre: " + getGenre() +
				" | Year of publication: " + getPubYear() +
				" | Page count: " + getNumPag() + " ||";
		
	}
}
