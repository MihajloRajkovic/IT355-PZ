package com.metropolitan.it355.IT355PZ.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "korisnici")
public class Korisnici implements UserDetails {
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return this.lozinka;
    }

    @Override
    public String getUsername() {
        return this.korisnickoIme;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}