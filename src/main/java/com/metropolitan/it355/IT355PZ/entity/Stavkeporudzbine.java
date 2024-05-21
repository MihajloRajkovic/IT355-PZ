package com.metropolitan.it355.IT355PZ.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "stavkeporudzbine")
public class Stavkeporudzbine {
    @Id
    @Column(name = "StavkaID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PorudzbinaID")
    private Porudzbine porudzbinaID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ArtikalID")
    private Artikli artikalID;

    @Column(name = "Kolicina")
    private Integer kolicina;

    @Column(name = "Cena", precision = 10, scale = 2)
    private BigDecimal cena;

}