package com.metropolitan.it355.IT355PZ.services;

import com.metropolitan.it355.IT355PZ.entity.Korisnici;

import java.util.List;
import java.util.Optional;

public interface KorisniciService {
    /**
     * Metoda vraca sve Korisnicie
     * @return List<Korisnici>
     */
    List<Korisnici> getAll();

    /**
     * Metoda vraca jednog Korisnicia po ID
     * @param id
     * @return Korisnici
     */
    Optional<?> getById(int id);

    /**
     * Metoda dodaje jednog Korisnicia u bazu
     * @param korisnici
     * @return Korisnici
     */
    Korisnici add(Korisnici korisnici);

    /**
     * Metoda update-uje Korisnicia u bazu
     * @param korisnici
     * @return Korisnici
     */
    Korisnici update(Korisnici korisnici);

    /**
     * Metoda brise Korisnicia iz baze po ID
     * @param id
     */
    void delete(int id);
}
