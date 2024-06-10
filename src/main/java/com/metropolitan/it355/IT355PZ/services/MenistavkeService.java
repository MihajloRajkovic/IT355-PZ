package com.metropolitan.it355.IT355PZ.services;

import com.metropolitan.it355.IT355PZ.entity.Artikli;
import com.metropolitan.it355.IT355PZ.entity.Menistavke;

import java.util.List;
import java.util.Optional;

public interface MenistavkeService {
    /**
     * Metoda vraca sve Menistavkee
     * @return List<Menistavke>
     */
    List<Menistavke> getAll();

    /**
     * Metoda vraca jednog Menistavkea po ID
     * @param id
     * @return Menistavke
     */
    Optional<?> getById(int id);

    /**
     * Metoda dodaje jednog Menistavkea u bazu
     * @param menistavke
     * @return Menistavke
     */
    Menistavke add(Menistavke menistavke);

    /**
     * Metoda update-uje Menistavkea u bazu
     * @param menistavke
     * @return Menistavke
     */
    Menistavke update(Menistavke menistavke);

    /**
     * Metoda brise Menistavkea iz baze po ID
     * @param id
     */
    void delete(int id);

    /**
     * Vraca sve artikle za meni
     * @param meniID
     * @return List<Artikli>
     */
    List<?> getAllArtiklibyMeni(Integer meniID);
}
