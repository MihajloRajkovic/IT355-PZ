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
@Table(name = "korisnici")
public class Korisnici {
    @Id
    @Column(name = "KorisnikID", nullable = false)
    private Integer id;

    @Column(name = "Ime", length = 50)
    private String ime;

    @Column(name = "Prezime", length = 50)
    private String prezime;

    @Column(name = "KorisnickoIme", length = 50)
    private String korisnickoIme;

    @Column(name = "Lozinka")
    private String lozinka;

    @Column(name = "TipKorisnika", length = 20)
    private String tipKorisnika;

    @Column(name = "Role", nullable = false)
    private String role;

}