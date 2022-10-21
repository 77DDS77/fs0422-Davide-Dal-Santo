package models.display;

import utils.LogColor;

import java.util.Scanner;

/*
SCANNER PRINCIPALE
Da qui si diramano tutti gli altri scanner

Definizione dello scanner, console output
per interazione utente.

- ENTRA IN BIGLIETTERIA
- MENU UTENTE
- ENTRA NEL PARCO VEICOLI
- VAI ALLE ROTTE DI VIAGGIO
- EFFETTUA UN VIAGGIO
- MODALITA' CONTROLLORE
*/
public class PrincipalDisplay {
    static Scanner scanner = new Scanner(System.in);
    
    public static void open() {
        boolean eseguiPrincipalDisplay = true;

        while( eseguiPrincipalDisplay ) {

            try {
                System.out.println(LogColor.CYAN( "BENVENUTI IN TRAVEL SIMULATOR" ) + "\n" + " \n" +
                        LogColor.GREEN( "(1) " ) + "Entra in " + LogColor.YELLOW( "BIGLIETTERIA" )  + "\n" +
                        " | \n" +
                        LogColor.GREEN( "(2) " ) + "Menu" + LogColor.YELLOW( " UTENTE" )  + "\n" +
                        " | \n" +
                        LogColor.GREEN( "(3) " ) + "Entra nel" + LogColor.YELLOW( " PARCO VEICOLI" )  + "\n" +
                        " | \n" +
                        LogColor.GREEN( "(4) " ) + "Modalità" + LogColor.YELLOW( " ROTTE"  ) + " di viaggio" +
                        "\n" + " | \n" +
                        LogColor.GREEN( "(5) " ) + "Entra in " + LogColor.YELLOW( "STAZIONE") + "\n" +
                        " | \n" +
                        LogColor.GREEN( "(6) " ) + "Modalità " + LogColor.YELLOW( "CONTROLLORE") + "\n" +
                        "");

                LogColor.selectionMessage( "Seleziona da 0 a 6" );
                int selezione = scanner.nextInt();

                switch (selezione) {
                    case 0 -> { //esci dal programma
                    	LogColor.infoMessage( "ARRIVEDERCI <3 <3" );
                        eseguiPrincipalDisplay = false;
                    }

                    case 1 -> { //entra nello scanner Reseller
                    	LogColor.infoMessage( "Hai scelto biglietteria" );
                        ResellerDisplay.modaleReseller();
                    }

                    case 2 -> { //entra nello scanner Utente
                    	LogColor.infoMessage( "Hai scelto menu utente" );
                        UserDisplay.modaleUtente();
                    }

                    case 3 -> { //entra nello scanner Vehicle
                        LogColor.infoMessage( "Hai scelto parco veicoli" );
                        VehicleDisplay.modaleVehicle();
                    }

                    case 4 -> { //entra nello scanner Route
                        LogColor.infoMessage( "Hai scelto rotte di viaggio" );
                        RouteDisplay.modaleRoute();

                    }

                    case 5 -> { //entra nello scanner Voyage
                        LogColor.infoMessage( "Hai scelto effettua un viaggio" );
                        VoyageDisplay.modaleVoyage();
                    }

                    case 6 -> { //entra nello scanner Inspector/Voyage
                        LogColor.infoMessage( "Hai scelto controllore" );
                        InspectorDisplay.modaleInspector();
                    }

                    default -> {
                    	LogColor.errorMessage( "Inserisci un'input valido!" );
                    }
                }

            } catch( Exception e ) {

                LogColor.errorMessage( "Si accettano solo interi da 0 a 6, riprova!" );
                scanner.nextLine();

            }
        }
    }
}
