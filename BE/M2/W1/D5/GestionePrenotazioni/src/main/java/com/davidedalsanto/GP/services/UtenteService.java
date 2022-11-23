package com.davidedalsanto.GP.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davidedalsanto.GP.entities.Prenotazione;
import com.davidedalsanto.GP.entities.Utente;
import com.davidedalsanto.GP.exceptions.UtenteNotFoundException;
import com.davidedalsanto.GP.repositories.UtenteRepo;

@Service
public class UtenteService {

	@Autowired
	UtenteRepo uterep;
	
	public Utente saveUtente(Utente u) {
		return uterep.save(u);
		
	}
	
	public void updateUtente(Utente u) {
		uterep.saveAndFlush(u);
	}
	
	//update2.0
	public Utente update(long id, Utente u) throws UtenteNotFoundException {
		Utente found = findUtenteById(id);
		found.setFullname(u.getFullname());
		found.setEmail(u.getEmail());
		uterep.save(found);
		return found;
	}
	
	public void deleteUtente(Utente u) {
		uterep.delete(u);
	}
	
	public void deleteUtenteById(long id) {
		uterep.deleteById(id);
	}
	
	public List<Utente> finAllUtenti(){
		return uterep.findAll();
	}
	
	public Utente findUtenteById(long id) throws UtenteNotFoundException {
		Optional<Utente> ute = uterep.findById(id);
		if(ute.isPresent()) {
			return ute.get();
		}
		throw new UtenteNotFoundException();
	}

	
	
	
	
}
