package com.metropolitan.it355.IT355PZ.services.impl;

import com.metropolitan.it355.IT355PZ.entity.Finansije;
import com.metropolitan.it355.IT355PZ.repository.FinansijeRepository;
import com.metropolitan.it355.IT355PZ.services.FinansijeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FinansijeServiceImpl implements FinansijeService {

    private final FinansijeRepository finansijeRepository;

    /**
     * Metoda vraca sve Finansijee
     *
     * @return List<Finansije>
     */
    @Override
    public List<Finansije> getAll() {
        return finansijeRepository.findAll();
    }

    /**
     * Metoda vraca jednog Finansijea po ID
     *
     * @param id
     * @return Finansije
     */
    @Override
    public Optional<?> getById(int id) {
        return finansijeRepository.findById(id);
    }

    /**
     * Metoda dodaje jednog Finansijea u bazu
     *
     * @param finansije
     * @return Finansije
     */
    @Override
    public Finansije add(Finansije finansije) {
        return finansijeRepository.save(finansije);
    }

    /**
     * Metoda update-uje Finansijea u bazu
     *
     * @param finansije
     * @return Finansije
     */
    @Override
    public Finansije update(Finansije finansije) {
        return finansijeRepository.save(finansije);
    }

    /**
     * Metoda brise Finansijea iz baze po ID
     *
     * @param id
     */
    @Override
    public void delete(int id) {
        finansijeRepository.deleteById(id);
        System.out.println("AAAA");
    }
}
