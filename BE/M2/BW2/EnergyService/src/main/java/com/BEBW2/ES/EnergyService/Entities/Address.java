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

    private int cap;

    @ManyToOne
    private Comune comune;

    public Address(String via, int civico, int cap, Comune comune){

        this.via = via;
        this.civico = civico;
        //TODO chiedere localita
        this.cap=cap;
        this.comune= comune;
    }

}
