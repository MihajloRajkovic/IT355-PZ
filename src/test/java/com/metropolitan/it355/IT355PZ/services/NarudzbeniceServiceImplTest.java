package com.metropolitan.it355.IT355PZ.services;

import com.metropolitan.it355.IT355PZ.entity.Narudzbenice;
import com.metropolitan.it355.IT355PZ.repository.NarudzbeniceRepository;
import com.metropolitan.it355.IT355PZ.services.impl.NarudzbeniceServiceImpl;
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

class NarudzbeniceServiceImplTest {

    @Mock
    private NarudzbeniceRepository narudzbeniceRepository;

    @InjectMocks
    private NarudzbeniceServiceImpl narudzbeniceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        // Arrange
        Narudzbenice narudzbenice1 = new Narudzbenice();
        Narudzbenice narudzbenice2 = new Narudzbenice();
        when(narudzbeniceRepository.findAll()).thenReturn(Arrays.asList(narudzbenice1, narudzbenice2));

        // Act
        List<Narudzbenice> result = narudzbeniceService.getAll();

        // Assert
        assertEquals(2, result.size());
        verify(narudzbeniceRepository, times(1)).findAll();
    }

    @Test
    void testGetById() {
        // Arrange
        Narudzbenice narudzbenice = new Narudzbenice();
        when(narudzbeniceRepository.findById(1)).thenReturn(Optional.of(narudzbenice));

        // Act
        Optional<?> result = narudzbeniceService.getById(1);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(narudzbenice, result.get());
        verify(narudzbeniceRepository, times(1)).findById(1);
    }

    @Test
    void testAdd() {
        // Arrange
        Narudzbenice narudzbenice = new Narudzbenice();
        when(narudzbeniceRepository.save(narudzbenice)).thenReturn(narudzbenice);

        // Act
        Narudzbenice result = narudzbeniceService.add(narudzbenice);

        // Assert
        assertEquals(narudzbenice, result);
        verify(narudzbeniceRepository, times(1)).save(narudzbenice);
    }

    @Test
    void testUpdate() {
        // Arrange
        Narudzbenice narudzbenice = new Narudzbenice();
        when(narudzbeniceRepository.save(narudzbenice)).thenReturn(narudzbenice);

        // Act
        Narudzbenice result = narudzbeniceService.update(narudzbenice);

        // Assert
        assertEquals(narudzbenice, result);
        verify(narudzbeniceRepository, times(1)).save(narudzbenice);
    }

    @Test
    void testDelete() {
        // Act
        narudzbeniceService.delete(1);

        // Assert
        verify(narudzbeniceRepository, times(1)).deleteById(1);
    }
}
