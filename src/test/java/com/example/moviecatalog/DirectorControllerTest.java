package com.example.moviecatalog;

import com.example.moviecatalog.service.DirectorService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.Model;
import static org.mockito.Mockito.*;

class DirectorControllerTest {

    @Mock
    DirectorService directorService;

    @Mock
    Model model;

    @InjectMocks
    DirectorController onTest = new DirectorController();

    @Test
    void getDirectors() {
        onTest.getDirectors(model);
        verify(directorService, atMostOnce()).getAll();
    }

    @Test
    void showAddForm() {
    }

    @Test
    void showUpdateForm() {
    }

    @Test
    void addOrUpdateDirector() {
    }

    @Test
    void deleteDirector() {
    }
}