package com.metropolitan.it355.IT355PZ.services.impl;

import com.metropolitan.it355.IT355PZ.entity.Artikli;
import com.metropolitan.it355.IT355PZ.repository.ArtikliRepository;
import com.metropolitan.it355.IT355PZ.services.ArtikliService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ArtikliServiceImpl implements ArtikliService {

    private ArtikliRepository artikliRepository;


    /**
     * Metoda vraca sve Artiklie
     *
     * @return List<Artikli>
     */
    @Override
    public List<Artikli> getAll() {
        return artikliRepository.findAll();
    }

    /**
     * Metoda vraca jednog Artiklia po ID
     *
     * @param id
     * @return Artikli
     */
    @Override
    public Optional<?> getById(int id) {
        return artikliRepository.findById(id);
    }

    /**
     * Metoda dodaje jednog Artiklia u bazu
     *
     * @param artikli
     * @return Artikli
     */
    @Override
    public Artikli add(Artikli artikli) {
        return artikliRepository.save(artikli);
    }

    /**
     * Metoda update-uje Artiklia u bazu
     *
     * @param artikli
     * @return Artikli
     */
    @Override
    public Artikli update(Artikli artikli) {
        return artikliRepository.save(artikli);
    }

    /**
     * Metoda brise Artiklia iz baze po ID
     *
     * @param id
     */
    @Override
    public void delete(int id) {
        artikliRepository.deleteById(id);
    }
}
