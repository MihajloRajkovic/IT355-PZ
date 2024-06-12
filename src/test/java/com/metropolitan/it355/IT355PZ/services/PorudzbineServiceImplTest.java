package com.metropolitan.it355.IT355PZ.services;

import com.metropolitan.it355.IT355PZ.entity.Porudzbine;
import com.metropolitan.it355.IT355PZ.repository.PorudzbineRepository;
import com.metropolitan.it355.IT355PZ.services.impl.PorudzbineServiceImpl;
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

class PorudzbineServiceImplTest {

    @Mock
    private PorudzbineRepository porudzbineRepository;

    @InjectMocks
    private PorudzbineServiceImpl porudzbineService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        // Arrange
        Porudzbine porudzbine1 = new Porudzbine();
        Porudzbine porudzbine2 = new Porudzbine();
        when(porudzbineRepository.findAll()).thenReturn(Arrays.asList(porudzbine1, porudzbine2));

        // Act
        List<Porudzbine> result = porudzbineService.getAll();

        // Assert
        assertEquals(2, result.size());
        verify(porudzbineRepository, times(1)).findAll();
    }

    @Test
    void testGetById() {
        // Arrange
        Porudzbine porudzbine = new Porudzbine();
        when(porudzbineRepository.findById(1)).thenReturn(Optional.of(porudzbine));

        // Act
        Optional<?> result = porudzbineService.getById(1);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(porudzbine, result.get());
        verify(porudzbineRepository, times(1)).findById(1);
    }

    @Test
    void testAdd() {
        // Arrange
        Porudzbine porudzbine = new Porudzbine();
        when(porudzbineRepository.save(porudzbine)).thenReturn(porudzbine);

        // Act
        Porudzbine result = porudzbineService.add(porudzbine);

        // Assert
        assertEquals(porudzbine, result);
        verify(porudzbineRepository, times(1)).save(porudzbine);
    }

    @Test
    void testUpdate() {
        // Arrange
        Porudzbine porudzbine = new Porudzbine();
        when(porudzbineRepository.save(porudzbine)).thenReturn(porudzbine);

        // Act
        Porudzbine result = porudzbineService.update(porudzbine);

        // Assert
        assertEquals(porudzbine, result);
        verify(porudzbineRepository, times(1)).save(porudzbine);
    }

    @Test
    void testDelete() {
        // Act
        porudzbineService.delete(1);

        // Assert
        verify(porudzbineRepository, times(1)).deleteById(1);
    }
}
