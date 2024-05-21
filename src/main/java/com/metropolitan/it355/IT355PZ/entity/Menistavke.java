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
    @Column(name = "Meni_StavkaID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MeniID")
    private Meni meniID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ArtikalID")
    private Artikli artikalID;

}