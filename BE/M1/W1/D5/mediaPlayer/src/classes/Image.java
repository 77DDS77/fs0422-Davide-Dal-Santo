package classes;

import interfaces.Brightness;

public class Image extends Media implements Brightness {
	
	private static int brightness = 1;

	public Image(String _title) {
		super(_title);

	}

	
	
	//getter & setter
	public static int getBrightness() {
		return brightness;
	}

	private static void setBrightness(int brightness) {
		Image.brightness = brightness;
	}

	//toString override
	@Override
	public String toString(){
		return "Image title: " +  this.title + " | Brightness: " + brightness;
	}


	//Interface methods
	@Override
	public void moreBright(int n) {
		if(n <= (10 - brightness)) {			
			setBrightness(brightness += n);	
			System.out.println("Brightness " + brightness +  "/10");
		}else {
			if(brightness < 10) {
				System.out.println("CAN'T SET THE BRIGHTNES THAT HIGH");
			}else {				
				System.out.println("BRIGHTNESS ALREADY 10/10");			
			}
		}	
	}

	@Override
	public void lessBright(int n) {
		if(n <= (0 + brightness)) {			
			setBrightness(brightness -= n);	
			System.out.println("Brightness " + brightness +  "/10");
		}else {
			if(brightness > 0) {
				System.out.println("CAN'T SET THE BRIGHTNES THAT LOW");
			}else {				
				System.out.println("BRIGHTNESS ALREADY 0/10");			
			}
		}
	}

	// show() quando riprodotta stampa titolo + '*' x livello lum
	public void show() {
		System.out.println("///");
		System.out.println("Showing: " + title + "| Brightness: " + brightness);
		System.out.print(this.title + " ");
		for(int i = 0; i < brightness ; i++) {
			System.out.print("*");
		}
		System.out.println();
		System.out.println("///");
	}
}
