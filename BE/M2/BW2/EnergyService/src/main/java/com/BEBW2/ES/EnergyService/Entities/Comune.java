package com.BEBW2.ES.EnergyService.Entities;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "comuni")
public class Comune {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private  Long id;

    private String comune;

    @ManyToOne
    @JoinColumn(name = "provincia_id")
    private Provincia provincia;

    public Comune(String comune, Provincia provincia) {
        this.comune = comune;
        this.provincia = provincia;
    }
}
