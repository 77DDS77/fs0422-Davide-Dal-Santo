package com.BEBW2.ES.EnergyService.Repositories;

import com.BEBW2.ES.EnergyService.Entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    /**
    * Check if the Address given already exists in the database
    * */
    @Query("select a from Address a where a.cap = ?1 and a.via = ?2 and a.civico = ?3")
    Optional<Address> getSameAddress(int cap, String via, int civico);


}
