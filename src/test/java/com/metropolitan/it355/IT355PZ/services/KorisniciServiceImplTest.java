package com.metropolitan.it355.IT355PZ.services;

import com.metropolitan.it355.IT355PZ.entity.Korisnici;
import com.metropolitan.it355.IT355PZ.repository.KorisniciRepository;
import com.metropolitan.it355.IT355PZ.services.impl.KorisniciServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class KorisniciServiceImplTest {

    @Mock
    private KorisniciRepository korisniciRepository;

    @InjectMocks
    private KorisniciServiceImpl korisniciService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        // Arrange
        Korisnici korisnici1 = new Korisnici();
        Korisnici korisnici2 = new Korisnici();
        when(korisniciRepository.findAll()).thenReturn(Arrays.asList(korisnici1, korisnici2));

        // Act
        List<Korisnici> result = korisniciService.getAll();

        // Assert
        assertEquals(2, result.size());
        verify(korisniciRepository, times(1)).findAll();
    }

    @Test
    void testGetById() {
        // Arrange
        Korisnici korisnici = new Korisnici();
        when(korisniciRepository.findById(1)).thenReturn(Optional.of(korisnici));

        // Act
        Optional<?> result = korisniciService.getById(1);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(korisnici, result.get());
        verify(korisniciRepository, times(1)).findById(1);
    }

    @Test
    void testAdd() {
        // Arrange
        Korisnici korisnici = new Korisnici();
        when(korisniciRepository.save(korisnici)).thenReturn(korisnici);

        // Act
        Korisnici result = korisniciService.add(korisnici);

        // Assert
        assertEquals(korisnici, result);
        verify(korisniciRepository, times(1)).save(korisnici);
    }

    @Test
    void testUpdate() {
        // Arrange
        Korisnici korisnici = new Korisnici();
        when(korisniciRepository.save(korisnici)).thenReturn(korisnici);

        // Act
        Korisnici result = korisniciService.update(korisnici);

        // Assert
        assertEquals(korisnici, result);
        verify(korisniciRepository, times(1)).save(korisnici);
    }

    @Test
    void testDelete() {
        // Act
        korisniciService.delete(1);

        // Assert
        verify(korisniciRepository, times(1)).deleteById(1);
    }

    @Test
    void testGetKorisniciByUsername() {
        // Arrange
        Korisnici korisnici = new Korisnici();
        when(korisniciRepository.findByKorisnickoIme("testUser")).thenReturn(Optional.of(korisnici));

        // Act
        Optional<Korisnici> result = korisniciService.getKorisniciByUsername("testUser");

        // Assert
        assertTrue(result.isPresent());
        assertEquals(korisnici, result.get());
        verify(korisniciRepository, times(1)).findByKorisnickoIme("testUser");
    }
}
