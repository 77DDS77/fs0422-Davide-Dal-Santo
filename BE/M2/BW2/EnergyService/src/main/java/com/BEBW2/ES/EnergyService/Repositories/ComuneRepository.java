package com.BEBW2.ES.EnergyService.Repositories;

import com.BEBW2.ES.EnergyService.Entities.Comune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComuneRepository extends JpaRepository<Comune, Long> {

    @Query(value = "SELECT c FROM Comune c WHERE comune = :n ")
    Optional<Comune> findByName(@Param("n") String comune);

    @Query(value = "SELECT c FROM Comune c WHERE provincia.provincia = :n ")
    List<Comune> findByProvincia(@Param("n") String provincia);
}
