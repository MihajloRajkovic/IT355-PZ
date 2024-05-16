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
    @Column(name = "NarudzbenicaStavkaID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NarudzbenicaID")
    private Narudzbenice narudzbenicaID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ArtikalID")
    private Artikli artikalID;

    @Column(name = "Kolicina")
    private Integer kolicina;

}