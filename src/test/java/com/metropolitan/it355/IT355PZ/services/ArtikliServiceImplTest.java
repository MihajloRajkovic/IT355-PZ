package com.metropolitan.it355.IT355PZ.services;

import com.metropolitan.it355.IT355PZ.entity.Artikli;
import com.metropolitan.it355.IT355PZ.repository.ArtikliRepository;
import com.metropolitan.it355.IT355PZ.services.impl.ArtikliServiceImpl;
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

class ArtikliServiceImplTest {

    @Mock
    private ArtikliRepository artikliRepository;

    @InjectMocks
    private ArtikliServiceImpl artikliService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        // Arrange
        Artikli artikli1 = new Artikli();
        Artikli artikli2 = new Artikli();
        when(artikliRepository.findAll()).thenReturn(Arrays.asList(artikli1, artikli2));

        // Act
        List<Artikli> result = artikliService.getAll();

        // Assert
        assertEquals(2, result.size());
        verify(artikliRepository, times(1)).findAll();
    }

    @Test
    void testGetById() {
        // Arrange
        Artikli artikli = new Artikli();
        when(artikliRepository.findById(1)).thenReturn(Optional.of(artikli));

        // Act
        Optional<?> result = artikliService.getById(1);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(artikli, result.get());
        verify(artikliRepository, times(1)).findById(1);
    }

    @Test
    void testAdd() {
        // Arrange
        Artikli artikli = new Artikli();
        when(artikliRepository.save(artikli)).thenReturn(artikli);

        // Act
        Artikli result = artikliService.add(artikli);

        // Assert
        assertEquals(artikli, result);
        verify(artikliRepository, times(1)).save(artikli);
    }

    @Test
    void testUpdate() {
        // Arrange
        Artikli artikli = new Artikli();
        when(artikliRepository.save(artikli)).thenReturn(artikli);

        // Act
        Artikli result = artikliService.update(artikli);

        // Assert
        assertEquals(artikli, result);
        verify(artikliRepository, times(1)).save(artikli);
    }

    @Test
    void testDelete() {
        // Act
        artikliService.delete(1);

        // Assert
        verify(artikliRepository, times(1)).deleteById(1);
    }

    @Test
    void testGetByMenuID() {
        // Arrange
        Artikli artikli1 = new Artikli();
        Artikli artikli2 = new Artikli();
        when(artikliRepository.getArtiklibyMenuID(1)).thenReturn(Arrays.asList(artikli1, artikli2));

        // Act
        List<Artikli> result = artikliService.getByMenuID(1);

        // Assert
        assertEquals(2, result.size());
        verify(artikliRepository, times(1)).getArtiklibyMenuID(1);
    }
}
