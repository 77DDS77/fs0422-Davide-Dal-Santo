package models.display;

import models.*;
import models.dao.*;
import utils.LogColor;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/*
Definizione dello scanner, console output
per interazione utente.

- ACQUISTA BIGLIETTO
- ACQUISTA ABBONAMENTO
- CREA TESSERA UTENTE
- RINNOVA TESSERA UTENTE SCADUTA
- VISUALIZZA LISTA BIGLIETTERIE
- RICERCA/MOSTRA BIGLIETTI VENDUTI DA UNA BIGLIETTERIA
- AGGIUNGI NUOVA BIGLIETTERIA
- ELIMINA BIGLIETTERIA
*/
public class ResellerDisplay {    
    
    static UserCardDAO userCardDAO = new UserCardDAO();

    static TicketDAO ticketDAO = new TicketDAO();

    static SeasonTicketDAO seasonTicketDAO = new SeasonTicketDAO();

    static Scanner scanner = new Scanner( System.in );

    private static void printerUtente( User item ) {

        StringBuilder vuotaGiu = new StringBuilder();

        for( String s : item.toString().split( "" ) ) {
            vuotaGiu.append( "-" );
        }
        System.out.println( item );
        System.out.println( vuotaGiu );
    }

    private static void getBiglietterie() {
        LogColor.infoMessage( "Visualizzo il biglietterie" );
        List<Reseller> database = ResellerDAO.getAll();

        for( Reseller data : database ) {
            printerReseller( data );
        }
    }

    private static void printerReseller( Reseller item ) {

        StringBuilder vuotaGiu = new StringBuilder();

        for( String s : item.toString().split( "" ) ) {
            vuotaGiu.append( "-" );
        }
        System.out.println( item );
        System.out.println( vuotaGiu );
    }

    private static Periodicity determinaPeriodicity( String str ) {
        return switch (str) {
            case "SETTIMANALE" -> Periodicity.WEEKLY;
            case "MENSILE" -> Periodicity.MONTHLY;
            case "ANNUALE" -> Periodicity.YEARLY;
            default -> Periodicity.WEEKLY;
        };
    }

    public static void modaleReseller() {

        boolean esegui = true;

        while( esegui ) {
            System.out.println( LogColor.CYAN( "*BIGLIETTERIA*" ) + "\n" + " \n" +
                    LogColor.GREEN( "(0) " ) + "Torna al " + LogColor.YELLOW( "MENU PRINCIPALE" ) + "\n" +
                    " | \n" +
                    LogColor.GREEN( "(1) " ) + "Acquista" + LogColor.YELLOW( " BIGLIETTO" ) + "\n" +
                    " | \n" +
                    LogColor.GREEN( "(2) " ) + "Acquista" + LogColor.YELLOW( " ABBONAMENTO" ) + "\n" +
                    " | \n" +
                    LogColor.GREEN( "(3) " ) + "Acquista" + LogColor.YELLOW( " TESSERA UTENTE" ) + "\n" +
                    " | \n" +
                    LogColor.GREEN( "(4) " ) + "Rinnova " + LogColor.YELLOW( "TESSERA SCADUTA" ) + "\n" +
                    " | \n" +
                    LogColor.GREEN( "(5) " ) + "Visualizza " + LogColor.YELLOW( "LISTA BIGLIETTERIE" ) + "\n" +
                    " | \n" +
                    LogColor.GREEN( "(6) " ) + "Ricerca " + LogColor.YELLOW( "BIGLIETTI/ABBONAMENTI" ) + " emessi da " +
                    "una " +
                    "biglietteria" + "\n" +
                    " | \n" +
                    LogColor.GREEN( "(7) " ) + "Cambia stato " + LogColor.YELLOW( "DISTRIBUTORE AUTOMATICO" ) + "\n" +
                    " | \n" +
                    LogColor.GREEN( "(8) " ) + "Aggiungi " + LogColor.GREEN( "NUOVA BIGLIETTERIA" ) + "\n" +
                    " | \n" +
                    LogColor.GREEN( "(9) " ) + "Elimina " + LogColor.RED( "BIGLIETTERIA" ) + "\n" +
                    "" );

            LogColor.selectionMessage("Digita da 0 a 8");
            try {
                int scelta = scanner.nextInt();


                switch (scelta) {
                    case 0 -> {
                        LogColor.infoMessage( "Torno al menu principale" );
                        esegui = false;
                    }

                    case 1 -> {
                        acquistaBiglietto();
                    }

                    case 2 -> {
                        acquistaAbbonamento();                        
                    }

                    case 3 -> {
                        acquistaTesseraUtente();
                    }

                    case 4 -> {
                        rinnovaTesseraScaduta();
                    }

                    case 5 -> {
                        getBiglietterie();
                    }

                    case 6 -> {
                        bigliettiEmessiDaBiglietteria();                        
                    }

                    case 7 -> {
                    	updateResellerState();
                    }

                    case 8 -> {
                        nuovaBiglietteria();
                    }

                    case 9 -> {
                        eliminaBiglietteria();
                    }

                    default -> {
                        LogColor.errorMessage( "Input fuori range. Riprova!" );

                    }
                }
            } catch( Exception e ) {
                LogColor.errorMessage( "Qualcosa e' andato storto, riprova" );
                scanner.nextLine();
            }
        }


    }
    
