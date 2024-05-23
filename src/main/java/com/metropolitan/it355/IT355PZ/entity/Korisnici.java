package com.metropolitan.it355.IT355PZ.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @JsonIgnore
    private static final Map<String, List<String>> rolePermissions = Map.of(
            "USER", List.of("READ_ONLY"),
            "ADMIN", List.of("FULL_ACCESS")
    );

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = rolePermissions.get(role).stream().map(
                SimpleGrantedAuthority::new
        ).collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        return authorities;
    }
    @JsonIgnore
    @Override
    public String getPassword() {
        return this.lozinka;
    }
    @JsonIgnore
    @Override
    public String getUsername() {
        return this.korisnickoIme;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}