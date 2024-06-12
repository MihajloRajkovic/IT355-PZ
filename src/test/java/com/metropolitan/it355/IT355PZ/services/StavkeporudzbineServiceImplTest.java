package com.metropolitan.it355.IT355PZ.services;

import com.metropolitan.it355.IT355PZ.entity.Stavkeporudzbine;
import com.metropolitan.it355.IT355PZ.repository.StavkeporudzbineRepository;
import com.metropolitan.it355.IT355PZ.services.impl.StavkeporudzbineServiceImpl;
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

class StavkeporudzbineServiceImplTest {

    @Mock
    private StavkeporudzbineRepository stavkeporudzbineRepository;

    @InjectMocks
    private StavkeporudzbineServiceImpl stavkeporudzbineService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        // Arrange
        Stavkeporudzbine stavkeporudzbine1 = new Stavkeporudzbine();
        Stavkeporudzbine stavkeporudzbine2 = new Stavkeporudzbine();
        when(stavkeporudzbineRepository.findAll()).thenReturn(Arrays.asList(stavkeporudzbine1, stavkeporudzbine2));

        // Act
        List<Stavkeporudzbine> result = stavkeporudzbineService.getAll();

        // Assert
        assertEquals(2, result.size());
        verify(stavkeporudzbineRepository, times(1)).findAll();
    }

    @Test
    void testGetById() {
        // Arrange
        Stavkeporudzbine stavkeporudzbine = new Stavkeporudzbine();
        when(stavkeporudzbineRepository.findById(1)).thenReturn(Optional.of(stavkeporudzbine));

        // Act
        Optional<?> result = stavkeporudzbineService.getById(1);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(stavkeporudzbine, result.get());
        verify(stavkeporudzbineRepository, times(1)).findById(1);
    }

    @Test
    void testAdd() {
        // Arrange
        Stavkeporudzbine stavkeporudzbine = new Stavkeporudzbine();
        when(stavkeporudzbineRepository.save(stavkeporudzbine)).thenReturn(stavkeporudzbine);

        // Act
        Stavkeporudzbine result = stavkeporudzbineService.add(stavkeporudzbine);

        // Assert
        assertEquals(stavkeporudzbine, result);
        verify(stavkeporudzbineRepository, times(1)).save(stavkeporudzbine);
    }

    @Test
    void testUpdate() {
        // Arrange
        Stavkeporudzbine stavkeporudzbine = new Stavkeporudzbine();
        when(stavkeporudzbineRepository.save(stavkeporudzbine)).thenReturn(stavkeporudzbine);

        // Act
        Stavkeporudzbine result = stavkeporudzbineService.update(stavkeporudzbine);

        // Assert
        assertEquals(stavkeporudzbine, result);
        verify(stavkeporudzbineRepository, times(1)).save(stavkeporudzbine);
    }

    @Test
    void testDelete() {
        // Act
        stavkeporudzbineService.delete(1);

        // Assert
        verify(stavkeporudzbineRepository, times(1)).deleteById(1);
    }
}
