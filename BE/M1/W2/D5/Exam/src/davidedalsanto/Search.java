package davidedalsanto;

import java.util.Map;
import java.util.stream.Collectors;

public class Search {
	
	//final variables for color coded sysout
	public static final String TXT_YELLOW = "\u001B[33m";
	public static final String TXT_RESET = "\u001B[0m";
	public static final String TXT_RED = "\u001B[31m";
	

	public Map<String, Readable> searchCatalog;
	
	/*
	 * basically passing a populated catalog
	 * when creating my instance of search so
	 * the logic can be done here and not on the main
	 */
	public Search(Map<String, Readable> catalog) {
		this.searchCatalog = catalog;
	}
	
	
	
	/*
	 * NB:
	 * the methods: -- byAuthor -- byYear -- byISBN --
	 * rely on the -- exist -- boolean variable
	 * -> true if the search parameter is found inside the catalog
	 * -> false if not
	 * 
	 * if exist is false the methods throws a 
	 * -- ReadableNotFoundException --
	 * wich is a cusotm Runtime Exception 
	 * handled with a try/catch statement in 
	 *   MainCatalog.java
	 * where these methods are used.
	 */
	
	/*
	 * Search by author, 
	 * filtering to get only the books,
	 * getting the author equals to the parameter
	 * collection in a Map:
	 * {KEY: res -> res.getISBN(), VALUE: res-> res}
	 */
	public Map<String, Readable> byAuthor(String aut){
		
		boolean exist = searchCatalog.values().stream()
				.anyMatch(e -> e instanceof Book && ((Book)e)
				.getAuthor().equals(aut));
		
		if(exist) {
			
			return searchCatalog.values().stream()
					.filter(e -> e instanceof Book && ((Book)e)
							.getAuthor().equals(aut))
					.collect(Collectors.toMap(res -> res.getISBN(), res-> res));
		}else {
			throw new ReadableNotFoundException(
					TXT_YELLOW 
					+ "Your search parameter didn't match any "
					+ "Readable in the catalog"
					+ TXT_RED
					+ "\n **Use valid Author name**"
					+ TXT_RESET
					);
		}
	}
	
	/*
	 * Search by year,
	 * same as search by author without
	 * the need to check if its a book or a magazine
	 * since both have a "pubYear" value
	 */
	public Map<String, Readable> byYear(String year){
		
		boolean exist = searchCatalog.values().stream()
				.anyMatch(r -> r.getPubYear().equals(year));
		
		if(exist) {
			return searchCatalog.values().stream()
					.filter(r -> r.getPubYear().equals(year))
					.collect(Collectors.toMap(res -> res.getISBN(), res-> res));			
		}else {
			throw new ReadableNotFoundException(
					TXT_YELLOW 
					+ "Your search parameter didn't match any "
					+ "Readable in the catalog"
					+ TXT_RED
					+ "\n **Insert valid year**"
					+ TXT_RESET
					);
		}
		
	}
	
	/*
	 * Search by year,
	 * basically the same as - Search by year -
	 */
	public Map<String, Readable> byISBN(String code) {
		
		boolean exist = searchCatalog.values().stream()
				.anyMatch(r -> r.getISBN().equals(code));
		
		if(exist) {
			return searchCatalog.values().stream()
					.filter(r -> r.getISBN().equals(code))
					.collect(Collectors.toMap(res -> res.getISBN(), res -> res));			
		}else {
			throw new ReadableNotFoundException(
					TXT_YELLOW 
					+ "Your search parameter didn't match any "
					+ "Readable in the catalog"
					+ TXT_RED
					+ "\n **Insert valid ISBN code**"
					+ TXT_RESET
					);
		}


	}
	
	public Map<String, Readable> getBooks(){
		return searchCatalog.values().stream()
				.filter(e -> e instanceof Book)
				.collect(Collectors.toMap(res -> res.getISBN(), res-> res));
	}
	
	public Map<String, Readable> getMagazines(){
		return searchCatalog.values().stream()
				.filter(e -> e instanceof Magazine)
				.collect(Collectors.toMap(res -> res.getISBN(), res-> res));
	}
	
	
}

//custom runtime exception
class ReadableNotFoundException extends RuntimeException {

	/**
	 * Exception trown if the search method parameter
	 * doesn match any Readable in the catalog
	 */
	private static final long serialVersionUID = 1L;

	public ReadableNotFoundException(String msg) {
		super(msg);
	}
	
}


















