package com.metropolitan.it355.IT355PZ.services;

import com.metropolitan.it355.IT355PZ.entity.Meni;
import com.metropolitan.it355.IT355PZ.repository.MeniRepository;
import com.metropolitan.it355.IT355PZ.services.impl.MeniServiceImpl;
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

class MeniServiceImplTest {

    @Mock
    private MeniRepository meniRepository;

    @InjectMocks
    private MeniServiceImpl meniService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        // Arrange
        Meni meni1 = new Meni();
        Meni meni2 = new Meni();
        when(meniRepository.findAll()).thenReturn(Arrays.asList(meni1, meni2));

        // Act
        List<Meni> result = meniService.getAll();

        // Assert
        assertEquals(2, result.size());
        verify(meniRepository, times(1)).findAll();
    }

    @Test
    void testGetById() {
        // Arrange
        Meni meni = new Meni();
        when(meniRepository.findById(1)).thenReturn(Optional.of(meni));

        // Act
        Optional<?> result = meniService.getById(1);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(meni, result.get());
        verify(meniRepository, times(1)).findById(1);
    }

    @Test
    void testAdd() {
        // Arrange
        Meni meni = new Meni();
        when(meniRepository.save(meni)).thenReturn(meni);

        // Act
        Meni result = meniService.add(meni);

        // Assert
        assertEquals(meni, result);
        verify(meniRepository, times(1)).save(meni);
    }

    @Test
    void testUpdate() {
        // Arrange
        Meni meni = new Meni();
        when(meniRepository.save(meni)).thenReturn(meni);

        // Act
        Meni result = meniService.update(meni);

        // Assert
        assertEquals(meni, result);
        verify(meniRepository, times(1)).save(meni);
    }

    @Test
    void testDelete() {
        // Act
        meniService.delete(1);

        // Assert
        verify(meniRepository, times(1)).deleteById(1);
    }
}
