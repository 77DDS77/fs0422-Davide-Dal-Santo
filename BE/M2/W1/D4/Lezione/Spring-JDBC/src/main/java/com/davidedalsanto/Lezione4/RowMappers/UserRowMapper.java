package com.davidedalsanto.Lezione4.RowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.davidedalsanto.Lezione4.entities.User;

public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User u = new User();
		u.setId(rs.getInt("id"));
		u.setName(rs.getString("name"));
		u.setAge(rs.getInt("age"));
		u.setAddress(new AddressRowMapper().mapRow(rs, rowNum));
		
		return u;
	}

}
