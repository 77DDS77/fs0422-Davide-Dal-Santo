package com.davidedalsanto.AD.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davidedalsanto.AD.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	public Optional<User> findByUsername(String username);
}
