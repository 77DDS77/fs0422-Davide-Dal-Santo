package com.danieleterr.springjpa.springjpa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.danieleterr.springjpa.springjpa.entities.Address;
import com.danieleterr.springjpa.springjpa.entities.User;
import com.danieleterr.springjpa.springjpa.exceptions.PageException;
import com.danieleterr.springjpa.springjpa.services.AddressService;
import com.danieleterr.springjpa.springjpa.services.UserService;

@RestController
public class UserController {

	@Autowired
	UserService us;
	
	@Autowired
	AddressService as;
	
	@GetMapping("/")
	public String index() {
		return "ciao sono la homepage";
	}
	
	@GetMapping("/api/users")
	public Iterable<User> getAllUsers(){
		return us.getAll();
	}
	
	@GetMapping("/api/users/{id}")
	public Optional<User> getById(@PathVariable int id){
		return us.getById(id);
	}
	
	@PostMapping("/api/users")
	public User postUser(
			@RequestParam("name") String name,
			@RequestParam("age") int age,
			@RequestParam("address_id") int address_id
	) {
		
		User u = new User();
		u.setName(name);
		u.setAge(age);
		Optional<Address> a = as.getById(address_id);
		if(a.isPresent()) {
			u.setAddress(a.get());
		} else {
			Optional<Address> a2 = as.getById(1);
			u.setAddress(a2.get());
		}
		us.addUser(u);
		
		return u;
	}
	
	@PutMapping("/api/users/{id}")
	public User putUser(
			@PathVariable("id") int id,
			@RequestParam("name") String name,
			@RequestParam("age") int age,
			@RequestParam(name = "address_id", required = false) Integer address_id
	) {
		
		Optional<User> u = us.getById(id);
		
		if (u.isPresent()) {
			User user = u.get();
			user.setName(name);
			user.setAge(age);
			
			if (address_id != null) {
				Optional<Address> a = as.getById(address_id);
				if(a.isPresent()) {
					user.setAddress(a.get());
				} else {
					Optional<Address> a2 = as.getById(1);
					user.setAddress(a2.get());
				}
			}
			us.addUser(user);
			return user;
		}
		
		return null;
	}
	
	@DeleteMapping("/api/users/{id}")
	public User deleteUser(@PathVariable("id") int id) {
		
		Optional<User> u = us.getById(id);
				
		if (u.isPresent()) {
			User user = u.get();
			us.deleteById(id);
			return user;
		}
		
		return null;
	}
	
	@GetMapping("/api/users/name/{name}")
	public List<User> getUsersByName(@PathVariable("name") String name){
		
		return us.getByName(name);
	}
	
	// GIORNO 3
	
	@GetMapping("/api/users/re1")
	public ResponseEntity<String> re1(){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Author", "Davide");
		
		String body = "Corpo del responso";
		
		ResponseEntity<String> res = new ResponseEntity<>(body, headers, HttpStatus.OK);
		return res;
	}
	
	@GetMapping("/api/users/re2/{mode}")
	public ResponseEntity<Object> re2(@PathVariable int mode){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Author", "Davide");
		
		switch (mode) {
		case 1: 
			return new ResponseEntity<Object>("mode1",headers, HttpStatus.OK);
		
		case 2:
			return new ResponseEntity<Object>(us.getAll(),headers, HttpStatus.OK);
			
		default:
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
			
		}
	}
	
	@GetMapping("/api/users/exc1")
	public String exc1() {
		throw new PageException("Eccezione generata manualmente");
	}
	
	@GetMapping("/api/users/exc2")
	public String exc2() {
		throw new ArrayIndexOutOfBoundsException("Eccezione generata manualmente");
	}
	
	@GetMapping("/api/users/test1")
	public String test1() {
		return "Sono il test 1";
	}
	
	@GetMapping("/api/users/test2")
	public String test2() {
		return "Sono java sono il test 2";
	}
	
	@GetMapping("/api/users-paginate")
	public ResponseEntity<Page<User>> getAllUsersPaginate(Pageable p){
		
		Page<User> res = us.getAllAndPaginate(p);
		
		if(res.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
	}
	
	@GetMapping("/api/users-paginate-slice")
	public Page<User> getAllUsersPaginateSlice(){
		
		Pageable pagina1_risultati2 = PageRequest.of(0,2);
		Page<User> res = us.getAllAndPaginate(pagina1_risultati2);
		
		return res;
	}
	
	@GetMapping("/api/users-paginate-byname/{name}")
	public Page<User> getByNameAndPaginate(@PathVariable("name") String n, Pageable p){
		
		Page<User> res = us.getByNameAndPaginate(n, p);
		
		return res;
	}
}






















