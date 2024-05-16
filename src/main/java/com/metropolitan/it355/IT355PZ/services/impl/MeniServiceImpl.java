package com.metropolitan.it355.IT355PZ.services.impl;

import com.metropolitan.it355.IT355PZ.entity.Meni;
import com.metropolitan.it355.IT355PZ.repository.MeniRepository;
import com.metropolitan.it355.IT355PZ.services.MeniService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MeniServiceImpl implements MeniService {

    private final MeniRepository meniRepository;

    /**
     * Metoda vraca sve Menie
     *
     * @return List<Meni>
     */
    @Override
    public List<Meni> getAll() {
        return meniRepository.findAll();
    }

    /**
     * Metoda vraca jednog Menia po ID
     *
     * @param id
     * @return Meni
     */
    @Override
    public Optional<?> getById(int id) {
        return meniRepository.findById(id);
    }

    /**
     * Metoda dodaje jednog Menia u bazu
     *
     * @param meni
     * @return Meni
     */
    @Override
    public Meni add(Meni meni) {
        return meniRepository.save(meni);
    }

    /**
     * Metoda update-uje menia u bazu
     *
     * @param meni
     * @return Meni
     */
    @Override
    public Meni update(Meni meni) {
        return meniRepository.save(meni);
    }

    /**
     * Metoda brise Menia iz baze po ID
     *
     * @param id
     */
    @Override
    public void delete(int id) {
    meniRepository.deleteById(id);
    }
}
