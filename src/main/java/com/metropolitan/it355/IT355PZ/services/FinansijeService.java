package com.metropolitan.it355.IT355PZ.services;

import com.metropolitan.it355.IT355PZ.entity.Finansije;

import java.util.List;
import java.util.Optional;

public interface FinansijeService {
    /**
     * Metoda vraca sve Finansijee
     * @return List<Finansije>
     */
    List<Finansije> getAll();

    /**
     * Metoda vraca jednog Finansijea po ID
     * @param id
     * @return Finansije
     */
    Optional<?> getById(int id);

    /**
     * Metoda dodaje jednog Finansijea u bazu
     * @param finansije
     * @return Finansije
     */
    Finansije add(Finansije finansije);

    /**
     * Metoda update-uje Finansijea u bazu
     * @param finansije
     * @return Finansije
     */
    Finansije update(Finansije finansije);

    /**
     * Metoda brise Finansijea iz baze po ID
     * @param id
     */
    void delete(int id);
}
