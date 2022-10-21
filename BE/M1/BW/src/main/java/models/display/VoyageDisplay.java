package models.display;

import java.util.Scanner;
import java.util.List;
import utils.LogColor;
import models.Route;
import models.Vehicle;
import models.Voyage;
import models.dao.RouteDAO;
import models.dao.VehicleDAO;
import models.dao.VoyageDAO;

/*
Definizione dello scanner, console output
per interazione utente.

- MOSTRA LISTA VIAGGI
- CERCA PER VEICOLO ID e ROTTA ID (poi modifica)
- AGGIUNGI NUOVO VOYAGE (Veicolo ID e Route ID necessari)
*/
public class VoyageDisplay {

	static Scanner scanner = new Scanner(System.in);

	private static void printerVoyage(Voyage item) {

		StringBuilder vuotaGiu = new StringBuilder();
		for (String s : item.toString()
				.split("")) {
			vuotaGiu.append("-");
		}
		System.out.println(item);
		System.out.println(vuotaGiu);
	}

	private static void getVoyage() {
		System.out.println("Visualizza tutti i voyage");
		List<Voyage> database = VoyageDAO.getAll();
		try {
			for (Voyage data : database) {
				System.out.println(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void modaleVoyage() {

		boolean esegui = true;

		while (esegui) {

			System.out.println(LogColor.CYAN("*MENU VOYAGE*") + "\n" + " \n" 
			+ LogColor.GREEN("(0) ") + "Torna al " + LogColor.YELLOW("MENU PRINCIPALE") + "\n" 
			+ " | \n" 
			+ LogColor.GREEN("(1) ") + "Visualizza" + LogColor.YELLOW(" LISTA VOYAGES") + "\n" 
			+ " | \n" 
			+ LogColor.GREEN("(2) ") + "Cerca per" + LogColor.YELLOW(" VEICOLO ID e ROTTA ID (poi modifica)") + "\n" 
			+ " | \n" 
			+ LogColor.GREEN("(3) ")+ "Aggiungi" + LogColor.GREEN(" NUOVO VOYAGE (Veicolo ID e Route ID necessari)") + "\n");

			LogColor.selectionMessage("Digita da 0 a 3");
			try {

				int scelta = scanner.nextInt();
				long voyageId = 0;

				switch (scelta)
				{

				case 0 -> {
					LogColor.infoMessage("Torno al menu principale");
					esegui = false;
				}

				case 1 -> {
					LogColor.standardMessage("Lista Voyages:");
					getVoyage();
				}

				case 2 -> {					
					ricerca(voyageId);					
				}

				case 3 -> {
					aggiungiVoyage();
				}

				default -> {
					LogColor.errorMessage("Input fuori range. Riprova!");
				}
				}
			} catch (Exception e) {
				LogColor.errorMessage("Qualcosa è andato storto, riprova");
				scanner.nextLine();
			}

		}

	}

	private static int inserisciInt(String msg) {
		boolean isInt = true;
		while (isInt) {
			try {

				LogColor.selectionMessage("Inserisci " + msg + " : ");

				int inserito = Integer.parseInt(scanner.nextLine());

				isInt = false;

				return inserito;

			} catch (NumberFormatException e) {
				isInt = true;
			}
		}
		LogColor.errorMessage("Non so come ma sei arrivato qua");
		return (Integer) null;
	}

	private static long inserisciLong(String msg) {
		boolean isLong = true;
		while (isLong) {
			try {

				LogColor.selectionMessage("Inserisci " + msg + " : ");

				Long inserito = Long.parseLong(scanner.nextLine());

				isLong = false;

				return inserito;

			} catch (NumberFormatException e) {
				isLong = true;
			}
		}
		LogColor.errorMessage("Non so come ma sei arrivato qua");
		return (Integer) null;
	}

	private static void updateVoyageVehicleID(Voyage voyageSelezionato) {
		LogColor.selectionMessage("Inserisci nuovo valore per 'Vehicle ID': ");
		Long newVID = Long.parseLong(scanner.nextLine());

		if (VehicleDAO.getById(newVID) == null) {
			LogColor.errorMessage("Il Veicolo con ID " + newVID + " non esiste.");
		} else {
			LogColor.infoMessage("Modifico in " + newVID);

			VoyageDAO.refreshVehicle(voyageSelezionato, newVID);
		}
	}

	private static void updateVoyageRouteID(Voyage voyageSelezionato) {
		LogColor.selectionMessage("Inserisci nuovo valore per 'Route ID': ");
		Long newRID = Long.parseLong(scanner.nextLine());

		if (RouteDAO.getById(newRID) == null) {
			LogColor.errorMessage("La route con ID " + newRID + " non esiste.");
		} else {
			LogColor.infoMessage("Modifico in " + newRID);

			VoyageDAO.refreshRoute(voyageSelezionato, newRID);
		}
	}

	private static boolean updateVoyageAVGTime(Voyage voyageSelezionato, boolean isInt) {
		try {

			LogColor.selectionMessage("Inserisci nuovo valore per 'tempo medio percorrenza': ");

			int nuovoAVG = Integer.parseInt(scanner.nextLine());
			if (nuovoAVG <= 0) {
				throw new Exception("Il tempo medio deve essere maggiore di zero.");
			}

			isInt = false;

			LogColor.infoMessage("Modifico in " + nuovoAVG + " min");

			VoyageDAO.refreshAvgTime(voyageSelezionato, nuovoAVG);

		} catch (NumberFormatException nfe) {
			LogColor.errorMessage("Non e' stato inserito un numero, riprova!");
			scanner.nextLine();
		} catch (Exception e) {
			LogColor.errorMessage(e.getMessage());
		}
		
		return isInt;
	}

	private static void aggiungiVoyage() {
		boolean eseguiAggiunta = true;

		scanner.nextLine();
		while (eseguiAggiunta) {
		
		if (VehicleDAO.getAll().size() == 0|| RouteDAO.getAll().size() == 0) {
			LogColor.standardMessage("Non ci sono Veicoli o Route da associare, creali!");
			eseguiAggiunta = false;
		} else {
			try {
				LogColor.standardMessage("AGGIUNGI NUOVA VOYAGE");
				Long newVID = inserisciLong("ID del veicolo");
				Vehicle VHold = VehicleDAO.getById(newVID);

				if (VHold == null) {
					throw new Exception("ID inserito non corrisponde a nessun Vehicle.");
				}
				if (VHold.getIsService() == false) {
					throw new Exception("Veicolo inserito in manutenzione.");
				}

				Long newRID = inserisciLong("ID della tratta");
				Route RHold = RouteDAO.getById(newRID);
				if (RHold == null) {
					throw new Exception("ID inserito non corrisponde a nessuna Route");
				}

				int avg = inserisciInt("tempo medio percorrenza");

				Voyage nuovoVoy = new Voyage(VHold, RHold, avg);

				VoyageDAO.save(nuovoVoy);

				LogColor.infoMessage("Voyage salvato.");

				System.out.println(LogColor.CYAN("*VUOI CREARE UN ALTRO VOYAGE?*") + "\n" + " \n"
						+ LogColor.GREEN("(1) ") + LogColor.YELLOW(" SI") + "\n" + " | \n" + LogColor.GREEN("(2) ")
						+ LogColor.YELLOW(" NO") + "\n");

				int input = scanner.nextInt();

				if (input == 2) {
					LogColor.infoMessage("Torno al menu voyage...");
					eseguiAggiunta = false;
				}
			} catch (NumberFormatException nfe) {
				LogColor.errorMessage(nfe.getMessage());
			} catch (Exception e) {
				LogColor.errorMessage(e.getMessage());
			}
		}
		
		}
	}
	
	private static void ricerca(long voyageId){
		boolean esegui2 = true;
		int count = 0;

		while (esegui2) {
			if (count == 0) {
				scanner.nextLine();
			}
			count++;
						
						
			try {
							
				LogColor.standardMessage("Ricerca per veicolo ID e rotta ID poi modifica Voyage");

				LogColor.selectionMessage("Inserisci l'ID del veicolo:");
				int idVeicolo = Integer.parseInt(scanner.nextLine());

				LogColor.selectionMessage("Inserisci l'ID della route:'");
				int idRoute = Integer.parseInt(scanner.nextLine());

				LogColor.standardMessage("ricerco voyages...");

				List<Voyage> findedVoyage = VoyageDAO.getRouteByIDS(idVeicolo, idRoute);

				if (findedVoyage.isEmpty()) {
					LogColor.errorMessage("Nessun voyage trovato! Riprova.");
				} else if (findedVoyage.size() == 1) {
					LogColor.standardMessage("Trovata una sola corrispondenza"); 
					printerVoyage(findedVoyage.get(0));
					voyageId = findedVoyage.get(0).getId();
					LogColor.standardMessage("Seleziono automaticamente il voyage: " + voyageId);
					esegui2 = false;
				} else {
					LogColor.standardMessage("Trovati " + findedVoyage.size() + " risultati");

					for (Voyage rt : findedVoyage) {
						printerVoyage(rt);
					}

					LogColor.selectionMessage("Inserisci id voyage per selezionare");
					voyageId = scanner.nextInt();
					esegui2 = false;
				}						

				if (voyageId != 0) {
					boolean esegui3 = true;

					while (esegui3) {
						try {
							System.out.println(LogColor.CYAN("*SELEZIONA L'AZIONE*") + "\n" + " \n"
									+ LogColor.GREEN("(0) ") + "Torna al " + LogColor.YELLOW("MENU PRINCIPALE") + "\n" 
									+ " | \n"
									+ LogColor.GREEN("(1) ") + "Aggiorna" + LogColor.YELLOW(" DATI VOYAGE") + "\n" 
									+ " | \n" 
									+ LogColor.GREEN("(2) ") + "Elimina" + LogColor.YELLOW(" VOYAGE") + "\n"
									+ " | \n"
									+ LogColor.GREEN("(3) ") + "Visualizza" + LogColor.YELLOW(" STATISTICHE VIAGGIO	") + "\n");
							
							LogColor.selectionMessage("Digita da 0 a 3");

							int sceltaAzione = scanner.nextInt();

							switch (sceltaAzione)
							{
							case 0 -> {
								esegui3 = false;
							}
							case 1 -> {
								boolean esegui4 = true;

								while (esegui4) {

									System.out.println(LogColor.CYAN("*MODIFICA VOYAGE, SELEZIONA AZIONE*")
											+ "\n" + " \n" + LogColor.GREEN("(0) ") + LogColor.YELLOW("ANNULLA") + "\n" 
											+ " | \n"
											+ LogColor.GREEN("(1) ") + "Modifica" + LogColor.YELLOW(" VEHICLE ID") + "\n" 
											+ " | \n"
											+ LogColor.GREEN("(2) ") + "Modifica" + LogColor.YELLOW(" ROUTE ID") + "\n" 
											+ " | \n"
											+ LogColor.GREEN("(3) ") + "Modifica" + LogColor.YELLOW(" TEMPO MEDIO PERCORRENZA") + "\n");

									LogColor.selectionMessage("Digita da 0 a 3");

									int sceltaModifica = scanner.nextInt();
									
									Voyage voyageSelezionato = VoyageDAO.getById(voyageId);
									switch (sceltaModifica)
									{
									case 0 -> {
										esegui4 = false;
									}
									case 1 -> { 										
										updateVoyageVehicleID(voyageSelezionato);
									}
									case 2 -> {
										updateVoyageRouteID(voyageSelezionato);
									}
									case 3 -> {
										boolean isInt = true;
													
										while (isInt) {
											scanner.nextLine();
														
											isInt = updateVoyageAVGTime(voyageSelezionato, isInt);
										}

									}
									default -> System.out.println("Input non valido");
									}

								}
							}

							case 2 -> {

								System.out.println(
										LogColor.CYAN("*QUESTA AZIONE E' IRREVERSIBILE, CONTINUARE?*")
												+ "\n" + " \n" + LogColor.GREEN("(1) ")
												+ LogColor.YELLOW("SI") + "\n" + " | \n"
												+ LogColor.GREEN("(2) ") + LogColor.YELLOW("NO") + "\n");
								
								LogColor.selectionMessage("Digita 1 o 2");

								int sceltaEliminazione = scanner.nextInt();

								if (sceltaEliminazione == 1) {
									VoyageDAO.delete(VoyageDAO.getById(voyageId));
									LogColor.infoMessage("Voyage eliminato.");
									esegui3 = false;
								} else {
									LogColor.standardMessage("Annullo scelta");
									esegui3 = false;
								}
							}
							case 3 -> {
								LogColor.infoMessage("Statistiche Viaggio ID "+voyageId);
								Voyage voyHold = VoyageDAO.getById(voyageId); 
								VehicleDAO.vehicleTracker(voyHold.getVehicle().getId(), voyHold.getRoute().getId());
										
							}
							}

						} catch (Exception e) {
							LogColor.errorMessage("Qualcosa è andato storto, riprova" + e);
						}
					}
				}

			} catch (NumberFormatException nfe) {
				LogColor.errorMessage(nfe.getMessage());
				scanner.nextLine();
			} catch (Exception e) {
				LogColor.errorMessage("Qualcosa è andato storto, riprova!" + e);
				scanner.nextLine();
			}
		}
	}
}
