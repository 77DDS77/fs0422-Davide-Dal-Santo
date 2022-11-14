package com.BEBW2.ES.EnergyService.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String via;

    private int civico;

    private String localita;

    private int cap;

    private String comune;

    public Address(String via, int civico, String localita, int cap, String comune){

        this.via = via;
        this.civico = civico;
        this.localita=localita;
        this.cap=cap;
        this.comune= comune;
    }

}
