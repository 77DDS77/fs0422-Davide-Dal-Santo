package com.davidedalsanto.AD.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davidedalsanto.AD.exceptions.UpdateException;
import com.davidedalsanto.AD.exceptions.UserNotFoundException;
import com.davidedalsanto.AD.models.User;
import com.davidedalsanto.AD.services.UserService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {

	@Autowired
	UserService us;
	
	//----------------------GET-------------------
	
	@GetMapping("")
	public ResponseEntity<Iterable<User>> searchAllUsers() {
		return new ResponseEntity<>(us.searchAllUsers(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		try {
			return new ResponseEntity<>( us.findById(id), HttpStatus.OK);
		} catch (UserNotFoundException e) {
			log.error(e.getMessage());
			return new ResponseEntity<>( null, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<User>> findAll(Pageable p) {
		Page<User> findAll = us.searchAllUsersPageable(p);

		if (findAll.hasContent()) {
			return new ResponseEntity<>(findAll, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}
	
	//----------------------POST-------------------
	
	@PostMapping("")
	public ResponseEntity<User> create(@RequestBody User user) {
		try {
			return new ResponseEntity<>( us.create(user), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>( null, HttpStatus.BAD_REQUEST);
		}
	}
	
	//----------------------PUT-------------------
	
	@PutMapping("")
	public ResponseEntity<User> update(long id, User user){
		
		try {
			return new ResponseEntity<>(us.update(id, user), HttpStatus.OK);
		} catch (UpdateException e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	//----------------------DELETE-------------------
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		try {
			us.delete(id);
			return new ResponseEntity<>(null, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}


























