import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dao.EventoDAO;
import dao.LocationDAO;
import dao.PartecipazioneDAO;
import dao.PersonaDAO;
import models.Concerto;
import models.Evento;
import models.GaraDiAtletica;
import models.Genere;
import models.Location;
import models.Partecipazione;
import models.PartitaDiCalcio;
import models.Persona;
import models.Sesso;
import models.StatoPartecipazione;
import models.TipoEvento;

public class Main {

	public static void main(String[] args) {
		
		/*
		Location loc = new Location();
		loc.setNome("Cinisello");
		loc.setCitta("Milano");

		Persona p1 = new Persona();
		p1.setNome("Davide");
		p1.setCognome("Dal Santo");
		p1.setDob("20-04-97");
		p1.setEmail("mail@mail.com");
		p1.setSesso(Sesso.MASCHIO);
		
		Partecipazione part1 = new Partecipazione();
		part1.setPersona(p1);
		part1.setStatoPartecipazione(StatoPartecipazione.CONFERMATO);
		
		List<Partecipazione> p1Part = new ArrayList<>(Arrays.asList(part1));
		p1.setListaPartecipazioni(p1Part);
		
		
		Evento ev1 = new Evento();
		ev1.setTitolo("Primo evento");
		ev1.setDescrizione("evento random");
		ev1.setTipoEvento(TipoEvento.PUBBLICO);
		ev1.setDataEvento("10-10-23");
		ev1.setNumeroMassimoPartecipanti(1000);
		ev1.setLocation(loc);
		Set<Partecipazione> ev1Part = new HashSet<>();
		ev1Part.add(part1);
		ev1.setPartecipazioni(ev1Part);
		
		part1.setEvento(ev1);
		
		
		//test esplosione
		
		
		LocationDAO.saveLocation(loc);
		EventoDAO.saveEvento(ev1);
		PersonaDAO.savePersona(p1);
		PartecipazioneDAO.savePartecipazione(part1);
		
		
		
		
		//TEST PARTITA DI CALCIO
		
		PartitaDiCalcio pc = new PartitaDiCalcio();
		//setter di evento
		pc.setTitolo("Partita Padova-Venezia");
		pc.setDescrizione("descrizione xyz");
		pc.setTipoEvento(TipoEvento.PUBBLICO);
		pc.setDataEvento("12-10-23");
		pc.setNumeroMassimoPartecipanti(1000);
		pc.setLocation(loc);
		pc.setPartecipazioni(ev1Part);
		//setter partita di calcio
		pc.setSquadraCasa("Padova");
		pc.setSquadraOspite("Venezia");
		pc.setGolCasa(4);
		pc.setGolOspite(1);
		pc.setSquadraVincenteVoid();
		
		
		EventoDAO.saveEvento(pc);
		
		
		// TEST GARA DI ATLETICA
		GaraDiAtletica gda = new GaraDiAtletica();
		// creazione atleti
		Persona atl1 = new Persona();
		atl1.setNome("Mirco");
		atl1.setCognome("Pastello");
		atl1.setDob("12-05-97");
		atl1.setEmail("mail@mail.com");
		atl1.setSesso(Sesso.MASCHIO);
		PersonaDAO.savePersona(atl1);
		
		Persona atl2 = new Persona();
		atl2.setNome("Marco");
		atl2.setCognome("Carrello");
		atl2.setDob("12-05-97");
		atl2.setEmail("mail@mail.com");
		atl2.setSesso(Sesso.MASCHIO);
		PersonaDAO.savePersona(atl2);
		
		Persona atl3 = new Persona();
		atl3.setNome("Morto");
		atl3.setCognome("Pennarello");
		atl3.setDob("12-05-97");
		atl3.setEmail("mail@mail.com");
		atl3.setSesso(Sesso.MASCHIO);
		PersonaDAO.savePersona(atl3);
		
		Persona atl4 = new Persona();
		atl4.setNome("Mauro");
		atl4.setCognome("Mattarello");
		atl4.setDob("12-05-97");
		atl4.setEmail("mail@mail.com");
		atl4.setSesso(Sesso.MASCHIO);
		PersonaDAO.savePersona(atl4);
		
		Set<Persona> partecipanti = new HashSet<>();
		partecipanti.add(atl1);
		partecipanti.add(atl2);
		partecipanti.add(atl3);
		partecipanti.add(atl4);
		
		// setter di evento
		gda.setTitolo("Gara di atletica");
		gda.setDescrizione("gara atleticissima");
		gda.setTipoEvento(TipoEvento.PUBBLICO);
		gda.setDataEvento("14-10-23");
		gda.setNumeroMassimoPartecipanti(100);
		gda.setLocation(loc);
		gda.setPartecipazioni(ev1Part);
		// setter di GDA
		gda.setSetAtleti(partecipanti);
		gda.setVincitoreVoid();
		
		EventoDAO.saveEvento(gda);
		
		
		// TEST GARA DI CONCERTO
		Concerto conc = new Concerto();
		// setter di evento
		conc.setTitolo("Concerto");
		conc.setDescrizione("Concertone di Gesu'");
		conc.setTipoEvento(TipoEvento.PRIVATO);
		conc.setDataEvento("24-12-22");
		conc.setNumeroMassimoPartecipanti(12);
		conc.setLocation(loc);
		conc.setPartecipazioni(ev1Part);
		//setter concerto
		conc.setGenere(Genere.ROCK);
		conc.setInStreaming(true);
		
		EventoDAO.saveEvento(conc);
		*/
		
		EventoDAO.getConcertiPerGenere(Genere.ROCK);
		
		EventoDAO.getConcertiInStreaming(false);
		
		EventoDAO.getGareDiAtleticaPerVincitore(PersonaDAO.findPersona(3));
		
		//logs
		/*
		System.out.println(ev1);
		System.out.println(p1);
		System.out.println(part1);
		System.out.println(loc);
		*/
		/*
		List<Partecipazione> l1 = p1.getListaPartecipazioni();
		for(Partecipazione p : l1){
			System.out.println(p);
		}
		*/
		
	}

}



