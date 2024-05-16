package com.metropolitan.it355.IT355PZ.services;

import com.metropolitan.it355.IT355PZ.entity.Narudzbenicastavke;

import java.util.List;
import java.util.Optional;

public interface NarudzbenicastavkeService {
    /**
     * Metoda vraca sve Narudzbenicastavkee
     * @return List<Narudzbenicastavke>
     */
    List<Narudzbenicastavke> getAll();

    /**
     * Metoda vraca jednog Narudzbenicastavkea po ID
     * @param id
     * @return Narudzbenicastavke
     */
    Optional<?> getById(int id);

    /**
     * Metoda dodaje jednog Narudzbenicastavkea u bazu
     * @param narudzbenicastavke
     * @return Narudzbenicastavke
     */
    Narudzbenicastavke add(Narudzbenicastavke narudzbenicastavke);

    /**
     * Metoda update-uje Narudzbenicastavkea u bazu
     * @param narudzbenicastavke
     * @return Narudzbenicastavke
     */
    Narudzbenicastavke update(Narudzbenicastavke narudzbenicastavke);

    /**
     * Metoda brise Narudzbenicastavkea iz baze po ID
     * @param id
     */
    void delete(int id);
}
