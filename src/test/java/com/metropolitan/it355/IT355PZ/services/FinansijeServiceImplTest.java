package com.metropolitan.it355.IT355PZ.services;
import com.metropolitan.it355.IT355PZ.entity.Finansije;
import com.metropolitan.it355.IT355PZ.repository.FinansijeRepository;
import com.metropolitan.it355.IT355PZ.services.impl.FinansijeServiceImpl;
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

class FinansijeServiceImplTest {

    @Mock
    private FinansijeRepository finansijeRepository;

    @InjectMocks
    private FinansijeServiceImpl finansijeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        // Arrange
        Finansije finansije1 = new Finansije();
        Finansije finansije2 = new Finansije();
        when(finansijeRepository.findAll()).thenReturn(Arrays.asList(finansije1, finansije2));

        // Act
        List<Finansije> result = finansijeService.getAll();

        // Assert
        assertEquals(2, result.size());
        verify(finansijeRepository, times(1)).findAll();
    }

    @Test
    void testGetById() {
        // Arrange
        Finansije finansije = new Finansije();
        when(finansijeRepository.findById(1)).thenReturn(Optional.of(finansije));

        // Act
        Optional<?> result = finansijeService.getById(1);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(finansije, result.get());
        verify(finansijeRepository, times(1)).findById(1);
    }

    @Test
    void testAdd() {
        // Arrange
        Finansije finansije = new Finansije();
        when(finansijeRepository.save(finansije)).thenReturn(finansije);

        // Act
        Finansije result = finansijeService.add(finansije);

        // Assert
        assertEquals(finansije, result);
        verify(finansijeRepository, times(1)).save(finansije);
    }

    @Test
    void testUpdate() {
        // Arrange
        Finansije finansije = new Finansije();
        when(finansijeRepository.save(finansije)).thenReturn(finansije);

        // Act
        Finansije result = finansijeService.update(finansije);

        // Assert
        assertEquals(finansije, result);
        verify(finansijeRepository, times(1)).save(finansije);
    }

    @Test
    void testDelete() {
        // Act
        finansijeService.delete(1);

        // Assert
        verify(finansijeRepository, times(1)).deleteById(1);
    }
}
