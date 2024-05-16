package com.metropolitan.it355.IT355PZ.services.impl;

import com.metropolitan.it355.IT355PZ.entity.Narudzbenice;
import com.metropolitan.it355.IT355PZ.repository.NarudzbeniceRepository;
import com.metropolitan.it355.IT355PZ.services.NarudzbeniceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NarudzbeniceServiceImpl implements NarudzbeniceService {

    private final NarudzbeniceRepository narudzbeniceRepository;

    /**
     * Metoda vraca sve Narudzbenicee
     *
     * @return List<Narudzbenice>
     */
    @Override
    public List<Narudzbenice> getAll() {
        return narudzbeniceRepository.findAll();
    }

    /**
     * Metoda vraca jednog Narudzbenicea po ID
     *
     * @param id
     * @return Narudzbenice
     */
    @Override
    public Optional<?> getById(int id) {
        return narudzbeniceRepository.findById(id);
    }

    /**
     * Metoda dodaje jednog Narudzbenicea u bazu
     *
     * @param narudzbenice
     * @return Narudzbenice
     */
    @Override
    public Narudzbenice add(Narudzbenice narudzbenice) {
        return narudzbeniceRepository.save(narudzbenice);
    }

    /**
     * Metoda update-uje Narudzbenicea u bazu
     *
     * @param narudzbenice
     * @return Narudzbenice
     */
    @Override
    public Narudzbenice update(Narudzbenice narudzbenice) {
        return narudzbeniceRepository.save(narudzbenice);
    }

    /**
     * Metoda brise Narudzbenicea iz baze po ID
     *
     * @param id
     */
    @Override
    public void delete(int id) {
        narudzbeniceRepository.deleteById(id);
    }
}
