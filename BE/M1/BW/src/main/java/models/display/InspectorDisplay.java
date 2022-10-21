package models.display;

import java.util.List;
import java.util.Scanner;

import models.Ticket;
import models.Voyage;
import models.dao.SeasonTicketDAO;
import models.dao.TicketDAO;
import models.dao.VehicleDAO;
import models.dao.VoyageDAO;
import utils.LogColor;


/*
Definizione dello scanner, console output
per interazione utente.

- USA BIGLIETTO
- USA ABBONAMENTO
*/
public class InspectorDisplay {

	static Scanner scanner = new Scanner(System.in);

	public static void modaleInspector() {
		boolean condition = true;
		do {

			System.out.println(LogColor.CYAN( "*MENU CONTROLLORE*" ) + "\n" + " \n" +
					LogColor.GREEN( "(0) " ) + "Torna al " + LogColor.YELLOW( "MENU PRINCIPALE" ) + "\n" +
                    " | \n" +
                    LogColor.GREEN( "(1) " ) + "Usa" + LogColor.YELLOW( " BIGLIETTO" ) + "\n" +
                    " | \n" +
                    LogColor.GREEN( "(2) " ) + "Usa" + LogColor.YELLOW( " ABBONAMENTO" ) + "\n" +
                    "");
			 		LogColor.selectionMessage( "Seleziona da 0 a 2" );
			
			try {
				int scelta = scanner.nextInt();

				switch (scelta)
				{
				case 0 -> {
					LogColor.infoMessage("Torno al menu principale");
					condition = false;
				}

				case 1 -> {
					checkTicket();
				}

				case 2 -> {
					checkSeasonTicket();
				}
				default -> {
					LogColor.errorMessage("Input fuori range");
				}
				}
			} catch (Exception e) {
				LogColor.errorMessage("Qualcosa e' andato storto, riprova");
			}

		} while (condition);
	}

	/*
	Metodo che controlla se l'abbonamento e' valido, se valido 
		- VISUALIZZA LISTA VIAGGI DISPONIBLI
		- USA ABBONAMENTO
	*/
	private static void checkSeasonTicket() {
		boolean condizione = true;
		while (condizione) {
			System.out.println(LogColor.CYAN( "*MENU SEASON TICKET*" ) + "\n" + " \n" +
					LogColor.GREEN( "(0) " ) + "Torna al " + LogColor.YELLOW( "MENU PRINCIPALE" ) + "\n" +
                    " | \n" +
                    LogColor.GREEN( "(1) " ) + "Mostra" + LogColor.YELLOW( " LISTA VIAGGI DISPONIBILI" ) + "\n" +
                    " | \n" +
                    LogColor.GREEN( "(2) " ) + "Usa" + LogColor.YELLOW( " ABBONAMENTO" ) + LogColor.CYAN(" (ID viaggio necessario)") + "\n");

			try {
				int scelta = scanner.nextInt();

				switch (scelta)
				{
				case 0 -> {
					LogColor.infoMessage("Torno al menu principale");
					condizione = false;
				}

				case 1 -> { // Mostra lista viaggi disponibili
					LogColor.standardMessage("Lista viaggi disponibili:");
					printAllVoyage();
				}
				
				/*
				Possibile update:
					chiedere ID utente prima di chiedere ID abbonamento
					controllare se ID Abbonamento appartiene a ID utente 
				*/
				case 2 -> { // Usa Abbonamento (ID viaggio necessario)
					scanner.nextLine();
					LogColor.selectionMessage("Inserisca l'ID del suo abbonamento");
					long passID = scanner.nextLong();
					if (SeasonTicketDAO.getById(passID) == null) {
						LogColor.errorMessage("L'abbonamento con ID " + passID + " non esiste.");
					} else {
						LogColor.infoMessage("*ABBONAMENTO VALIDO TROVATO*");
						LogColor.selectionMessage("Inserire l'ID del viaggio desiderato");

						long choosen = scanner.nextLong();
						if (VoyageDAO.getById(choosen) == null) {
							LogColor.errorMessage("Il voyage con ID " + choosen + " non esiste.");
						} else {
							LogColor.infoMessage("BUON VIAGGIO!");
						}
					}
				}
				default -> {
					LogColor.errorMessage("Input fuori range");
					condizione = false;
				}
				}
			} catch (Exception e) {
				condizione = true;
				LogColor.errorMessage("Qualcosa è andato storto, riprova");
			}
		}

	}

	// find: id ticket -> verifico punch==null -> mostrto lista viaggi -> find
	// voyageId -> Vehicle.punch ticketId
	/*
	Metodo che controlla il Ticket e' valido, se valido 
		- VISUALIZZA LISTA VIAGGI DISPONIBLI
		- USA TICKET
	Se ticket e' valido lo oblitera
	*/
	private static void checkTicket() {
		boolean condition = false;
		do {
			scanner.nextLine();
			LogColor.selectionMessage("Inserisci ID ticket da verificare, 0 per tornare al menu: ");

			try {
				Long ticketId = scanner.nextLong();

				if (ticketId > 0) {
					Ticket ticket = TicketDAO.getById(ticketId);

					if (ticket != null && ticket.getPunch() == null) {

						LogColor.infoMessage("*BIGLIETTO VALIDO*");
						LogColor.standardMessage("Lista viaggi disponibili:");
						printAllVoyage();

						scanner.nextLine();
						LogColor.selectionMessage("Seleziona id viaggio: ");
						Long voyageId = scanner.nextLong();
						Voyage voy = VoyageDAO.getById(voyageId);

						if (voy != null) {

							VehicleDAO.punch(ticket, voy.getVehicle());
							
							LogColor.infoMessage("BUON VIAGGIO");							
							

							condition = false;
						} else {
							condition = true;
							throw new Exception("Viaggio non trovato");
						}

					} else {
						condition = true;
						throw new Exception("Ticket non trovato o già obliterato");
					}

				} else {
					condition = false;
				}
			} catch (Exception e) {
				condition = true;
				LogColor.errorMessage(e.getMessage());
			}

		} while (condition);

	}
	
	/*
	Stampa tutti i viaggi mostrando solo ID, inizio tratta, fine tratta
	*/
	private static void printAllVoyage() {
		List<Voyage> allVoyages = VoyageDAO.getAll();
		for (Voyage v : allVoyages) {
			System.out.println("Voyage ID: " + LogColor.YELLOW(v.getId()+"" )
							+ " | From: " + LogColor.YELLOW(v.getRoute().getStart())
							+ " | To: " + LogColor.YELLOW(v.getRoute()	.getFinish()));
		}
		System.out.println();

	}

}
