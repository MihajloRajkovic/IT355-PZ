package com.metropolitan.it355.IT355PZ.services;

import com.metropolitan.it355.IT355PZ.entity.Meni;

import java.util.List;
import java.util.Optional;

public interface MeniService {
    /**
     * Metoda vraca sve Menie
     * @return List<Meni>
     */
    List<Meni> getAll();

    /**
     * Metoda vraca jednog Menia po ID
     * @param id
     * @return Meni
     */
    Optional<?> getById(int id);

    /**
     * Metoda dodaje jednog Menia u bazu
     * @param meni
     * @return Meni
     */
    Meni add(Meni meni);

    /**
     * Metoda update-uje menia u bazu
     * @param meni
     * @return Meni
     */
    Meni update(Meni meni);

    /**
     * Metoda brise Menia iz baze po ID
     * @param id
     */
    void delete(int id);
}
