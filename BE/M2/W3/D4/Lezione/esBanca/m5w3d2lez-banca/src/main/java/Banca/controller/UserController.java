package Banca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Banca.entity.RoleType;
import Banca.entity.User;
import Banca.services.RoleService;
import Banca.services.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService us;
	
	@Autowired
	private RoleService rs;

	@GetMapping("")
	@CrossOrigin
	public List<User> getAllUsers() {
		return us.getAll();
	}

	@GetMapping("/pageable")
	public ResponseEntity<Page<User>> getAllPageable(Pageable p) {
		Page<User> findAll = us.getAllPaginate(p);

		if (findAll.hasContent()) {
			return new ResponseEntity<>(findAll, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable Long id) {

		return new ResponseEntity<>(us.getById(id), HttpStatus.OK);

	}

	@GetMapping("/username/{username}")
	public ResponseEntity<User> getByUsername(@PathVariable String username) {
		return new ResponseEntity<>(us.findByUsername(username), HttpStatus.OK);

	}

	@PostMapping("/new")
	public void create(@RequestBody User user) {
		try {
			us.save(user);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@PutMapping("")
	public void update(@RequestBody User user) {
		try {
			us.save(user);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
	
	@PutMapping("/{id}/add-role/{roleType}")
	public void addRole(@PathVariable("id") Long id, @PathVariable("roleType") RoleType roleType) {
		User u = us.getById(id);
		u.addRole(rs.getByRole(roleType));
		
		
		us.update(u);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteById(@PathVariable Long id) {
		try {
			us.delete(id);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
}