    /*
    	METODI SELF EXPLAINING
    */
    private static void acquistaBiglietto(){
        boolean eseguiCreazioneTicket = true;
                        int count = 0;
                        while( eseguiCreazioneTicket ) {
                            if( count == 0 ) {
                                scanner.nextLine();
                                count++;
                            }
                            try {
                                LogColor.infoMessage( "Hai scelto acquisto biglietto" );
                                LogColor.selectionMessage( "Inserisci il nome del punto vendita" );
                                String nomePuntoVendita = scanner.nextLine();
                                LogColor.infoMessage( "Il nome scelto e': " + nomePuntoVendita );
                                List<Reseller> puntoVendita = ResellerDAO.getByName( nomePuntoVendita );

                                if( puntoVendita.size() == 0 ) {

                                    LogColor.errorMessage( "Nessun punto vendita trovato! Riprova." );
                                    eseguiCreazioneTicket = false;

                                } else if( puntoVendita.size() == 1 ) {

                                    LogColor.infoMessage( "Trovata una sola corrispondenza, " + puntoVendita.get( 0 ) );


                                    ResellerDAO.makeTiket( puntoVendita.get( 0 ) );
                                    eseguiCreazioneTicket = false;


                                } else if( puntoVendita.size() > 1 ) {

                                    LogColor.infoMessage( "Trovate piu' corrispondenze" );

                                    for( Reseller myNegozio : puntoVendita ) {
                                        printerReseller( myNegozio );
                                    }

                                    LogColor.selectionMessage( "Seleziona l'id desiderato" );
                                    long codiceScelto = scanner.nextInt();

                                    Reseller resellerScelto = ResellerDAO.getById( codiceScelto );
                                    ResellerDAO.makeTiket( resellerScelto );

                                    eseguiCreazioneTicket = false;

                                    LogColor.infoMessage( "Biglietto acquistato" );
                                }
                            } catch( Exception e ) {
                                LogColor.errorMessage( "Qualcosa e' andato storto, riprova!" );
                                scanner.nextLine();
                            }
                        }
    }
    
