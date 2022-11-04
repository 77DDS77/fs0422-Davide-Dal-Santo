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

import com.davidedalsanto.AD.exceptions.RoleNotFoundException;
import com.davidedalsanto.AD.exceptions.UpdateException;
import com.davidedalsanto.AD.models.Device;
import com.davidedalsanto.AD.models.Role;
import com.davidedalsanto.AD.services.RoleService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/roles")
@Slf4j
public class RoleController {

	@Autowired
	private RoleService rs;
	
	
	//----------------------GET-------------------
	
	@GetMapping("") // get All
	public ResponseEntity<Iterable<Role>> searchAllRoles() {
		return new ResponseEntity<>(rs.searchAllRoles(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")//find By ID
	public ResponseEntity<Role> findById(@PathVariable Long id) {
		try {
			return new ResponseEntity<>( rs.findById(id), HttpStatus.OK);
		} catch (RoleNotFoundException e) {
			log.error(e.getMessage());
			return new ResponseEntity<>( null, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/pageable")//pageable
	public ResponseEntity<Page<Role>> findAll(Pageable p) {
		Page<Role> findAll = rs.searchAllRolesPageable(p);

		if (findAll.hasContent()) {
			return new ResponseEntity<>(findAll, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	//----------------------POST-------------------
	
	@PostMapping("")
	public ResponseEntity<Role> create(@RequestBody Role role) {
		try {
			return new ResponseEntity<>(rs.create(role), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	//----------------------PUT-------------------
	
	@PutMapping("")
	public ResponseEntity<Role> update(long id, Role role) {

		try {
			return new ResponseEntity<>(rs.update(id, role), HttpStatus.OK);

		} catch (UpdateException e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	//----------------------DELETE-------------------
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		try {
			rs.delete(id);
			return new ResponseEntity<>(null, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

}
