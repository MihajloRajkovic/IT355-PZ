package com.metropolitan.it355.IT355PZ.services.impl;

import com.metropolitan.it355.IT355PZ.entity.Artikli;
import com.metropolitan.it355.IT355PZ.entity.Menistavke;
import com.metropolitan.it355.IT355PZ.repository.MenistavkeRepository;
import com.metropolitan.it355.IT355PZ.services.MenistavkeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MenistavkeServiceImpl implements MenistavkeService {

    private final MenistavkeRepository menistavkeRepository;

    /**
     * Metoda vraca sve Menistavkee
     *
     * @return List<Menistavke>
     */
    @Override
    public List<Menistavke> getAll() {
        return menistavkeRepository.findAll();
    }

    /**
     * Metoda vraca jednog Menistavkea po ID
     *
     * @param id
     * @return Menistavke
     */
    @Override
    public Optional<?> getById(int id) {
        return menistavkeRepository.findById(id);
    }

    /**
     * Metoda dodaje jednog Menistavkea u bazu
     *
     * @param menistavke
     * @return Menistavke
     */
    @Override
    public Menistavke add(Menistavke menistavke) {
        return menistavkeRepository.save(menistavke);
    }

    /**
     * Metoda update-uje Menistavkea u bazu
     *
     * @param menistavke
     * @return Menistavke
     */
    @Override
    public Menistavke update(Menistavke menistavke) {
        return menistavkeRepository.save(menistavke);
    }

    /**
     * Metoda brise Menistavkea iz baze po ID
     *
     * @param id
     */
    @Override
    public void delete(int id) {
        menistavkeRepository.deleteById(id);
    }

    @Override
    public List<?> getAllArtiklibyMeni(Integer meniID) {
      return menistavkeRepository.findAllByMeniID(meniID);
    }
}
