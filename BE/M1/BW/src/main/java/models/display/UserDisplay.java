package models.display;

import models.User;
import models.dao.UserDAO;
import utils.LogColor;

import java.util.List;
import java.util.Scanner;

/*
Definizione dello scanner, console output
per interazione utente.

- MOSTRA LISTA UTENTI
- CERCA PER NOME E COGNOME (poi modifica)
- AGGIUNGI NUOVO UTENTE
*/
public class UserDisplay {
	 
	private static Scanner scanner = new Scanner( System.in );
	
    public static void modaleUtente() {
        boolean esegui = true;

        while( esegui ) {
            System.out.println( LogColor.CYAN( "*MENU UTENTE*" ) + "\n" + " \n" +
                    LogColor.GREEN( "(0) " ) + "Torna al " + LogColor.YELLOW( "MENU PRINCIPALE" ) + "\n" +
                    " | \n" +
                    LogColor.GREEN( "(1) " ) + "Visualizza lista" + LogColor.YELLOW( " UTENTI" ) + "\n" +
                    " | \n" +
                    LogColor.GREEN( "(2) " ) + "Cerca per nome e cognome e " + LogColor.CYAN( " MODIFICA UTENTE" ) +
                    "\n" +
                    " | \n" +
                    LogColor.GREEN( "(3) " ) + "Aggiungi un nuovo" + LogColor.GREEN( " UTENTE" ) + "\n" +
                    "" );

            try {
            	LogColor.selectionMessage( "Seleziona da 0 a 3" );
                int scelta = scanner.nextInt();

                switch (scelta) {
                    case 0 -> {
                    	LogColor.infoMessage( "Torno al menu principale" );
                        esegui = false;
                    }

                    case 1 -> {
                        LogColor.standardMessage("Lista utenti:");
                        getUtenti();
                    }

                    case 2 -> {
                    	findByNameLastName();
                    }

                    case 3 -> {
                    	newUser();
                    }


                    default -> {
                    	throw new Exception( "Input fuori range. Riprova!" );
                    }
                }
            } catch( Exception e ) {
                LogColor.errorMessage( "Qualcosa e' andato storto, riprova" );
                scanner.nextLine();
            }
        }

    }
    
    private static void printerUtente( User item ) {

        StringBuilder vuotaGiu = new StringBuilder();

        for( String s : item.toString().split( "" ) ) {
            vuotaGiu.append( "-" );
        }
        System.out.println( item );
        System.out.println( vuotaGiu );
    }

    private static void getUtenti() {
        List<User> database =  UserDAO.getAll();

        for( User data : database ) {
            printerUtente( data );
        }
    }

    private static void findByNameLastName() {
    	
        long userId = 0;

        boolean esegui2 = true;
        int count = 0;

        while( esegui2 ) {
            if( count == 0 ) {
                scanner.nextLine();
            }
            count++;

            try {
                LogColor.infoMessage( "Ricerca per nome e cognome" );

                LogColor.selectionMessage( "Inserisci il nome dell'utente" );
                String nome = scanner.nextLine();

                LogColor.selectionMessage( "Inserisci il cognome dell'utente'" );
                String cognome = scanner.nextLine();

                LogColor.infoMessage( "ricerco utenti..." );

                List<User> findedUtenti =  UserDAO.getUserByFullName( nome, cognome );

                if( findedUtenti.isEmpty() ) {                	
                	throw new Exception("Nessun utente trovato! Riprova.");

                } else if( findedUtenti.size() == 1 ) {

                    LogColor.infoMessage( "Trovata una sola corrispondenza" );
                    printerUtente( findedUtenti.get( 0 ) );
                    
                    userId = findedUtenti.get( 0 ).getId();
                    LogColor.infoMessage( "Seleziono automaticamente il numero tessera: " + userId );

                    esegui2 = false;
                } else {
                    LogColor.infoMessage( "Trovati " + findedUtenti.size() + " risultati" );

                    for( User ut : findedUtenti ) {
                        printerUtente( ut );
                    }

                    LogColor.selectionMessage( "Inserisci numero tessera per selezionare l'utente" );
                    userId = scanner.nextInt();
                    esegui2 = false;
                }

                if( userId != 0 ) {
                	updateUser(userId);
                }

            } catch( Exception e ) {
                LogColor.errorMessage( e.getMessage() );
            }
        }
    }

