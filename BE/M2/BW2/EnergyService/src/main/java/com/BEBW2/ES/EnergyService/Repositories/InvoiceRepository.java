package com.BEBW2.ES.EnergyService.Repositories;

import com.BEBW2.ES.EnergyService.Entities.Invoice;
import com.BEBW2.ES.EnergyService.Entities.InvoiceState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    //FILTER BY:

        // - CUSTOMER ID
    @Query("select i from Invoice i where i.customer.id = ?1")
    List<Invoice> findByCustomer_Id(Long id);

        //INVOICE STATE
    @Query("select i from Invoice i where i.statoFattura = ?1")
    List<Invoice> findByStatoFattura(InvoiceState statoFattura);

        //DATE
    @Query("select i from Invoice i where i.date = ?1")
    List<Invoice> findByDate(LocalDate date);

    @Query("select i from Invoice i where i.date between ?1 and ?2")
    List<Invoice> findByDateBetween(LocalDate dateStart, LocalDate dateEnd);

    @Query("select i from Invoice i where i.importo between ?1 and ?2")
    List<Invoice> findByImportoBetween(BigDecimal importoStart, BigDecimal importoEnd);

    @Query("select i from Invoice i where i.numero = ?1")
    List<Invoice> findByNumero(int numero);



}
