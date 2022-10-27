package com.davidedalsanto.Lezione4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.davidedalsanto.Lezione4.entities.User;
import com.davidedalsanto.Lezione4.repositories.JDBCAddressRepository;
import com.davidedalsanto.Lezione4.repositories.JDBCUserRepository;

@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner{

	@Autowired
	JDBCUserRepository ur;
	
	@Autowired
	JDBCAddressRepository ar;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
		
		System.out.println("Ciao");
	}

	@Override
	public void run(String... args) throws Exception {
		//insert("Davide", 5, 1);
		//insert("Carisio", 7, 2);
		
		//insertAddress("Via puccini");
		//insertAddress("Via vivaldi");
		
		//findAll();
		
		System.out.println("Il numero di utenti salvato è: " 
				+ ur.count());
		
		User u = ur.findById(1);
		updateUser(u, "Gianni", 9);
	}
	
	public void insert(String name, int age, int addressId) {
		User u = new User(name, age);
		ur.save(u, addressId);
	}
	
	public void findAll() {
		for(int i = 0 ; i < ur.getAll().size(); i++) {
			System.out.println(ur.getAll().get(i));
		}
	}
	
	public void insertAddress(String road) {
		ar.save(road);
	}
	
	public void findById(int id) {
		System.out.println("L'utente con ID: " + id + " è: " + ur.findById(id));
	}
	
	public void updateUser(User u, Object...objs) {
		u.setName((String)objs[0]);
		u.setAge((int)objs[1]);
		ur.update(u);
	}
	
	public void deleteUser(long id) {
		ur.deleteById(id);
	}
}













