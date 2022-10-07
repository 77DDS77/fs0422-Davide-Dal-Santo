package davidedalsanto;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MainCatalog {

	public static void main(String[] args) throws IOException {
		
		//generating th "default" catalog
		Map<String, Readable> mainCatalog = new Manage().fillCatalog();
		
		//creating the Search and ManageIO instances with their constructor
		Search catSearch = new Search(mainCatalog);
		
		ManageIO catIO = new ManageIO(mainCatalog);
		
		
		//Printing the catalog
		System.out.println("///CATALOG///");
		
		//getting the books and printing
		System.out.println("\n--- books --- \n");
		Map<String, Readable> books = catSearch.getBooks();
		books.forEach((k, v) -> System.out.println(v));
		
		//getting the magazines and printing
		System.out.println("\n--- magazines --- \n");
		Map<String, Readable> magazines = catSearch.getBooks();
		magazines.forEach((k, v) -> System.out.println(v));
		
		sep();
		
		/*
		 *  NB:
		 *  every search method is surrounded by a try catch
		 *  statement because in case of an invalid search parameter
		 *  the method throws a -- ReadableNotFoundException -- 
		 *  wich is a custom Runtime Exception defined at
		 *  
		 *  Search.java
		 *  
		 */
		
		//Test area for search by ISBN code
		System.out.println("//SEARCH BY ISBN (9780708980279)//\n");
		try {
			
			Map<String, Readable> searchISBN = catSearch.byISBN("9780708980279");
			searchISBN.forEach((k, v) -> System.out.println(v));
		}
		catch(ReadableNotFoundException rnfe) {
			System.out.println(rnfe.getMessage());
		}
		
		sep();
		
		//test area for search by Publication year 
		System.out.println("//SEARCH BY PUBLICATION YEAR (1925)//\n");
		try {			
			Map<String, Readable> searchYEAR = catSearch.byYear("1925");
			searchYEAR.forEach((k, v) -> System.out.println(v));
		}
		catch(ReadableNotFoundException rnfe) {
			System.out.println(rnfe.getMessage());
		}
		
		System.out.println("\n--> Second search with "
					+ "wrong parameter (for display purpose only) <--\n");
		try {			
			Map<String, Readable> searchYEAR = catSearch.byYear("125");
			searchYEAR.forEach((k, v) -> System.out.println(v));
		}
		catch(ReadableNotFoundException rnfe) {
			System.out.println(rnfe.getMessage());
		}
		
		sep();
		
		//test area for search by Author
		System.out.println("//SEARCH BY AUTHOR (George R. R. Martin)//\n");
		try {			
			Map<String, Readable> searchAuthor = catSearch.byAuthor("George R. R. Martin");
			searchAuthor.forEach((k, v) -> System.out.println(v));
		}
		catch(ReadableNotFoundException rnfe) {
			System.out.println(rnfe.getMessage());
		}
		
		sep();
		
		//saving on docs/catalog.txt
		catIO.save();
		
		//reading from docs/catalog.txt
		List<String> fromCataTxt = catIO.load();
		System.out.println("\n ...PRINTING LOADED DATA...\n");
		fromCataTxt.forEach(System.out::println);
		System.out.println("\n ...END...\n");
		
	}
	
	//quick separator sysout for lazy dev
	private static void sep() {
		System.out.println("\n****************");
	}

}
