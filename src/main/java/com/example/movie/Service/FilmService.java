package com.example.movie.Service;

import com.example.movie.Model.Film;
import com.example.movie.Repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {this.filmRepository = filmRepository;}

    public List<Film> getFilm(){
        return filmRepository.findAll();
    }





}
