package com.davidedalsanto.Lezione4.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.davidedalsanto.Lezione4.RowMappers.UserRowMapper;
import com.davidedalsanto.Lezione4.entities.User;

@Repository
public class JDBCUserRepository implements UserRepository{

	/*
	 * Se istanzio una JDBCUserRepository 
	 * e una JdbcTemplate me le autowira*/
	@Autowired
	private JdbcTemplate t;
	
	
	@Override
	public int count() {
		return t.queryForObject("SELECT COUNT(*) FROM users", Integer.class);
	}

	@Override
	public int save(User user, long address_id) {
		return t.update(
				"INSERT INTO users (name, age, address_id) VALUES (?, ?, ?)",
				user.getName(), user.getAge(), address_id);
				
	}

	@Override
	public int update(User user) {
		return t.update("UPDATE users SET name = ?, age = ?, address_id = ? WHERE id = ?",
				user.getName(), user.getAge(), user.getAddress().getId(), user.getId());
	}

	@Override
	public int deleteById(long id) {
		return t.update("DELETE FROM users WHERE user.id = ?", id);
	}

	@Override
	public List<User> getAll() {
		return t.query("SELECT * FROM users JOIN addresses ON users.address_id = addresses.id", new UserRowMapper());
	}
	
    @Override
    public User findById(long id) {
        try {
            return t.queryForObject("SELECT * FROM users JOIN addresses ON users.address_id = addresses.id WHERE users.id = ?", new UserRowMapper(), id);
            
        } catch (Exception e) {
            return null;
        }
    }

}
