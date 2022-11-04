package com.davidedalsanto.AD.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davidedalsanto.AD.models.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long>{

	
}
