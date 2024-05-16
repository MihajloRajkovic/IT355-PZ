package com.metropolitan.it355.IT355PZ.services;

import com.metropolitan.it355.IT355PZ.entity.Porudzbine;

import java.util.List;
import java.util.Optional;

public interface PorudzbineService {
    /**
     * Metoda vraca sve Porudzbinee
     * @return List<Porudzbine>
     */
    List<Porudzbine> getAll();

    /**
     * Metoda vraca jednog Porudzbinea po ID
     * @param id
     * @return Porudzbine
     */
    Optional<?> getById(int id);

    /**
     * Metoda dodaje jednog Porudzbinea u bazu
     * @param porudzbine
     * @return Porudzbine
     */
    Porudzbine add(Porudzbine porudzbine);

    /**
     * Metoda update-uje Porudzbinea u bazu
     * @param porudzbine
     * @return Porudzbine
     */
    Porudzbine update(Porudzbine porudzbine);

    /**
     * Metoda brise Porudzbinea iz baze po ID
     * @param id
     */
    void delete(int id);
}
