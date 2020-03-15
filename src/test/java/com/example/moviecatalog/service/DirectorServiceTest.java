package com.example.moviecatalog.service;

import com.example.moviecatalog.model.Director;
import com.example.moviecatalog.repository.DirectorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DirectorServiceTest {

    @Mock
    private DirectorRepository directorRepository;

    @InjectMocks
    private DirectorService onTest = new DirectorService();
    private Director director = new Director();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void persist() {
        onTest.persist(director);
        verify(directorRepository, atMostOnce()).save(director);
    }

    @Test
    void remove() {
    }

    @Test
    void getAll() {
    }

    @Test
    void findById() {
    }
}