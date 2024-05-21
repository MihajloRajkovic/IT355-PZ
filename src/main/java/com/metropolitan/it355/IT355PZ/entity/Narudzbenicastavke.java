package com.metropolitan.it355.IT355PZ.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "narudzbenicastavke")
public class Narudzbenicastavke {
    @Id
    @Column(name = "Narudzbenica_StavkaID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "NarudzbenicaID")
    private Narudzbenice narudzbenicaID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ArtikalID")
    private Artikli artikalID;

    @Column(name = "Kolicina")
    private Integer kolicina;

}