package models.display;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import models.Vehicle;
import models.VehicleType;
import models.dao.TicketDAO;
import models.dao.VehicleDAO;
import utils.LogColor;

/*
Definizione dello scanner, console output
per interazione utente.

- MOSTRA LISTA VEICOLI
- MOSTRA QUANTITÀ BIGLIETTI OBLITERATI IN UN ARCO DI TEMPO
- SELEZIONA ID VEICOLO:
	- AGGIORNA DATI VEICOLO
	- MOSTRA BIGLIETTI OBLITERATI SUL MEZZO
	- ELIMINA VEICOLO
- AGGIUNGI NUOVO VEICOLO
*/
public class VehicleDisplay {

	static Scanner scanner = new Scanner(System.in);
	
	public static void modaleVehicle() {

		boolean esegui = true;

		while (esegui) {
			System.out.println(LogColor.CYAN("*VEICOLI*") + "\n" + " \n" + 
		
					LogColor.GREEN("(0) ") + "Torna al " + LogColor.YELLOW("MENU PRINCIPALE") + "\n" 
					+ " | \n" + 
							
					LogColor.GREEN("(1) ") + "Visualizza " + LogColor.YELLOW("LISTA VEICOLI") + "\n" 
					+ " | \n" + 
		
					LogColor.GREEN("(2) ") + "Visualizza " + LogColor.YELLOW("QUANTITÀ BIGLIETTI OBLITERATI IN UN ARCO DI TEMPO") + "\n" 
					+ " | \n" + 
		
					LogColor.GREEN("(3) ") + "Seleziona " + LogColor.YELLOW("ID VEICOLO") + "\n" 
					+ " | \n" + 
		
					LogColor.GREEN("(4) ") + "Aggiungi " + LogColor.GREEN("NUOVO VEICOLO") + "\n");

		LogColor.selectionMessage( "Seleziona da 0 a 3" );
			try {
				int scelta = scanner.nextInt();

				switch (scelta)
				{
				case 0 -> {
					LogColor.infoMessage("Torno al menu principale");
					esegui = false;
				}

				case 1 -> {
					getVehicle();
				}
				
				case 2 -> {
					ticketForRangeOfTime();
				}

				case 3 -> {
					findVehicleById();
				}

				case 4 -> {
					newVehicle();
				}

				default -> {
				throw new Exception("Input fuori range. Riprova!");
				}
				}
			} catch (Exception e) {
				LogColor.errorMessage(e.getMessage());
				scanner.nextLine();
			}
		}

	}

	private static void ticketForRangeOfTime() {
		
		LogColor.CYAN( "QUANTITÀ BIGLIETTI OBLITERATI");
		
		boolean esegui = true;
		int count = 0;

		while (esegui) {
			if (count == 0) {
				scanner.nextLine();
				count++;
			}
		
		try {
		LogColor.selectionMessage("Inserisci data inizio yyyy/m/d");
		String startDate = scanner.nextLine();
		String[] startDateSplit = startDate.split("[^0-9]+");
		
		LogColor.selectionMessage("Inserisci data fine yyyy/m/d");
		String endDate = scanner.nextLine();
		String[] endDateSplit = endDate.split("[^0-9]+");
		
		LocalDate start = LocalDate.of(
				Integer.parseInt(startDateSplit[0]) , Integer.parseInt(startDateSplit[1]),Integer.parseInt(startDateSplit[2])
				);
		LocalDate end = LocalDate.of(
				Integer.parseInt(endDateSplit[0]) , Integer.parseInt(endDateSplit[1]),Integer.parseInt(endDateSplit[2])
				);
		
		long sz = TicketDAO.punchedTicketsByRangeOfTime(start,end).size();
		LogColor.infoMessage("I biglietti vidimati in questo arco di tempo sono: " + sz + (sz == 1? " biglietto!":" biglietti!") );
		
		esegui = false;
		
		}catch(Exception e) {
			LogColor.errorMessage(e.getMessage());
		}
		
		}
	}

	private static void printerVehicle(Vehicle item) {

		StringBuilder vuotaGiu = new StringBuilder();

		for (String s : item.toString()
				.split("")) {
			vuotaGiu.append("-");
		}
		System.out.println(item);
		System.out.println(vuotaGiu);
	}

	private static void getVehicle() {
		LogColor.standardMessage("Visualizzo il catalogo veicoli");
		List<Vehicle> database = VehicleDAO.getAll();

		for (Vehicle data : database) {
			printerVehicle(data);
		}
	}

