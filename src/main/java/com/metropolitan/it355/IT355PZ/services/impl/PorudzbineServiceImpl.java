package com.metropolitan.it355.IT355PZ.services.impl;

import com.metropolitan.it355.IT355PZ.entity.Porudzbine;
import com.metropolitan.it355.IT355PZ.repository.PorudzbineRepository;
import com.metropolitan.it355.IT355PZ.services.PorudzbineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PorudzbineServiceImpl implements PorudzbineService {


    private PorudzbineRepository porudzbineRepository;

    /**
     * Metoda vraca sve Porudzbinee
     *
     * @return List<Porudzbine>
     */
    @Override
    public List<Porudzbine> getAll() {
        return porudzbineRepository.findAll();
    }

    /**
     * Metoda vraca jednog Porudzbinea po ID
     *
     * @param id
     * @return Porudzbine
     */
    @Override
    public Optional<?> getById(int id) {
        return porudzbineRepository.findById(id);
    }

    /**
     * Metoda dodaje jednog Porudzbinea u bazu
     *
     * @param porudzbine
     * @return Porudzbine
     */
    @Override
    public Porudzbine add(Porudzbine porudzbine) {
        return porudzbineRepository.save(porudzbine);
    }

    /**
     * Metoda update-uje Porudzbinea u bazu
     *
     * @param porudzbine
     * @return Porudzbine
     */
    @Override
    public Porudzbine update(Porudzbine porudzbine) {
        return porudzbineRepository.save(porudzbine);
    }

    /**
     * Metoda brise Porudzbinea iz baze po ID
     *
     * @param id
     */
    @Override
    public void delete(int id) {
        porudzbineRepository.deleteById(id);
    }
}
