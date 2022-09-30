package classes;

import interfaces.Brightness;
import interfaces.Volume;

public class Video extends Media implements Brightness, Volume{

	private static int brightness = 1;
	private static int volume = 1;
	private int durata;
	
	public Video(String _title, int durata) {
		super(_title);
		this.setDurata(durata);
	}
	
	
	
	public static int getBrightness() {
		return brightness;
	}



	private static void setBrightness(int brightness) {
		Video.brightness = brightness;
	}



	public static int getVolume() {
		return volume;
	}



	private static void setVolume(int volume) {
		Video.volume = volume;
	}



	public int getDurata() {
		return durata;
	}



	private void setDurata(int durata) {
		this.durata = durata;
	}
	
	//toString override
	@Override
	public String toString(){
		return "Video title: " +  this.title 
				+ " | Volume: " + volume
				+ " | Brightness: " + brightness;
	}

	//Interfaces Methods
	
	//Volume
	@Override
	public void volumeUp(int n) {
		if(n <= (10 - volume)) {			
			setVolume(volume += n);	
			System.out.println("Volume " + volume +  "/10");
		}else {
			if(volume < 10) {
				System.out.println("CAN'T SET THE VOLUME THAT HIGH");
			}else {				
				System.out.println("VOLUME ALREADY 0/10");			
			}
		}		
	}
	
	@Override
	public void volumeDown(int n) {
		if(n <= (0 + volume)) {			
			setVolume(volume -= n);		
			System.out.println("Volume " + volume +  "/10");
		}else {
			if(volume > 0) {
				System.out.println("CAN'T SET THE VOLUME THAT LOW");
			}else {				
				System.out.println("VOLUME ALREADY SET TO ZERO");			
			}
		}		
	}
	
	
	//Brightness
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
	
	//play() quando riprodotta stampa titolo + '!' x livello volume
	public void play() {
		System.out.println("Playing: " + title 
				+ "| Volume: " + volume
				+ "| Brightness: " + brightness);
		for(int d = 0; d < durata ; d++) {
			System.out.print(title);
			for(int b = 0 ; b < brightness; b++) {
				System.out.print("*");
			}
			for(int v = 0 ; v < volume; v++) {
				System.out.print("!");
			}
			System.out.println();
		}
	}
}



































