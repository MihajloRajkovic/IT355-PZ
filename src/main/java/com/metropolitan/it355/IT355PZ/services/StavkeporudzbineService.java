package com.metropolitan.it355.IT355PZ.services;

import com.metropolitan.it355.IT355PZ.entity.Stavkeporudzbine;

import java.util.List;
import java.util.Optional;

public interface StavkeporudzbineService {
    /**
     * Metoda vraca sve Stavkeporudzbinee
     * @return List<Stavkeporudzbine>
     */
    List<Stavkeporudzbine> getAll();

    /**
     * Metoda vraca jednog Stavkeporudzbinea po ID
     * @param id
     * @return Stavkeporudzbine
     */
    Optional<?> getById(int id);

    /**
     * Metoda dodaje jednog Stavkeporudzbinea u bazu
     * @param stavkeporudzbine
     * @return Stavkeporudzbine
     */
    Stavkeporudzbine add(Stavkeporudzbine stavkeporudzbine);

    /**
     * Metoda update-uje Stavkeporudzbinea u bazu
     * @param stavkeporudzbine
     * @return Stavkeporudzbine
     */
    Stavkeporudzbine update(Stavkeporudzbine stavkeporudzbine);

    /**
     * Metoda brise Stavkeporudzbinea iz baze po ID
     * @param id
     */
    void delete(int id);
}
