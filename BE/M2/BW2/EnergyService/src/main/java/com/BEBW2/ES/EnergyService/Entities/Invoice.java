package com.BEBW2.ES.EnergyService.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private BigDecimal importo;

    private int numero;

    @Enumerated(EnumType.STRING)
    private InvoiceState statoFattura;

    public Invoice(BigDecimal importo, int numero) {
        this.date = LocalDate.now();
        this.importo = importo;
        this.numero = numero;
        this.statoFattura = InvoiceState.CREATA;
    }
}
