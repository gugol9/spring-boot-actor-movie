package com.example.movie.Service;

import com.example.movie.Model.Actor;
import com.example.movie.Repository.ActorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class ActorServiceTest {


    @Mock
    private ActorRepository actorRepository;

    private ActorService actorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        actorService = new ActorService(actorRepository);
    }

    @Test
    public void testGetTop10Actor() {
        // Przygotowanie danych testowych
        List<Actor> actors = List.of(
                new Actor(1L,
                        "John",
                        "Deer",
                        LocalDate.MAX,
                        "Male",
                        55,
                        true,
                        new ArrayList<>()));

        // Mockowanie zachowania repozytorium
        when(actorRepository.getTop10Actor()).thenReturn(actors);

        // Wywołanie metody, którą testujemy
        List<Actor> topActors = actorService.getTop10Actor();

        // Sprawdzenie wyników
        int expectedSize = Math.min(10, actors.size());
        assertEquals(expectedSize, topActors.size()); // Upewnij się, że otrzymano dokładnie 10 aktorów
        // Dodaj inne asercje, aby sprawdzić oczekiwane wartości w liście topActors
    }
}





