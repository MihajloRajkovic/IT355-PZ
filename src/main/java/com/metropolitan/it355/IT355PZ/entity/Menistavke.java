package com.metropolitan.it355.IT355PZ.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "menistavke")
public class Menistavke {
    @Id
    @Column(name = "MeniStavkaID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MeniID")
    private Meni meniID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ArtikalID")
    private Artikli artikalID;

}