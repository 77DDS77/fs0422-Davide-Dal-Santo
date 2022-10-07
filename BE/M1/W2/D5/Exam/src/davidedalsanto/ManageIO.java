package davidedalsanto;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

/*
 * Same as Search.java,
 * separating th e logic from the main
 * Catalog in the constructor so the logic 
 * can be managed here
 */
public class ManageIO {
	
	public Map<String, Readable> catalogIO;
	
	public ManageIO(Map<String, Readable> catalog) {
		this.catalogIO = catalog;
	}
	
	/*
	 * Saving the element on a catalog.txt file
	 */
	public void save() throws IOException {
		
		String base = "";
		
		for(Readable el : catalogIO.values()) {
			base += (el.toString() + ";\n");
		}
		
		File file = new File("docs/catalog.txt");
		FileUtils.writeStringToFile(file, base, "UTF-8");
		System.out.println("**CATALOG SAVED**");
		
	}
	
	/*
	 * reading from the catalog.txt file
	 */
	public List<String> load() throws IOException {
		
		List<String> loaded = new ArrayList<>();
		
		File file = new File("docs/catalog.txt");
		
		String loadedString = FileUtils.readFileToString(file, "UTF-8");
		
		String[] loadedSplitted = loadedString.split("\n");
		
		for(String el : loadedSplitted) {
			loaded.add(el);
		}
		
		return loaded;
		
	}
}
