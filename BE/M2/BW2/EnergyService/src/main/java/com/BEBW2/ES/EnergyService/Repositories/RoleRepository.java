package com.BEBW2.ES.EnergyService.Repositories;

import com.BEBW2.ES.EnergyService.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
