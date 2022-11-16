package com.BEBW2.ES.EnergyService.Repositories;

import com.BEBW2.ES.EnergyService.Entities.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {

    @Query(value = "SELECT p FROM Provincia p WHERE provincia = :n ")
    public Optional<Provincia> findByName(@Param("n") String provincia);
}