    private static void acquistaAbbonamento(){
        boolean eseguiAcquistoAbbonamento = true;
                        int count = 0;

                        while( eseguiAcquistoAbbonamento ) {
                            if( count == 0 ) {

                                scanner.nextLine();
                                count++;

                            }
                            try {

                                LogColor.infoMessage( "Hai scelto acquisto abbonamento" );
                                LogColor.selectionMessage( "Inserisci il codice utente, digita -1 per annullare " );
                                long codiceUtente = scanner.nextInt();

                                if( codiceUtente == -1 ) {
                                    eseguiAcquistoAbbonamento = false;
                                } else {
                                    User utenteFinded = UserDAO.getById( codiceUtente );

                                    if( utenteFinded != null ) {

                                        LogColor.infoMessage( "Utente scelto: " + utenteFinded );
                                        List<UserCard> cardList = userCardDAO.getCardByUserId( utenteFinded.getId() );

                                        if( cardList.size() == 1 && cardList.get( 0 ).getExpireDate().compareTo( LocalDate.now() ) > 0 ) {

                                            scanner.nextLine();
                                            LogColor.selectionMessage( "Inserisci il nome del punto vendita" );
                                            String nomePuntoVendita = scanner.nextLine();

                                            LogColor.infoMessage( "Il nome scelto e': " + nomePuntoVendita );
                                            List<Reseller> puntoVendita = ResellerDAO.getByName( nomePuntoVendita );

                                            if( puntoVendita.size() == 0 ) {
                                                LogColor.errorMessage( "Nessun punto vendita trovato! Riprova." );
                                                eseguiAcquistoAbbonamento = false;


                                            } else if( puntoVendita.size() == 1 ) {
                                                LogColor.infoMessage( "Trovata una sola corrispondenza, " + puntoVendita.get( 0 ) );
                                                LogColor.infoMessage( "Scegli il tipo di abbonamento, SETTIMANALE, MENSILE O ANNUALE" );
                                                System.out.println( LogColor.YELLOW( "Se il campo e' vuoto o diverso dai " +
                                                        "suddetti, verra' " +
                                                        "scelto il settimanale" ) );

                                                String periodicity = scanner.nextLine();
                                                Periodicity periodicityScelta = determinaPeriodicity( periodicity );
                                                ResellerDAO.makeSeasonTiket( puntoVendita.get( 0 ), utenteFinded, periodicityScelta );
                                                eseguiAcquistoAbbonamento = false;

                                            } else if( puntoVendita.size() > 1 ) {

                                                LogColor.infoMessage( "Trovate pia' corrispondenze" );

                                                for( Reseller myNegozio : puntoVendita ) {

                                                    printerReseller( myNegozio );

                                                }
                                                LogColor.selectionMessage( "Seleziona l'id desiderato" );
                                                long codiceScelto = scanner.nextInt();

                                                Reseller resellerScelto = ResellerDAO.getById( codiceScelto );
                                                scanner.nextLine();

                                                LogColor.infoMessage( "Scegli il tipo di abbonamento, SETTIMANALE, MENSILE O ANNUALE" );
                                                System.out.println( LogColor.YELLOW( "Se il campo e' vuoto o diverso dai suddetti," +
                                                        " verra'  " +
                                                        "scelto il settimanale" ) );
                                                String periodicity = scanner.nextLine().toUpperCase();

                                                Periodicity periodicityScelta = determinaPeriodicity( periodicity );
                                                ResellerDAO.makeSeasonTiket( resellerScelto, utenteFinded, periodicityScelta );

                                                eseguiAcquistoAbbonamento = false;
                                            }
                                        } else {
                                            LogColor.errorMessage( "L'utente non ha la tessera o e' scaduta, verrai rispedito al menu!" );
                                            eseguiAcquistoAbbonamento = false;
                                        }

                                    } else {
                                        LogColor.errorMessage( "Utente non trovato riprova!" );
                                    }
                                }


                            } catch( Exception e ) {
                                LogColor.errorMessage( "Qualcosa e' andato storto, riprova!" );
                                scanner.nextLine();
                            }
                        }
    }
    
