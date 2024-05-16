package com.metropolitan.it355.IT355PZ.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "meni")
public class Meni {
    @Id
    @Column(name = "MeniID", nullable = false)
    private Integer id;

    @Column(name = "Naziv", length = 100)
    private String naziv;

}