package com.BEBW2.ES.EnergyService.Entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/*
* -ragioneSociale
-partitaIva
-email
-dataInserimento
-dataUltimoContatto
-fatturatoAnnuale
-pec
-telefono
-emailContatto
-nomeContatto
-cognomeContatto
-telefonoContatto
- indirizzo 1 (sede legale)
- indirizzo 2 (sede operativa/ opzionale)
- Tipo (PA, SAS, SPA, SRL)
* */
@Entity
@Table(name = "customers")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String ragioneSociale; //Evergreen di Mario Rossi s.n.c.
    @Column(unique = true)
    private String partitaIVA; //07643520567
    @Column(unique = true)
    private String email; //email azienda
    private LocalDate dataInserimento;
    private LocalDate dataUltimoContatto;
    private double fatturatoAnnuale;
    @Column(unique = true)
    private String pec;
    private String telefono;
    @Column(unique = true)
    private String emailContatto;
    private String nomeContatto;
    private String cognomeContatto;
    private String telefonoContatto;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address sedeLegale;

    @ManyToOne
    @JoinColumn(name = "address_id2")
    private Address sedeOperativa;
    @Enumerated(EnumType.STRING)
    private CompanyType tipo;

    public Customer(String ragioneSociale, String partitaIVA, String email, double fatturatoAnnuale,
                    String pec, String telefono, String emailContatto, String nomeContatto, String cognomeContatto,
                    String telefonoContatto, Address sedeLegale, Address sedeOperativa, CompanyType tipo) {
        this.ragioneSociale = ragioneSociale;
        this.partitaIVA = partitaIVA;
        this.email = email;
        this.dataInserimento = LocalDate.now();
        this.dataUltimoContatto = LocalDate.now();
        this.fatturatoAnnuale = fatturatoAnnuale;
        this.pec = pec;
        this.telefono = telefono;
        this.emailContatto = emailContatto;
        this.nomeContatto = nomeContatto;
        this.cognomeContatto = cognomeContatto;
        this.telefonoContatto = telefonoContatto;
        this.sedeLegale = sedeLegale;
        this.sedeOperativa = sedeOperativa;
        this.tipo = tipo;
    }
}
