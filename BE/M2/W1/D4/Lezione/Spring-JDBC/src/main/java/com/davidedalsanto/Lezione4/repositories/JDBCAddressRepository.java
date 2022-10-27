package com.davidedalsanto.Lezione4.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JDBCAddressRepository implements AddressRepositoy{

	@Autowired
	private JdbcTemplate t;
	
	@Override
	public int save(String road) {
		return t.update(
				"INSERT INTO addresses (road) VALUES (?)",
				road);
	}

}
