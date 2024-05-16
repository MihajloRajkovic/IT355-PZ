package com.metropolitan.it355.IT355PZ.services.impl;

import com.metropolitan.it355.IT355PZ.entity.Korisnici;
import com.metropolitan.it355.IT355PZ.repository.KorisniciRepository;
import com.metropolitan.it355.IT355PZ.services.KorisniciService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class KorisniciServiceImpl implements KorisniciService {

    private KorisniciRepository korisniciRepository;

    /**
     * Metoda vraca sve Korisnicie
     *
     * @return List<Korisnici>
     */
    @Override
    public List<Korisnici> getAll() {
        return korisniciRepository.findAll();
    }

    /**
     * Metoda vraca jednog Korisnicia po ID
     *
     * @param id
     * @return Korisnici
     */
    @Override
    public Optional<?> getById(int id) {
        return korisniciRepository.findById(id);
    }

    /**
     * Metoda dodaje jednog Korisnicia u bazu
     *
     * @param korisnici
     * @return Korisnici
     */
    @Override
    public Korisnici add(Korisnici korisnici) {
        return korisniciRepository.save(korisnici);
    }

    /**
     * Metoda update-uje Korisnicia u bazu
     *
     * @param korisnici
     * @return Korisnici
     */
    @Override
    public Korisnici update(Korisnici korisnici) {
        return korisniciRepository.save(korisnici);
    }

    /**
     * Metoda brise Korisnicia iz baze po ID
     *
     * @param id
     */
    @Override
    public void delete(int id) {
        korisniciRepository.deleteById(id);
    }
}
