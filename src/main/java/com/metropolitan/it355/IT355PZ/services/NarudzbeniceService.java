package com.metropolitan.it355.IT355PZ.services;

import com.metropolitan.it355.IT355PZ.entity.Narudzbenice;

import java.util.List;
import java.util.Optional;

public interface NarudzbeniceService {
    /**
     * Metoda vraca sve Narudzbenicee
     * @return List<Narudzbenice>
     */
    List<Narudzbenice> getAll();

    /**
     * Metoda vraca jednog Narudzbenicea po ID
     * @param id
     * @return Narudzbenice
     */
    Optional<?> getById(int id);

    /**
     * Metoda dodaje jednog Narudzbenicea u bazu
     * @param narudzbenice
     * @return Narudzbenice
     */
    Narudzbenice add(Narudzbenice narudzbenice);

    /**
     * Metoda update-uje Narudzbenicea u bazu
     * @param narudzbenice
     * @return Narudzbenice
     */
    Narudzbenice update(Narudzbenice narudzbenice);

    /**
     * Metoda brise Narudzbenicea iz baze po ID
     * @param id
     */
    void delete(int id);
}
