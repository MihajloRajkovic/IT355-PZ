package com.metropolitan.it355.IT355PZ.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "narudzbenice")
public class Narudzbenice {
    @Id
    @Column(name = "NarudzbenicaID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "VlasnikID")
    private Korisnici vlasnikID;

    @Column(name = "Datum_Narudzbine")
    private Date datumNarudzbine;

}