    private static void updateUser(Long userId) {

       boolean esegui3 = true;

       while( esegui3 ) {
           try {
               System.out.println( LogColor.CYAN( "*AZIONI DI MODIFICA UTENTE*" ) + "\n" +
                       " \n" +
                       LogColor.GREEN( "(0) " ) + "Torna " + LogColor.YELLOW(
                       "INDIETRO" ) + "\n" +
                       " | \n" +
                       LogColor.GREEN( "(1) " ) + "Aggiorna dati " + LogColor.CYAN( " UTENTE" ) +
                       "\n" +
                       " | \n" +
                       LogColor.GREEN( "(2) " ) + "Elimina " + LogColor.RED( " UTENTE" ) +                       
                       "" );

               LogColor.selectionMessage( "Seleziona da 0 a 2" );
               int sceltaAzione = scanner.nextInt();

               switch (sceltaAzione) {
                   case 0 -> {
                       esegui3 = false;
                   }
                   case 1 -> {
                	   updateUserData(userId);                	   
                   }


                   case 2 -> {
                	   System.out.println(LogColor.YELLOW("Questa azione è irreversibile, sei sicuro?") + "\n" + " \n" +
   	                        LogColor.GREEN( "(1) " ) + LogColor.YELLOW( "SI" )  + "\n" +
   	                        " | \n" +
   	                        LogColor.GREEN( "(2) " ) + LogColor.YELLOW( "NO") + "\n" +
   	                        "");
   					
   					LogColor.selectionMessage( "Seleziona da 1 o 2" );
   					
                       int sceltaEliminazione = scanner.nextInt();

                       if( sceltaEliminazione == 1 ) {
                       	 UserDAO.delete(  UserDAO.getById( userId ) );
                           esegui3 = false;
                       } else {
                           LogColor.infoMessage( "Annullo scelta" );
                           esegui3 = false;
                       }
                   }
               }

           } catch( Exception e ) {
               LogColor.errorMessage( "Qualcosa e' andato storto, riprova" );
           }
       }
   }
   
    private static void updateUserData(Long userId) {

       boolean esegui4 = true;

       while( esegui4 ) {
    	   System.out.println( LogColor.CYAN("*AZIONI DI MODIFICA UTENTE*" ) + "\n" + " \n" +
    			   LogColor.GREEN( "(0) " )  + "Torna al " + LogColor.YELLOW( "MENU PRECEDENTE" ) + "\n" +
                   " | \n" +  
    			   LogColor.GREEN( "(1) " ) + "Aggiorna " + LogColor.YELLOW( " NOME" )  + "\n" +
				   " | \n" +
				   LogColor.GREEN( "(2) " ) + "Aggiorna " + LogColor.YELLOW( " COGNOME" )  + "\n" +
                   "" );

           int sceltaModifica = scanner.nextInt();

           User utenteSelezionato =  UserDAO.getById( userId );
           switch (sceltaModifica) {
               case 0 -> {
                   esegui4 = false;
               }
               case 1 -> {
                   scanner.nextLine();
                   LogColor.selectionMessage( "Che nome vuoi dare a " + utenteSelezionato.getName() + " ?" );
                   String nuovoNome = scanner.nextLine();

                   LogColor.infoMessage( "Modifico in " + nuovoNome );

                   UserDAO.refreshName( utenteSelezionato, nuovoNome );

               }
               case 2 -> {
                   scanner.nextLine();
                   LogColor.selectionMessage( 
                		   "Che cognome vuoi dare a " + utenteSelezionato.getName() + " " + utenteSelezionato.getLastName() + " ?" 
                		   );
                   String nuovoCognome = scanner.nextLine();
                   LogColor.infoMessage( "Modifico in " + nuovoCognome );

                   UserDAO.refreshLastName( utenteSelezionato, nuovoCognome );
               }
               default -> LogColor.errorMessage ( "Input fuori range" );
           }

       }
   }
    
    private static void newUser() {

       boolean eseguiAggiunta = true;

       scanner.nextLine();
       while( eseguiAggiunta ) {
           try {
               LogColor.infoMessage( "AGGIUNGI NUOVO UTENTE" );
               LogColor.selectionMessage( "Inserisci nome" );
               String nome = scanner.nextLine();

               LogColor.selectionMessage( "Inserisci cognome" );
               String cognome = scanner.nextLine();
               
               if(nome.length() > 0 && cognome.length() > 0) {
               User ut = new User();
               ut.setName( nome );
               ut.setLastName( cognome );
               UserDAO.save( ut );
               
               LogColor.infoMessage("Utente salvato");
               
               }else {
            	   throw new Exception("Il campo nome e/o il campo cgonome è vuoto!");
               }
               System.out.println(LogColor.CYAN( "Vuoi salvare un nuovo utente?" ) + "\n" + " \n" +
            		   LogColor.GREEN( "(1) " ) + LogColor.YELLOW( "SI" )  + "\n" +
                       " | \n" +
                       LogColor.GREEN( "(2) " ) + LogColor.YELLOW( "NO" ) + "\n" +
                       "");
				
				LogColor.selectionMessage( "Seleziona da 1 o 2" );

               int input = scanner.nextInt();

               if( input != 1 ) {
                   LogColor.infoMessage( "Torno al menu utente..." );
                   eseguiAggiunta = false;
               }else {
               scanner.nextLine();
               }
           } catch( Exception e ) {
               LogColor.errorMessage( e.getMessage() );
           }
       }
   }
}