    private static void acquistaTesseraUtente(){
        boolean eseguiAggiuntaTesseraUtente = true;
                        long userId = 0;

                        while( eseguiAggiuntaTesseraUtente ) {
                            scanner.nextLine();
                            try {
                                System.out.println( LogColor.CYAN( "AGGIUNGI UNA NUOVA TESSERA UTENTE" ) );
                                LogColor.infoMessage( "Ricerca per nome e cognome" );

                                LogColor.selectionMessage( "Inserisci il nome dell'utente" );
                                String nome = scanner.nextLine();

                                LogColor.selectionMessage( "Inserisci il cognome dell'utente'" );
                                String cognome = scanner.nextLine();

                                LogColor.infoMessage( "ricerco utenti..." );

                                List<User> findedUtenti = UserDAO.getUserByFullName( nome, cognome );

                                if( findedUtenti.isEmpty() ) {

                                    LogColor.errorMessage( "Nessun utente trovato! Riprova." );

                                } else if( findedUtenti.size() == 1 ) {

                                    LogColor.infoMessage( "Trovata una sola corrispondenza" );
                                    printerUtente( findedUtenti.get( 0 ) );
                                    userId = findedUtenti.get( 0 ).getId();
                                    LogColor.infoMessage( "Seleziono automaticamente il numero tessera: " + userId );

                                    ResellerDAO.makeCard( findedUtenti.get( 0 ) );

                                    eseguiAggiuntaTesseraUtente = false;
                                } else {
                                    LogColor.infoMessage( "Trovati " + findedUtenti.size() + " risultati" );

                                    for( User ut : findedUtenti ) {
                                        printerUtente( ut );
                                    }

                                    LogColor.selectionMessage( "Inserisci id per selezionare l'utente" );
                                    userId = scanner.nextInt();
                                    eseguiAggiuntaTesseraUtente = false;

                                    ResellerDAO.makeCard( UserDAO.getById( userId ) );
                                }

                            } catch( Exception e ) {
                                LogColor.errorMessage( "Qualcosa e' andato storto, riprova!" );
                                scanner.nextLine();
                            }
                        }
    }
    
    private static void rinnovaTesseraScaduta(){
        boolean eseguiRinnovoTesseraUtente = true;
                        long userId = 0;

                        while( eseguiRinnovoTesseraUtente ) {
                            scanner.nextLine();
                            try {
                                System.out.println( LogColor.CYAN( "RINNOVA UNA  TESSERA UTENTE" ) );
                                LogColor.infoMessage( "Ricerca per nome e cognome" );

                                LogColor.selectionMessage( "Inserisci il nome dell'utente" );
                                String nome = scanner.nextLine();

                                LogColor.selectionMessage( "Inserisci il cognome dell'utente'" );
                                String cognome = scanner.nextLine();

                                LogColor.infoMessage( "ricerco utenti..." );

                                List<User> findedUtenti = UserDAO.getUserByFullName( nome, cognome );

                                if( findedUtenti.isEmpty() ) {

                                    LogColor.errorMessage( "Nessun utente trovato! Riprova." );

                                } else if( findedUtenti.size() == 1 ) {

                                    LogColor.infoMessage( "Trovata una sola corrispondenza" );
                                    printerUtente( findedUtenti.get( 0 ) );
                                    userId = findedUtenti.get( 0 ).getId();
                                    LogColor.infoMessage( "Seleziono automaticamente il numero tessera: " + userId );

                                    List<UserCard> cardUser = userCardDAO.getCardByUserId( userId );

                                    ResellerDAO.renewCard( cardUser.get( 0 ) );

                                    eseguiRinnovoTesseraUtente = false;
                                } else {
                                    LogColor.infoMessage( "Trovati " + findedUtenti.size() + " risultati" );

                                    for( User ut : findedUtenti ) {
                                        printerUtente( ut );
                                    }

                                    LogColor.selectionMessage( "Inserisci id per selezionare l'utente" );
                                    userId = scanner.nextInt();


                                    List<UserCard> cardUser = userCardDAO.getCardByUserId( userId );

                                    ResellerDAO.renewCard( cardUser.get( 0 ) );

                                    eseguiRinnovoTesseraUtente = false;
                                }

                            } catch( Exception e ) {
                                LogColor.errorMessage( "Qualcosa e' andato storto, riprova!" );
                                scanner.nextLine();
                            }
                        }
    }
    
