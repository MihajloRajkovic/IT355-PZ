package com.metropolitan.it355.IT355PZ.services.impl;

import com.metropolitan.it355.IT355PZ.entity.Stavkeporudzbine;
import com.metropolitan.it355.IT355PZ.repository.StavkeporudzbineRepository;
import com.metropolitan.it355.IT355PZ.services.StavkeporudzbineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StavkeporudzbineServiceImpl implements StavkeporudzbineService {

    private StavkeporudzbineRepository stavkeporudzbineRepository;

    /**
     * Metoda vraca sve Stavkeporudzbinee
     *
     * @return List<Stavkeporudzbine>
     */
    @Override
    public List<Stavkeporudzbine> getAll() {
        return stavkeporudzbineRepository.findAll();
    }

    /**
     * Metoda vraca jednog Stavkeporudzbinea po ID
     *
     * @param id
     * @return Stavkeporudzbine
     */
    @Override
    public Optional<?> getById(int id) {
        return stavkeporudzbineRepository.findById(id);
    }

    /**
     * Metoda dodaje jednog Stavkeporudzbinea u bazu
     *
     * @param stavkeporudzbine
     * @return Stavkeporudzbine
     */
    @Override
    public Stavkeporudzbine add(Stavkeporudzbine stavkeporudzbine) {
        return stavkeporudzbineRepository.save(stavkeporudzbine);
    }

    /**
     * Metoda update-uje Stavkeporudzbinea u bazu
     *
     * @param stavkeporudzbine
     * @return Stavkeporudzbine
     */
    @Override
    public Stavkeporudzbine update(Stavkeporudzbine stavkeporudzbine) {
        return stavkeporudzbineRepository.save(stavkeporudzbine);
    }

    /**
     * Metoda brise Stavkeporudzbinea iz baze po ID
     *
     * @param id
     */
    @Override
    public void delete(int id) {
        stavkeporudzbineRepository.deleteById(id);
    }
}
