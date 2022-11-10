package Banca.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Banca.entity.Role;
import Banca.entity.RoleType;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	Optional<Role> findByRoleType(RoleType roleType);

}
