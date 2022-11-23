package com.davidedalsanto.GP.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.davidedalsanto.GP.config.utils.LogColor;
import com.davidedalsanto.GP.entities.Utente;
import com.davidedalsanto.GP.exceptions.UtenteNotFoundException;
import com.davidedalsanto.GP.services.UtenteService;

@RestController
public class UtenteController {

	@Autowired
	UtenteService us;
		
	//------------GET-----------------
	
	@GetMapping("/api/utenti")
	public ResponseEntity<List<Utente>> getAll(){
		return new ResponseEntity<>( us.finAllUtenti(), HttpStatus.OK);
	}
	
	@GetMapping("/api/utenti/{id}")
	public ResponseEntity<Utente> findById(@PathVariable long id){
		Utente found;
		try {
			found = us.findUtenteById(id);
			return new ResponseEntity<Utente>( found, HttpStatus.OK);
		} catch (UtenteNotFoundException e) {
			return new ResponseEntity( e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	//------------POST-----------------
	
	//come faccio a passare un utente completo se non ho l'id
	
//	@PostMapping("/api/utenti")
//	public ResponseEntity<Utente> postUser(@RequestBody Utente u){
//		Utente ute = us.saveUtente(u);
//		return new ResponseEntity<>(ute, HttpStatus.OK);
//	}
	
	@PostMapping("/api/utenti")
	public ResponseEntity<Utente> postUser(
			@RequestParam("fullname") String fullname, 
			@RequestParam("email") String email) 
	{
		Utente u = Utente.builder()
				.fullname(fullname)
				.email(email)
				.build();
		
		us.saveUtente(u);
		return new ResponseEntity<>(u, HttpStatus.OK);
	}
	
	//------------PUT-----------------
	
	//come si fa a controllare su postman se funziona?
	
	@PutMapping("/api/utenti/{id}")
	public ResponseEntity<Utente> updateUtente(@PathVariable("id") long id, @RequestBody Utente u){
		Utente updatedUser;
		try {
			updatedUser = us.update(id, u);
			return new ResponseEntity<Utente>(updatedUser, HttpStatus.OK);
		} catch (UtenteNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		} 	
	}
	
//	@PutMapping("/api/utenti/{id}")
//	public Utente updateUtente(
//			@PathVariable("id") long id,
//			@RequestParam(name = "fullname", required = false) String fullname, 
//			@RequestParam(name = "email", required = false) String email
//			) 
//	{
//		
//		Optional<Utente> u = us.findUtenteById(id);
//		
//		if(u.isPresent()) {
//			Utente user = u.get();
//			
//			if(fullname == null && email == null) {
//				user.setFullname(user.getFullname());
//				user.setEmail(user.getEmail());
//				us.updateUtente(user);
//				return user;
//			}
//			else if(fullname == null) {
//				user.setFullname(user.getFullname());
//				user.setEmail(email);
//				us.updateUtente(user);
//				return user;
//			}else if(email == null) {
//				user.setFullname(fullname);
//				user.setEmail(user.getEmail());
//				us.updateUtente(user);
//				return user;
//			}
//			
//		}
//		return null;
//	}
	
	//------------DELETE-----------------
	
	@DeleteMapping("/api/utenti/{id}")
	public ResponseEntity<Utente> deleteUtente(@PathVariable("id") long id) {
		
		Utente u;
		try {
			u = us.findUtenteById(id);
			us.deleteUtente(u);
			return new ResponseEntity<>(u, HttpStatus.OK);
		} catch (UtenteNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.OK);
		}
		

	}
	
}
