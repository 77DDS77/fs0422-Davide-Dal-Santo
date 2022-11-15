package com.BEBW2.ES.EnergyService.comune.repositories;

import com.BEBW2.ES.EnergyService.comune.model.Comune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComuneRepository extends JpaRepository<Comune, Long> {

    @Query(value = "SELECT c FROM Comune c WHERE comune = :n ")
    public Optional<Comune> findByName(@Param("n") String comune);
}
