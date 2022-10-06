import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Classes.Customer;
import Classes.Order;
import Classes.Product;
import Enums.Categories;

public class Main {

	/*
	 * private static List<Product> allProducts;
	 * 
	 * private static void addToInventory(Product p) { allProducts.add(p); }
	 * 
	 */

	private static List<Product> inventory = getProducts();

	private static List<Product> getProducts() {
		return List.of(

				new Product("girello", Categories.BABY, 50), new Product("ciuccio", Categories.BABY, 12),
				new Product("biberon", Categories.BABY, 20),

				new Product("1984", Categories.BOOK, 15), new Product("meinKampft", Categories.BOOK, 150),
				new Product("ilPrincipe", Categories.BOOK, 15),

				new Product("fleshLight", Categories.BOYS, 30), new Product("beardOil", Categories.BOYS, 10),
				new Product("crossbow", Categories.BOYS, 300));
	}

	public static void main(String[] args) {

//		Customer pippo = new Customer("pippo",3);
//		Customer pimpo = new Customer("pimpo",4);
//		
//		System.out.println(pippo.getId());
//		System.out.println(pimpo.getId());
//		
//		Product prodotto = new Product(null, null, 0);
//		
//		List<Product> lista1 = new ArrayList<Product>();
//		
//		lista1.add(prodotto);
//		
//		System.out.println(prodotto.getId());
//		
//		Order ordine = new Order("undelivered", null, lista1, pimpo);
//		
//		System.out.println(ordine.getId());

		// Products

		System.out.println(inventory);

		Product girello = getProductByName("girello");

		// Customers

		Customer Davide = new Customer("Davide", 3);
		Customer Beatrice = new Customer("Beatrice", 2);
		Customer Florin = new Customer("Florin", 1);
		Customer Carisio = new Customer("Carisio", 2);
		Customer Claudio = new Customer("Claudio", 5);

		// Orders
		
		List<Product> BeatriceCart = new ArrayList<>();
		List<Product> ClaudioCart = new ArrayList<>();
		List<Product> CarisioCart = new ArrayList<>();
	
		try {
			BeatriceCart = new ArrayList<>(Arrays.asList(getProductByName("ilPrincipe"), getProductByName("crossbow")));
			ClaudioCart = new ArrayList<>(Arrays.asList(getProductByName("girello"), getProductByName("fleshlight")));
			CarisioCart = new ArrayList<>(Arrays.asList(getProductByName("beardOil"), getProductByName("meinKampft")));

		} catch (Exception e) {
			System.out.println("Il prodotto non esiste");
		}
		System.out.println(BeatriceCart);
		
		// Eesercizio 1
		
		List<Product> libriInsensatamenteCostosi =  inventory.stream()
				.filter(n-> n.getCategory().equals(Categories.BOOK)).filter(n-> n.getPrice()>100)
				.collect(Collectors.toList());
		
		System.out.println(libriInsensatamenteCostosi);
		
		// Esercizio 2

		Order BeatriceOrder = new Order("undelivered",LocalDate.now(),BeatriceCart,Beatrice);
		Order ClaudioOrder = new Order("undelivered",LocalDate.now(),ClaudioCart,Claudio);
		Order CarisioOrder = new Order("undelivered",LocalDate.now(),CarisioCart,Carisio);
		
		List<Order> allOrder = new ArrayList<>(Arrays.asList(BeatriceOrder,ClaudioOrder,CarisioOrder));
		
		List<Product> prodottiPerBimbi = inventory.stream()
				.filter(n-> n.getCategory().equals(Categories.BABY))
				.collect(Collectors.toList());
		
		
	allOrder.stream().filter(n -> n.getProducts().stream()
			.anyMatch(p->p.getCategory().equals(Categories.BABY)))
			.forEach(System.out::println);
	
	Map<List<Product>, List<Order>> groupByCategories = allOrder.stream().collect(Collectors.groupingBy(Order::getProducts));
	
	groupByCategories.forEach((c,p)->{
		System.out.println(c);
		p.forEach(System.out::println);
	});
	

	}

	static Product getProductByName(String s) throws RuntimeException {

		try {
			return inventory.stream().filter(n -> n.getName().equals(s)).collect(Collectors.toList()).get(0);

		} catch (IndexOutOfBoundsException e) {
			throw e;
		}

	}

	
	
	
	
	
	
	
}
