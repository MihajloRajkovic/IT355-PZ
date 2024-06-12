package com.metropolitan.it355.IT355PZ.services;

import com.metropolitan.it355.IT355PZ.entity.Menistavke;
import com.metropolitan.it355.IT355PZ.repository.MenistavkeRepository;
import com.metropolitan.it355.IT355PZ.services.impl.MenistavkeServiceImpl;
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

class MenistavkeServiceImplTest {

    @Mock
    private MenistavkeRepository menistavkeRepository;

    @InjectMocks
    private MenistavkeServiceImpl menistavkeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        // Arrange
        Menistavke menistavke1 = new Menistavke();
        Menistavke menistavke2 = new Menistavke();
        when(menistavkeRepository.findAll()).thenReturn(Arrays.asList(menistavke1, menistavke2));

        // Act
        List<Menistavke> result = menistavkeService.getAll();

        // Assert
        assertEquals(2, result.size());
        verify(menistavkeRepository, times(1)).findAll();
    }

    @Test
    void testGetById() {
        // Arrange
        Menistavke menistavke = new Menistavke();
        when(menistavkeRepository.findById(1)).thenReturn(Optional.of(menistavke));

        // Act
        Optional<?> result = menistavkeService.getById(1);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(menistavke, result.get());
        verify(menistavkeRepository, times(1)).findById(1);
    }

    @Test
    void testAdd() {
        // Arrange
        Menistavke menistavke = new Menistavke();
        when(menistavkeRepository.save(menistavke)).thenReturn(menistavke);

        // Act
        Menistavke result = menistavkeService.add(menistavke);

        // Assert
        assertEquals(menistavke, result);
        verify(menistavkeRepository, times(1)).save(menistavke);
    }

    @Test
    void testUpdate() {
        // Arrange
        Menistavke menistavke = new Menistavke();
        when(menistavkeRepository.save(menistavke)).thenReturn(menistavke);

        // Act
        Menistavke result = menistavkeService.update(menistavke);

        // Assert
        assertEquals(menistavke, result);
        verify(menistavkeRepository, times(1)).save(menistavke);
    }

    @Test
    void testDelete() {
        // Act
        menistavkeService.delete(1);

        // Assert
        verify(menistavkeRepository, times(1)).deleteById(1);
    }

    @Test
    void testGetAllArtiklibyMeni() {
        // Arrange
        Menistavke menistavke1 = new Menistavke();
        Menistavke menistavke2 = new Menistavke();
        when(menistavkeRepository.findAllByMeniID(1)).thenReturn(Arrays.asList(menistavke1, menistavke2));

        // Act
        List<?> result = menistavkeService.getAllArtiklibyMeni(1);

        // Assert
        assertEquals(2, result.size());
        verify(menistavkeRepository, times(1)).findAllByMeniID(1);
    }
}
