package models.display;

import java.util.List;
import java.util.Scanner;

import models.Route;
import models.dao.RouteDAO;
import utils.LogColor;

/*
Definizione dello scanner, console output
per interazione utente.

- MOSTRA LISTA ROUTES
- CERCA PER INIZIO E FINE TRATTA (poi modifica)
- AGGIUNGI NUOVA ROUTE
*/
public abstract class RouteDisplay {

	static Scanner scanner = new Scanner(System.in);

	private static void printerRoute(Route item) {

		StringBuilder vuotaGiu = new StringBuilder();

		for (String s : item.toString()
				.split("")) {
			vuotaGiu.append("-");
		}
		System.out.println(item);
		System.out.println(vuotaGiu);
	}

	private static void getRoute() {
		List<Route> database = RouteDAO.getAll();

		for (Route data : database) {
			printerRoute(data);
		}
	}

	public static void modaleRoute() {

		boolean esegui = true;

		while (esegui) {
			System.out.println(LogColor.CYAN("*MENU ROUTES*") + "\n" + " \n" 
			+ LogColor.GREEN("(0) ") + "Torna al " + LogColor.YELLOW("MENU PRINCIPALE") + "\n" 
			+ " | \n" 
			+ LogColor.GREEN("(1) ") + "Mostra" + LogColor.YELLOW(" LISTA ROUTES	") + "\n" 
			+ " | \n" 
			+ LogColor.GREEN("(2) ") + "Cerca per" + LogColor.YELLOW(" INIZIO e FINE TRATTA (poi modifica)") + "\n" 
			+ " | \n" 
			+ LogColor.GREEN("(3) ") + "Aggiungi" + LogColor.GREEN(" NUOVA ROUTE") + "\n");
					
			LogColor.selectionMessage("Seleziona da 0 a 3");
			
			try {

				int scelta = scanner.nextInt();

				switch (scelta)
				{

				case 0 -> {
					LogColor.infoMessage("Torno al menu principale");
					esegui = false;
				}

				case 1 -> {
					LogColor.standardMessage("Mostro tutte le routes:");
					getRoute();
				}

				case 2 -> {
					findRoute();
				}

				case 3 -> {
					LogColor.standardMessage("AGGIUNGI NUOVA ROUTE");
					addRoute();
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

	private static void findRoute() {

		long routeId = 0;

		boolean esegui2 = true;
		int count = 0;

		while (esegui2) {
			if (count == 0) {
				scanner.nextLine();
			}
			count++;

			try {
				LogColor.standardMessage("Ricerca per inizio e fine tratta");

				LogColor.selectionMessage("Inserisci l'inizio della tratta'");
				String inizio = scanner.nextLine();

				LogColor.selectionMessage("Inserisci la fine della tratta");
				String fine = scanner.nextLine();

				LogColor.standardMessage("ricerco tratte...");

				List<Route> findedRoutes = RouteDAO.getRouteBySF(inizio, fine);

				if (findedRoutes.isEmpty()) {
					LogColor.errorMessage("Nessuna route trovata! Riprova.");
				} else if (findedRoutes.size() == 1) {
					LogColor.standardMessage("Trovata una sola corrispondenza");
					printerRoute(findedRoutes.get(0));
					routeId = findedRoutes.get(0)
							.getId();
					LogColor.standardMessage("Seleziono automaticamente la route: " + routeId);
					esegui2 = false;
				} else {
					LogColor.standardMessage("Trovati " + findedRoutes.size() + " risultati");

					for (Route rt : findedRoutes) {
						printerRoute(rt);
					}

					LogColor.selectionMessage("Inserisci id rotta per selezionare");
					routeId = scanner.nextInt();
					esegui2 = false;
				}

				if (routeId != 0) {
					boolean esegui3 = true;

					while (esegui3) {
						try {

							System.out.println(LogColor.CYAN("*SCEGLI AZIONE*") + "\n" + " \n" + LogColor.GREEN("(0) ")
									+ "Torna al " + LogColor.YELLOW("MENU PRINCIPALE") + "\n" + " | \n"
									+ LogColor.GREEN("(1) ") + "Aggiorna" + LogColor.YELLOW(" DATI ROUTES	") + "\n"
									+ " | \n" + LogColor.GREEN("(2) ") + "Elimina" + LogColor.RED(" ROUTE") + "\n");
							LogColor.selectionMessage("Seleziona da 0 a 2");
							int sceltaAzione = scanner.nextInt();

							switch (sceltaAzione)
							{
							case 0 -> {
								esegui3 = false;
							}
							case 1 -> {
								chooseAction(routeId);
							}

							case 2 -> {
								esegui3 = routeDelete(routeId);
							}
							}

						} catch (Exception e) {
							LogColor.errorMessage("Qualcosa è andato storto, riprova");
							scanner.nextLine();
						}
					}
				}

			} catch (Exception e) {
				LogColor.errorMessage("Qualcosa è andato storto, riprova!");
				scanner.nextLine();
			}
		}
	}

	private static void addRoute() {
		boolean eseguiAggiunta = true;

		while (eseguiAggiunta) {
			scanner.nextLine();
			try {
				LogColor.selectionMessage("Inserisci inizio tratta");
				String inizio = scanner.nextLine();

				LogColor.selectionMessage("Inserisci fine tratta");
				String fine = scanner.nextLine();

				LogColor.selectionMessage("Inserisci tempo percorrenza");
				int tp = Integer.parseInt(scanner.nextLine());
				if (tp <= 0) {
					throw new Exception("La durata deve essere maggiore di zero.");
				}

				Route nuova = new Route(inizio, fine, tp);

				RouteDAO.save(nuova);

				System.out.println(LogColor.CYAN("*VUOI CREARE UN ALTRA ROUTE*") + "\n" + " \n" + LogColor.GREEN("(1) ")
						+ LogColor.YELLOW(" SI") + "\n" + " | \n" + LogColor.GREEN("(2) ") + LogColor.YELLOW(" NO")
						+ "\n");

				int input = scanner.nextInt();

				if (input == 2) {
					LogColor.infoMessage("Torno al menu route...");
					eseguiAggiunta = false;
				}

			} catch (Exception e) {
				LogColor.errorMessage(e.getMessage());
				scanner.nextLine();
			}
		}
	}

	private static void chooseAction(Long routeId) {
		boolean esegui4 = true;

		while (esegui4) {

			System.out.println(LogColor.CYAN("*SCEGLI AZIONE*") + "\n" + " \n" + LogColor.GREEN("(0) ")
					+ LogColor.YELLOW("ANNULLA") + "\n" + " | \n" + LogColor.GREEN("(1) ")
					+ LogColor.YELLOW(" INIZIO TRATTA") + "\n" + " | \n" + LogColor.GREEN("(2) ")
					+ LogColor.YELLOW(" FINE TRATTA") + "\n" + " | \n" + LogColor.GREEN("(3) ")
					+ LogColor.YELLOW(" DURATA TRAGITTO") + "\n");

			int sceltaModifica = scanner.nextInt();

			Route routeSelezionato = RouteDAO.getById(routeId);
			switch (sceltaModifica)
			{
			case 0 -> {
				esegui4 = false;
			}
			case 1 -> {
				scanner.nextLine();
				LogColor.selectionMessage("Inserisci nuovo valore per 'inizio tratta': ");
				String nuovoInizio = scanner.nextLine();

				LogColor.standardMessage("Modifico in " + nuovoInizio);

				RouteDAO.refreshStart(routeSelezionato, nuovoInizio);

			}
			case 2 -> {
				scanner.nextLine();
				LogColor.selectionMessage("Inserisci nuovo valore per 'fine tratta': ");
				String nuovaFine = scanner.nextLine();

				LogColor.standardMessage("Modifico in " + nuovaFine);

				RouteDAO.refreshFinish(routeSelezionato, nuovaFine);
			}
			case 3 -> {

				boolean isInt = true;

				while (isInt) {
					scanner.nextLine();
					try {

						LogColor.selectionMessage("Inserisci nuovo valore per 'durata tragitto': ");

						int nuovoTT = Integer.parseInt(scanner.nextLine());
						if (nuovoTT <= 0) {
							throw new Exception("La durata deve essere maggiore di zero");
						}

						isInt = false;

						LogColor.standardMessage("Modifico in " + nuovoTT + " min");

						RouteDAO.refreshTT(routeSelezionato, nuovoTT);

					} catch (NumberFormatException nfe) {
						LogColor.errorMessage("Qualcosa è andato storto, riprova!");
						scanner.nextLine();
					} catch (Exception e) {
						LogColor.errorMessage(e.getMessage());
					}
				}

			}
			default -> LogColor.errorMessage("Input non valido");
			}

		}
	}

	private static boolean routeDelete(Long routeId) {
		System.out.println(LogColor.CYAN("*QUESTA AZIONE E' IRREVERSIBILE*") + "\n" + " \n" + LogColor.GREEN("(1) ")
				+ LogColor.YELLOW(" CONFERMA") + "\n" + " | \n" + LogColor.GREEN("(2) ") + LogColor.YELLOW(" ANNULLA")
				+ "\n");

		int sceltaEliminazione = scanner.nextInt();

		if (sceltaEliminazione == 1) {
			RouteDAO.delete(RouteDAO.getById(routeId));
			return false;
		} else {
			LogColor.standardMessage("Annullo scelta");
			return true;
		}
	}

}
