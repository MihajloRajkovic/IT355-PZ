package com.metropolitan.it355.IT355PZ.services;

import com.metropolitan.it355.IT355PZ.entity.Narudzbenicastavke;
import com.metropolitan.it355.IT355PZ.repository.NarudzbenicastavkeRepository;
import com.metropolitan.it355.IT355PZ.services.impl.NarudzbenicastavkeServiceImpl;
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

class NarudzbenicastavkeServiceImplTest {

    @Mock
    private NarudzbenicastavkeRepository narudzbenicastavkeRepository;

    @InjectMocks
    private NarudzbenicastavkeServiceImpl narudzbenicastavkeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        // Arrange
        Narudzbenicastavke narudzbenicastavke1 = new Narudzbenicastavke();
        Narudzbenicastavke narudzbenicastavke2 = new Narudzbenicastavke();
        when(narudzbenicastavkeRepository.findAll()).thenReturn(Arrays.asList(narudzbenicastavke1, narudzbenicastavke2));

        // Act
        List<Narudzbenicastavke> result = narudzbenicastavkeService.getAll();

        // Assert
        assertEquals(2, result.size());
        verify(narudzbenicastavkeRepository, times(1)).findAll();
    }

    @Test
    void testGetById() {
        // Arrange
        Narudzbenicastavke narudzbenicastavke = new Narudzbenicastavke();
        when(narudzbenicastavkeRepository.findById(1)).thenReturn(Optional.of(narudzbenicastavke));

        // Act
        Optional<?> result = narudzbenicastavkeService.getById(1);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(narudzbenicastavke, result.get());
        verify(narudzbenicastavkeRepository, times(1)).findById(1);
    }

    @Test
    void testAdd() {
        // Arrange
        Narudzbenicastavke narudzbenicastavke = new Narudzbenicastavke();
        when(narudzbenicastavkeRepository.save(narudzbenicastavke)).thenReturn(narudzbenicastavke);

        // Act
        Narudzbenicastavke result = narudzbenicastavkeService.add(narudzbenicastavke);

        // Assert
        assertEquals(narudzbenicastavke, result);
        verify(narudzbenicastavkeRepository, times(1)).save(narudzbenicastavke);
    }

    @Test
    void testUpdate() {
        // Arrange
        Narudzbenicastavke narudzbenicastavke = new Narudzbenicastavke();
        when(narudzbenicastavkeRepository.save(narudzbenicastavke)).thenReturn(narudzbenicastavke);

        // Act
        Narudzbenicastavke result = narudzbenicastavkeService.update(narudzbenicastavke);

        // Assert
        assertEquals(narudzbenicastavke, result);
        verify(narudzbenicastavkeRepository, times(1)).save(narudzbenicastavke);
    }

    @Test
    void testDelete() {
        // Act
        narudzbenicastavkeService.delete(1);

        // Assert
        verify(narudzbenicastavkeRepository, times(1)).deleteById(1);
    }
}