	private static void findVehicleById() {	

		try {
			LogColor.infoMessage( "Hai scelto ricerca per ID");
			LogColor.selectionMessage("Inserisci ID veicolo");

			Long vehicleID = scanner.nextLong();

			LogColor.infoMessage("ricerco veicolo...");

			Vehicle findedVehicle = VehicleDAO.getById(vehicleID);

			if (findedVehicle.equals(null)) {
				throw new Exception("Nessun veicolo trovato! Riprova.");

			} else {
				LogColor.infoMessage("Trovato");
				printerVehicle(findedVehicle);
			}

			if (vehicleID != 0) {
				vehicleMenu(vehicleID);
			}

		} catch (Exception e) {
			LogColor.errorMessage(e.getMessage());
			scanner.nextLine();
		}

	}
	
	private static void vehicleMenu(Long vehicleID) {
		boolean esegui3 = true;

		while (esegui3) {
			try {
				System.out.println( LogColor.CYAN("*MENU VEICOLO CON ID:"+vehicleID+"*") + "\n" + " \n" +
	                    LogColor.GREEN( "(0) " ) + "Torna al " + LogColor.YELLOW( "MENU PRECEDENTE" ) + "\n" +
	                    " | \n" +
	                    LogColor.GREEN( "(1) " ) + "Aggiorna" + LogColor.YELLOW( " DATI VEICOLO" ) + "\n" +
	                    " | \n" +
	                    LogColor.GREEN( "(2) " ) + "Visualizza" + LogColor.YELLOW( " BIGLIETTI OBLITERATI SUL MEZZO" ) + "\n" +
	                    " | \n" +
	                    LogColor.GREEN( "(3) " ) + "Elimina " + LogColor.RED( "VEICOLO" ) + "\n" +
	                    "");
				
				LogColor.selectionMessage( "Seleziona da 0 a 3" );

				int sceltaAzione = scanner.nextInt();

				switch (sceltaAzione){
				
				case 0 -> {
					LogColor.infoMessage("Torno al menu precedente");
					esegui3 = false;
				}
				case 1 -> {
					updateVehicle(vehicleID);
				}
				
				case 2 -> {					
					long sz = TicketDAO.punchedTicketsByVehicle(vehicleID).size();
					LogColor.infoMessage("Il mezzo con id: "+ vehicleID + " ha vidimato " + sz + (sz == 1? " biglietto!":" biglietti!") );
					
				}

				case 3 -> {
					System.out.println(LogColor.YELLOW("Questa azione è irreversibile, sei sicuro?") + "\n" + " \n" +
	                        LogColor.GREEN( "(1) " ) + LogColor.YELLOW( "SI" )  + "\n" +
	                        " | \n" +
	                        LogColor.GREEN( "(2) " ) + LogColor.YELLOW( "NO") + "\n" +
	                        "");
					
					LogColor.selectionMessage( "Seleziona da 1 o 2" );

					int sceltaEliminazione = scanner.nextInt();

					if (sceltaEliminazione == 1) {
						VehicleDAO.delete(VehicleDAO.getById(vehicleID));
						esegui3 = false;
						
						LogColor.infoMessage("Veicolo con Id: " + vehicleID + " eliminato");
					} else {
						LogColor.standardMessage("Annullo scelta");
						esegui3 = false;
					}
				}
				default ->{
					throw new Exception( "Inserisci un'input valido!" );
				}
				}

			} catch (Exception e) {
				LogColor.errorMessage(e.getMessage());
			}
		}
	}
	
