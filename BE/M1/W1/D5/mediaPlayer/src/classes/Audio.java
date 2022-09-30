package classes;

import interfaces.Volume;

public class Audio extends Media implements Volume {
	
	private static int volume = 1;
	private static int durata;

	public Audio(String _title, int _durata) {
		super(_title);
		this.setDurata(_durata);
	}

	//getter & setter
	public static int getVolume() {
		return volume;
	}

	private static void setVolume(int volume) {
		Audio.volume = volume;
	}
	
	public static int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		Audio.durata = durata;
	}

	//toString override
	@Override
	public String toString(){
		return "Track audio title: " +  this.title + " | Volume: " + volume;
	}

	//Interface methods
	@Override
	public void volumeUp(int n) {
		if(n <= (10 - volume)) {			
			setVolume(volume += n);	
			System.out.println("Volume " + volume +  "/10");
		}else {
			if(volume < 10) {
				System.out.println("CAN'T SET THE VOLUME THAT HIGH");
			}else {				
				System.out.println("VOLUME ALREADY 10/10");			
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
				System.out.println("VOLUME ALREADY 0/10");			
			}
		}
		
	}
	
	//play() quando riprodotta stampa titolo + '!' x livello volume
	public void play() {
		System.out.println("Playing: " + title + "| Volume: " + volume);
		for(int i = 0; i < durata ; i++) {
			System.out.print(title);
			for(int j = 0 ; j < volume; j++) {
				System.out.print("!");
			}
			System.out.println();
		}
	}

}
