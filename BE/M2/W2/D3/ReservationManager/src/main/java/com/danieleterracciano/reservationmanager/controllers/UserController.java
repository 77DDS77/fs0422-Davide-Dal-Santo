package com.danieleterracciano.reservationmanager.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.danieleterracciano.reservationmanager.entities.User;
import com.danieleterracciano.reservationmanager.services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService us;
	
	
	//------------ GET ----------------
	
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable int id) {
		return us.getUserById(id);
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return us.getAllUsers();
	}
	
	//------------ POST -----------------
	
	@PostMapping("/users")
	public User postUser(
			@RequestParam("full_name") String full_name,
			@RequestParam("email") String email,
			@RequestParam("username") String username		
	) {
		User u = User.builder()
				.fullName(full_name)
				.email(email)
				.username(username)
				.build();
		us.saveUser(u);
		
		return u;
	}
	//------------ PUT -----------------
	
	@PutMapping("/users/{id}")
	public User putUser(
			@PathVariable int id,
			@RequestParam(name="full_name", required = false) String full_name,
			@RequestParam(name="email", required = false) String email,
			@RequestParam(name="username", required = false) String username	
	) {
		Optional<User> u = getUserById(id);
		
		if (u.isPresent()) {
			User user = u.get();
			if(full_name != null) user.setFullName(full_name);
			if(email != null) user.setEmail(email);
			if(username != null) user.setUsername(username);
			
			us.saveUser(user);
			return user;			
		}
		
		return null;
	}
	//------------ DELETE -----------------
	
	@DeleteMapping("/users/{id}")
	public User deleteUserById(@PathVariable int id) {
		
		Optional<User> u = getUserById(id);
		
		if(u.isPresent()) {
			us.deleteUserById(id);
			return u.get();		
		}
		return null;
	}
}