	private static void updateVehicle(Long vehicleID) {
		boolean esegui4 = true;

		while (esegui4) {
			

			try {
			System.out.println( LogColor.CYAN("*MODIFICA DATI VEICOLO*") + "\n" + " \n" +
                    LogColor.GREEN( "(0) " ) + "Torna al " + LogColor.YELLOW( "MENU PRECEDENTE" ) + "\n" +
                    " | \n" +
                    LogColor.GREEN( "(1) " ) + "Modifica" + LogColor.YELLOW( " STATO DI SERVIZIO" ) + "\n" +
                    " | \n" +
                    LogColor.GREEN( "(2) " ) + "Modifica " + LogColor.YELLOW( "MANUTENZIONE" ) + "\n" +
                    "" );

			LogColor.selectionMessage( "Seleziona da 0 a 2" );
			int sceltaModifica = scanner.nextInt();

			Vehicle selectedVehicle = VehicleDAO.getById(vehicleID);
			switch (sceltaModifica)
			{
			case 0 -> {
				LogColor.infoMessage("Torno al menu precedente");
				esegui4 = false;
			}
			case 1 -> {
				boolean eseguiService = false;

				do {
					try {
					scanner.nextLine();
					System.out.println( LogColor.CYAN("Il mezzo " + selectedVehicle.getId()
							+ " è in servizio?") + "\n" + " \n" +
		                    LogColor.GREEN( "(1) " ) + LogColor.YELLOW( "SI" ) + "\n" +
		                    " | \n" +
		                    LogColor.GREEN( "(2) " )+ LogColor.YELLOW( "NO" ) + "\n" +
		                    "" );
					
					LogColor.selectionMessage( "Seleziona da 1 o 2" );
					
					short servizio = scanner.nextShort();

					if (servizio == 1){
						eseguiService = false;
						selectedVehicle.setService(true);
						
						if (selectedVehicle.getIsService()) 
							LogColor.infoMessage("Il mezzo è ora in servizio");
							else 
							throw new Exception("La manutenzione è scaduta impossibile mettere in servizio il mezzo");
						
					}else if(servizio == 2){
						eseguiService = false;
						selectedVehicle.setService(false);
						LogColor.infoMessage("Il mezzo non è più in servizio");
						
					}else {
						eseguiService = true;
						throw new Exception("Inserisci un'input valido!");
						
					}
					
					}catch (Exception e) {
						LogColor.errorMessage(e.getMessage());
					}
				} while (eseguiService);

				VehicleDAO.refresh(selectedVehicle);

			}
			case 2 -> {
				scanner.nextLine();
				LogColor.infoMessage("La Manutenzione scade il: " + selectedVehicle.getMaintenance());
				LogColor.selectionMessage( "Inserire numero di mesi prossima manutezione: ");
				
				int month = scanner.nextInt();

				LocalDate newMaintenance = LocalDate.now()
						.plusMonths(month);
				
				LogColor.infoMessage("Modifico in " + newMaintenance);

				selectedVehicle.setMaintenance(newMaintenance);

				VehicleDAO.refresh(selectedVehicle);
				
				LogColor.infoMessage("Data manutenzione modificata");
				
			}
			default -> throw new Exception("Input fuori range");
			}
			}catch (Exception e) {
				LogColor.errorMessage(e.getMessage());
			}
		}
	}
	
	private static void newVehicle() {
		boolean eseguiAggiunta = true;

		while (eseguiAggiunta) {
			scanner.nextLine();
			try {
				 System.out.println( LogColor.CYAN("AGGIUNGI NUOVO VEICOLO")+ "\n" + " \n" +
		                    LogColor.GREEN( "(1) " ) + LogColor.YELLOW( "BUS" ) + "\n" +
		                    " | \n" +
		                    LogColor.GREEN( "(2) " ) + LogColor.YELLOW( "TRAM" ) + "\n" +
		                    "" );

				boolean newVehicle = false;

				do {
					LogColor.selectionMessage( "Seleziona tipo di veicolo, 1: BUS | 2: TRAM" );
					
					int type = scanner.nextInt();

					if (type == 1) {

						Vehicle v = new Vehicle(VehicleType.BUS);

						VehicleDAO.save(v);

						newVehicle = false;
						
						LogColor.infoMessage("Veicolo salvato con successo");
						
					} else if (type == 2) {

						Vehicle v = new Vehicle(VehicleType.TRAM);

						VehicleDAO.save(v);

						newVehicle = false;
						
						LogColor.infoMessage("Veicolo salvato con successo");
						
					} else {
						newVehicle = true;
						throw new Exception("Inserisci un'input valido!");
					}

				} while (newVehicle);

				System.out.println(LogColor.CYAN( "Vuoi salvare un nuovo veicolo?" ) + "\n" + " \n" +
						LogColor.GREEN( "(1) " ) + LogColor.YELLOW( "SI" )  + "\n" +
                        " | \n" +
                        LogColor.GREEN( "(2) " ) + LogColor.YELLOW( "NO" ) + "\n" +
                        "");
				
				LogColor.selectionMessage( "Seleziona da 1 o 2" );
				
				int input = scanner.nextInt();

				if (input > 1) {
					LogColor.infoMessage("Torno al menu principale");
					eseguiAggiunta = false;
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
				scanner.nextLine();
			}
		}
	}

}
