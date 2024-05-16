package com.metropolitan.it355.IT355PZ.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "porudzbine")
public class Porudzbine {
    @Id
    @Column(name = "PorudzbinaID", nullable = false)
    private Integer id;

    @Column(name = "Stol")
    private Integer stol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RadnikID")
    private Korisnici radnikID;

    @ColumnDefault("current_timestamp()")
    @Column(name = "VremePorudzbine", nullable = false)
    private Instant vremePorudzbine;

}