    private static void bigliettiEmessiDaBiglietteria(){
        boolean eseguiStatisticheVendita = true;
                        int count = 0;

                        while( eseguiStatisticheVendita ) {
                            if( count == 0 ) {
                                scanner.nextLine();
                                count++;
                            }
                            try {
                                System.out.println( LogColor.CYAN( "STATISTICHE DI VENDITA BIGLIETTERIA" ) );
                                LogColor.selectionMessage( "Inserisci il nome del punto vendita" );
                                String nomePuntoVendita = scanner.nextLine();

                                LogColor.infoMessage( "Il nome scelto e': " + nomePuntoVendita );
                                List<Reseller> puntoVendita = ResellerDAO.getByName( nomePuntoVendita );

                                if( puntoVendita.size() == 0 ) {
                                    LogColor.errorMessage( "Nessun punto vendita trovato! Riprova." );
                                    eseguiStatisticheVendita = false;


                                } else if( puntoVendita.size() == 1 ) {
                                    LogColor.infoMessage( "Trovata una sola corrispondenza, " + puntoVendita.get( 0 ) );

                                    LogColor.selectionMessage( "Inserisci data inizio formato YYYY/M/D " );
                                    String dataInizio = scanner.nextLine();
                                    String[] dataInizioStringa = dataInizio.split( "/" );
                                    int anno = Integer.parseInt( dataInizioStringa[ 0 ] );
                                    int mese = Integer.parseInt( dataInizioStringa[ 1 ] );
                                    int giorno = Integer.parseInt( dataInizioStringa[ 2 ] );

                                    LocalDate dataInizioParametro = LocalDate.of( anno, mese, giorno );

                                    LogColor.selectionMessage( "Inserisci data fine formato YYYY/M/D " );
                                    String dataFine = scanner.nextLine();

                                    String[] dataFineStringa = dataFine.split( "/" );
                                    int annof = Integer.parseInt( dataFineStringa[ 0 ] );
                                    int mesef = Integer.parseInt( dataFineStringa[ 1 ] );
                                    int giornof = Integer.parseInt( dataFineStringa[ 2 ] );

                                    LocalDate dataFineParametro = LocalDate.of( annof, mesef, giornof );

                                    LogColor.selectionMessage( """
                                            Vuoi cercare statistiche : \s
                                            1. Biglietti
                                            2. Abbonamenti""" );

                                    int sceltaStatistiche = scanner.nextInt();

                                    if( sceltaStatistiche == 1 ) {
                                        List<Ticket> ticketsFinded =
                                                ticketDAO.getTicketByReseller( puntoVendita.get( 0 ).getId(),
                                                        dataInizioParametro, dataFineParametro );

                                        LogColor.infoMessage( "Il negozio " + LogColor.GREEN( puntoVendita.get( 0 ).getName() ) +
                                                " ha venduto nel periodo che va da " + LogColor.GREEN( dataInizioParametro.toString() ) +
                                                " a " +
                                                LogColor.GREEN( dataFineParametro.toString() ) + " un totale di " +
                                                LogColor.GREEN( String.valueOf( ticketsFinded.size() ) ) + " biglietti." );

                                        eseguiStatisticheVendita = false;
                                    }
                                    if( sceltaStatistiche == 2 ) {

                                        List<SeasonTicket> ticketsFinded =
                                                seasonTicketDAO.getSeasonTicketByReseller( puntoVendita.get( 0 ).getId(),
                                                        dataInizioParametro, dataFineParametro );

                                        LogColor.infoMessage( "Il negozio " + LogColor.GREEN( puntoVendita.get( 0 ).getName() ) +
                                                " ha venduto nel periodo che va da " + LogColor.GREEN( dataInizioParametro.toString() ) +
                                                " a " +
                                                LogColor.GREEN( dataFineParametro.toString() ) + " un totale di " +
                                                LogColor.GREEN( String.valueOf( ticketsFinded.size() ) ) + " " +
                                                "abbonamenti" +
                                                "." );
                                        eseguiStatisticheVendita = false;

                                    } else {
                                        System.out.println( "Fatti ricoverare" );
                                        eseguiStatisticheVendita = false;
                                    }
                                } else if( puntoVendita.size() > 1 ) {

                                    LogColor.infoMessage( "Trovate più corrispondenze" );

                                    for( Reseller myNegozio : puntoVendita ) {

                                        printerReseller( myNegozio );

                                    }
                                    LogColor.selectionMessage( "Seleziona l'id desiderato" );
                                    long codiceScelto = scanner.nextInt();

                                    Reseller resellerScelto = ResellerDAO.getById( codiceScelto );
                                    scanner.nextLine();

                                    LogColor.selectionMessage( "Inserisci data inizio formato YYYY/M/D " );
                                    String dataInizio = scanner.nextLine();
                                    String[] dataInizioStringa = dataInizio.split( "/" );
                                    int anno = Integer.parseInt( dataInizioStringa[ 0 ] );
                                    int mese = Integer.parseInt( dataInizioStringa[ 1 ] );
                                    int giorno = Integer.parseInt( dataInizioStringa[ 2 ] );

                                    LocalDate dataInizioParametro = LocalDate.of( anno, mese, giorno );

                                    LogColor.selectionMessage( "Inserisci data fine formato YYYY/M/D " );
                                    String dataFine = scanner.nextLine();

                                    String[] dataFineStringa = dataFine.split( "/" );
                                    int annof = Integer.parseInt( dataFineStringa[ 0 ] );
                                    int mesef = Integer.parseInt( dataFineStringa[ 1 ] );
                                    int giornof = Integer.parseInt( dataFineStringa[ 2 ] );

                                    LocalDate dataFineParametro = LocalDate.of( annof, mesef, giornof );

                                    scanner.nextLine();
                                    LogColor.selectionMessage( """
                                            Vuoi cercare statistiche : \s
                                            1. Biglietti
                                            2. Abbonamenti""" );

                                    int sceltaStatistiche = scanner.nextInt();

                                    if( sceltaStatistiche == 1 ) {
                                        List<Ticket> ticketsFinded =
                                                ticketDAO.getTicketByReseller( resellerScelto.getId(),
                                                        dataInizioParametro, dataFineParametro );

                                        LogColor.infoMessage( "Il negozio " + LogColor.GREEN( resellerScelto.getName() ) +
                                                " ha venduto nel periodo che va da " + LogColor.GREEN( dataInizioParametro.toString() ) +
                                                " a " +
                                                LogColor.GREEN( dataFineParametro.toString() ) + " un totale di " +
                                                LogColor.GREEN( String.valueOf( ticketsFinded.size() ) ) + " biglietti." );

                                        eseguiStatisticheVendita = false;
                                    }
                                    if( sceltaStatistiche == 2 ) {

                                        List<SeasonTicket> ticketsFinded =
                                                seasonTicketDAO.getSeasonTicketByReseller( resellerScelto.getId(),
                                                        dataInizioParametro, dataFineParametro );

                                        LogColor.infoMessage( "Il negozio " + LogColor.GREEN( resellerScelto.getName() ) +
                                                " ha venduto nel periodo che va da " + LogColor.GREEN( dataInizioParametro.toString() ) +
                                                " a " +
                                                LogColor.GREEN( dataFineParametro.toString() ) + " un totale di " +
                                                LogColor.GREEN( String.valueOf( ticketsFinded.size() ) ) + " " +
                                                "abbonamenti" +
                                                "." );
                                        eseguiStatisticheVendita = false;

                                    } else {
                                        System.out.println( "Fatti ricoverare" );
                                        eseguiStatisticheVendita = false;
                                    }
                                }


                            } catch( Exception e ) {
                                LogColor.errorMessage( "Qualcosa e' andato storto, riprova!" );
                                eseguiStatisticheVendita = false;
                            }
                        }

    }
    
