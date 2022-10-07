package davidedalsanto;

import java.util.HashMap;
import java.util.Map;

/*
 * Service class for add/delete methods 
 * and catalog "storage"
 */

public class Manage {

	//storing every element as {key: ISBNCode, value: Readable element}
	public Map<String, Readable> catalog = new HashMap<>();
	
	//creation of some books and magazines
		//books
	Readable book1 = new Book("9780708980279", "1984", "1949", 250, "George Orwell", "Dystopian");
	Readable book2 = new Book("9780553573404", "A Song of Ice and Fire", "1996", 1184, "George R. R. Martin", "Epic Fantasy");
	Readable book3 = new Book("9780743273565", "The Great Gatsby", "1925", 208, "F. Scott Fitzgerald", "Tragedy");
		
		//magazines
	Readable magazine1 = new Magazine("3781351504900", "Vogue France", "2022", 50, MagPer.MONTHLY);
	Readable magazine2 = new Magazine("3734235265620", "Il coding per tutti", "2015", 23, MagPer.WEEKLY);
	Readable magazine3 = new Magazine("7386429184102", "Focus", "2022", 40, MagPer.MONTHLY);
	
	//add - remove mothods
	public void addReadable(Readable el) {
		catalog.put(el.getISBN(), el);
	}
	
		//remove passing whole Readable element
	public void removeReadable(Readable el) {
		catalog.remove(el.getISBN());
	}
		//remove passing only ISBN Code
	public void removeISBN(String code) {
		catalog.remove(code);
	}
	
	/*
	 * method for didactic porpouse
	 * simply calling it in the main to fill
	 * the "default" catalog.
	 * 
	 * Returning the catalog so I can store it in a
	 * variable on my main and pass it to the methods that needs it
	 */
	public Map<String, Readable> fillCatalog() {
		
		addReadable(book1);
		addReadable(book2);
		addReadable(book3);
		
		addReadable(magazine1);
		addReadable(magazine2);
		addReadable(magazine3);
		
		return catalog;
		
	}
}
