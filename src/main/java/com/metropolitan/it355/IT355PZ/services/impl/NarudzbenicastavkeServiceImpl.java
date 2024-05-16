package com.metropolitan.it355.IT355PZ.services.impl;

import com.metropolitan.it355.IT355PZ.entity.Narudzbenicastavke;
import com.metropolitan.it355.IT355PZ.repository.NarudzbenicastavkeRepository;
import com.metropolitan.it355.IT355PZ.services.NarudzbenicastavkeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NarudzbenicastavkeServiceImpl implements NarudzbenicastavkeService {

    private NarudzbenicastavkeRepository narudzbenicastavkeRepository;

    /**
     * Metoda vraca sve Narudzbenicastavkee
     *
     * @return List<Narudzbenicastavke>
     */
    @Override
    public List<Narudzbenicastavke> getAll() {
        return narudzbenicastavkeRepository.findAll();
    }

    /**
     * Metoda vraca jednog Narudzbenicastavkea po ID
     *
     * @param id
     * @return Narudzbenicastavke
     */
    @Override
    public Optional<?> getById(int id) {
        return narudzbenicastavkeRepository.findById(id);
    }

    /**
     * Metoda dodaje jednog Narudzbenicastavkea u bazu
     *
     * @param narudzbenicastavke
     * @return Narudzbenicastavke
     */
    @Override
    public Narudzbenicastavke add(Narudzbenicastavke narudzbenicastavke) {
        return narudzbenicastavkeRepository.save(narudzbenicastavke);
    }

    /**
     * Metoda update-uje Narudzbenicastavkea u bazu
     *
     * @param narudzbenicastavke
     * @return Narudzbenicastavke
     */
    @Override
    public Narudzbenicastavke update(Narudzbenicastavke narudzbenicastavke) {
        return narudzbenicastavkeRepository.save(narudzbenicastavke);
    }

    /**
     * Metoda brise Narudzbenicastavkea iz baze po ID
     *
     * @param id
     */
    @Override
    public void delete(int id) {
        narudzbenicastavkeRepository.deleteById(id);
    }
}
