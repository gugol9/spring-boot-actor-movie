package com.example.movie.Repository;

import com.example.movie.Model.Actor;
import com.example.movie.Model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface FilmRepository extends JpaRepository<Film,Long> {



}