    private static void nuovaBiglietteria(){
        System.out.println( LogColor.CYAN( "AGGIUNTA DI UNA NUOVA BIGLIETTERIA" ) );
                        boolean eseguiAggiunta = true;
                        int count = 0;

                        while( eseguiAggiunta ) {
                            if( count == 0 ) {
                                scanner.nextLine();
                                count++;
                            }
                            try {
                                LogColor.selectionMessage( "Inserisci il nome della tua attività " );
                                String nomeAttivita = scanner.nextLine();

                                LogColor.selectionMessage( """
                                        Scegli la tipologia di attività 
                                        1. BIGLIETTERIA
                                        2. BIGLIETTERIA AUTOMATICA""" );

                                int sceltaTipologia = scanner.nextInt();

                                if( sceltaTipologia == 1 ) {
                                    Reseller newDealer = new Dealer();
                                    newDealer.setName( nomeAttivita );
                                    ResellerDAO.save( newDealer );

                                    eseguiAggiunta = false;
                                } else if( sceltaTipologia == 2 ) {

                                    Reseller newDealer = new AutomaticDealer();

                                    newDealer.setName( nomeAttivita );
                                    ResellerDAO.save( newDealer );

                                    eseguiAggiunta = false;
                                } else {
                                    System.out.println( "Non sei capace di selezionare o 1 o 2?!?" );
                                    eseguiAggiunta = false;
                                }
                            } catch( Exception e ) {
                                LogColor.errorMessage( "Qualcosa e' andato storto, riprova!" );
                                scanner.nextLine();
                            }
                        }
    }
    
