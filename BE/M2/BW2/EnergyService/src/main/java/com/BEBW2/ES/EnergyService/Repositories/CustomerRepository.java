package com.BEBW2.ES.EnergyService.Repositories;

import com.BEBW2.ES.EnergyService.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //Filter by fatturato annuale, strict value
    @Query("select c from Customer c where c.fatturatoAnnuale = ?1")
    List<Customer> findByFatturatoAnnuale(double fatturatoAnnuale);

    //Filter by fatturato Greater than Equal
    @Query("select c from Customer c where c.fatturatoAnnuale >= ?1")
    List<Customer> findByFatturatoAnnualeGreaterThanEqual(double fatturatoAnnuale);

    //Filter by data d'inserimento
    @Query("select c from Customer c where c.dataInserimento = ?1")
    List<Customer> findByDataInserimento(LocalDate dataInserimento);

    //Filter by data di ultimo contatto
    @Query("select c from Customer c where c.dataUltimoContatto = ?1")
    List<Customer> findByDataUltimoContatto(LocalDate dataUltimoContatto);

    //Filter by nome o parte del nome
    @Query("select c from Customer c where upper(c.nomeContatto) like upper(concat('%', ?1, '%'))")
    List<Customer> findByNomeContattoContainsIgnoreCase(String nomeContatto);


}
