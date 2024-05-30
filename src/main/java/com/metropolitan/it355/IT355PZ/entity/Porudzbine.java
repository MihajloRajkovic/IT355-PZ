package com.metropolitan.it355.IT355PZ.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.DateTimeException;
import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "porudzbine")
public class Porudzbine {
    @Id
    @Column(name = "PorudzbinaID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Sto")
    private Integer sto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RadnikID")
    private Korisnici radnikID;

    @ColumnDefault("current_timestamp()")
    @Column(name = "Vreme_Porudzbine", nullable = false)
    private Date vremePorudzbine;

}