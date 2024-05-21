package com.metropolitan.it355.IT355PZ.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "artikli")
public class Artikli {
    @Id
    @Column(name = "ArtikalID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Naziv", length = 100)
    private String naziv;

    @Column(name = "Cena", precision = 10, scale = 2)
    private BigDecimal cena;

    @Column(name = "Kolicina_Na_Stanju")
    private Integer kolicinaNaStanju;

}