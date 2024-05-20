package com.metropolitan.it355.IT355PZ.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "korisnici")
public class Korisnici {
    @Id
    @Column(name = "Korisnik_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Ime", length = 50)
    private String ime;

    @Column(name = "Prezime", length = 50)
    private String prezime;

    @Column(name = "Korisnicko_Ime", length = 50)
    private String korisnickoIme;

    @Column(name = "Lozinka")
    private String lozinka;

    @Column(name = "Tip_Korisnika", length = 20)
    private String tipKorisnika;

    @Column(name = "Role", nullable = false)
    private String role;

}