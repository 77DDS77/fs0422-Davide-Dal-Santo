package com.BEBW2.ES.EnergyService.Entities;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "provincie")
public class Provincia {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private String sigla;
    private String provincia;
    private String regione;

    public Provincia(String sigla, String provincia, String regione) {
        this.sigla = sigla;
        this.provincia = provincia;
        this.regione = regione;
    }
}
