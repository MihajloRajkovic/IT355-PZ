package com.metropolitan.it355.IT355PZ.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "narudzbenice")
public class Narudzbenice {
    @Id
    @Column(name = "NarudzbenicaID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VlasnikID")
    private Korisnici vlasnikID;

    @Column(name = "DatumNarudzbine")
    private LocalDate datumNarudzbine;

}