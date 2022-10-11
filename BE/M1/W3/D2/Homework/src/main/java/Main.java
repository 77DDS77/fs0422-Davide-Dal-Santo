import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dao.EventoDAO;
import dao.LocationDAO;
import dao.PartecipazioneDAO;
import dao.PersonaDAO;
import models.Evento;
import models.Location;
import models.Partecipazione;
import models.Persona;
import models.Sesso;
import models.StatoPartecipazione;
import models.TipoEvento;

public class Main {

	public static void main(String[] args) {
		
		
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