    private static void eliminaBiglietteria(){
        System.out.println( LogColor.CYAN( "RIMOZIONE DI UNA BIGLIETTERIA" ) );
                        boolean eseguiRimozione = true;
                        int count = 0;

                        while( eseguiRimozione ) {
                            if( count == 0 ) {
                                scanner.nextLine();
                                count++;
                            }
                            try {
                                LogColor.selectionMessage( "Inserisci il nome dell'attività che vuoi chiudere" );
                                String nomePuntoVendita = scanner.nextLine();
                                LogColor.infoMessage( "Il nome scelto Ã¨: " + nomePuntoVendita );
                                List<Reseller> puntoVendita = ResellerDAO.getByName( nomePuntoVendita );

                                if( puntoVendita.size() == 0 ) {

                                    LogColor.errorMessage( "Nessun punto vendita trovato! Riprova." );
                                    eseguiRimozione = false;

                                } else if( puntoVendita.size() == 1 ) {

                                    LogColor.infoMessage( "Trovata una sola corrispondenza, " + puntoVendita.get( 0 ) );


                                    System.out.println( LogColor.YELLOW( "QUESTA AZIONE E' IRREVERSIBILE, SEI SICURO?" ) );
                                    System.out.println( "1. SI \n" +
                                            "2. NO" );

                                    int sceltaEliminazione = scanner.nextInt();

                                    if( sceltaEliminazione == 1 ) {
                                    	ResellerDAO.delete( puntoVendita.get( 0 ) );
                                        eseguiRimozione = false;
                                    } else if( sceltaEliminazione == 2 ) {
                                        LogColor.infoMessage( "Annullo eliminazione" );
                                        eseguiRimozione = false;
                                    } else {
                                        LogColor.errorMessage( "Non scegliere e' una scelta di essere scemi!" );
                                        eseguiRimozione = false;
                                    }


                                } else if( puntoVendita.size() > 1 ) {

                                    LogColor.infoMessage( "Trovate pie' corrispondenze" );

                                    for( Reseller myNegozio : puntoVendita ) {
                                        printerReseller( myNegozio );
                                    }

                                    LogColor.selectionMessage( "Seleziona l'id desiderato" );
                                    long codiceScelto = scanner.nextInt();

                                    Reseller resellerScelto = ResellerDAO.getById( codiceScelto );

                                    System.out.println( LogColor.YELLOW( "QUESTA AZIONE E' IRREVERSIBILE, SEI SICURO?" ) );
                                    System.out.println( "1. SI \n" +
                                            "2. NO" );

                                    int sceltaEliminazione = scanner.nextInt();

                                    if( sceltaEliminazione == 1 ) {
                                    	ResellerDAO.delete( resellerScelto );
                                        eseguiRimozione = false;
                                    } else if( sceltaEliminazione == 2 ) {
                                        LogColor.infoMessage( "Annullo eliminazione" );
                                        eseguiRimozione = false;
                                    } else {
                                        LogColor.errorMessage( "Non scegliere e' una scelta di essere scemi!" );
                                        eseguiRimozione = false;
                                    }
                                }

                            } catch( Exception e ) {
                                LogColor.errorMessage( "Qualcosa e' andato storto, riprova!" );
                                scanner.nextLine();
                            }
                        }
    }

