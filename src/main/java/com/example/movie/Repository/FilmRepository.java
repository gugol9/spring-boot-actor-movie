package com.example.movie.Repository;

import com.example.movie.DTO.FilmRatingDTO;
import com.example.movie.Model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public interface FilmRepository extends JpaRepository<Film,Long> {


    @Query("SELECT f.genre FROM Film f GROUP BY f.genre")
    List<String> getFilmGenre();


    @Query( "SELECT new com.example.movie.DTO.FilmRatingDTO(f.title, SUM(r.score)) FROM Film f JOIN f.ratingList r GROUP BY f.title  ORDER BY SUM(r.score) DESC")
    List<FilmRatingDTO> top10FilmScore();



}
