package com.metropolitan.it355.IT355PZ.services;

import com.metropolitan.it355.IT355PZ.entity.Artikli;

import java.util.List;
import java.util.Optional;

public interface ArtikliService {
    /**
     * Metoda vraca sve Artiklie
     * @return List<Artikli>
     */
    List<Artikli> getAll();

    /**
     * Metoda vraca jednog Artiklia po ID
     * @param id
     * @return Artikli
     */
    Optional<?> getById(int id);

    /**
     * Metoda dodaje jednog Artiklia u bazu
     * @param artikli
     * @return Artikli
     */
    Artikli add(Artikli artikli);

    /**
     * Metoda update-uje Artiklia u bazu
     * @param artikli
     * @return Artikli
     */
    Artikli update(Artikli artikli);

    /**
     * Metoda brise Artiklia iz baze po ID
     * @param id
     */
    void delete(int id);

     List<Artikli> getByMenuID(Integer menuID);
}