    private static void updateResellerState() {
    	  boolean eseguiDisattivazione = true;

          while( eseguiDisattivazione ) {

                  scanner.nextLine();

              try {
                  System.out.println( LogColor.CYAN( "DISATTIVAZIONE DISTRIBUTORE" ) );
                  LogColor.selectionMessage( "Inserisci il nome del distributore automatico" );
                  String nomePuntoVendita = scanner.nextLine();
                  LogColor.infoMessage( "Il nome scelto è: " + nomePuntoVendita );
                  List<AutomaticDealer> puntoVendita = ResellerDAO.getActiveAutomaticDealers( nomePuntoVendita );

                  if( puntoVendita.size() == 0 ) {

                      LogColor.errorMessage( "Nessun distributore trovato! Riprova." );
                      eseguiDisattivazione = false;

                  } else if( puntoVendita.size() == 1 ) {

                      LogColor.infoMessage( "Trovata una sola corrispondenza, " + puntoVendita.get( 0 ) );

                      puntoVendita.get( 0 ).setActive( false );

                      LogColor.selectionMessage( """
                              Che stato di servizio vuoi dare al tuo distributore?
                              1. IN SERVIZIO
                              2. FUORI SERVIZIO""" );

                      int sceltaServizio = scanner.nextInt();

                      if( sceltaServizio == 1 ) {
                          ResellerDAO.refreshActive( puntoVendita.get( 0 ), true );
                          eseguiDisattivazione = false;
                      } else if( sceltaServizio == 2 ) {
                          ResellerDAO.refreshActive( puntoVendita.get( 0 ), false );
                          eseguiDisattivazione = false;
                      } else {
                          LogColor.errorMessage( "Input errato!" );
                      }


                  } else if( puntoVendita.size() > 1 ) {

                      LogColor.infoMessage( "Trovate più corrispondenze" );

                      for( AutomaticDealer myNegozio : puntoVendita ) {
                          printerReseller( myNegozio );
                      }

                      LogColor.selectionMessage( "Seleziona l'id desiderato" );
                      long codiceScelto = scanner.nextInt();

                      Reseller resellerScelto = ResellerDAO.getById( codiceScelto );

                      LogColor.selectionMessage( """
                              Che stato di servizio vuoi dare al tuo distributore?
                              1. IN SERVIZIO
                              2. FUORI SERVIZIO""" );

                      int sceltaServizio = scanner.nextInt();

                      if( sceltaServizio == 1 ) {

                          ResellerDAO.refreshActive( ((AutomaticDealer )resellerScelto), true );

                      } else if( sceltaServizio == 2 ) {

                          ResellerDAO.refreshActive( ((AutomaticDealer )resellerScelto), false );

                      } else {
                          LogColor.errorMessage( "Input errato!" );
                      }
                  }

              } catch( Exception e ) {
                  LogColor.errorMessage( "Qualcosa è andato storto, riprova!" );
                  scanner.nextLine();
                  eseguiDisattivazione = false;
              }
          }
		
	}

}
