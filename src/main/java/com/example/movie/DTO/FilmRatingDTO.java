package com.example.movie.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class FilmRatingDTO {

    private String title;
    private Long score;

    public FilmRatingDTO(String title, Long score) {
        this.title = title;
        this.score = score;
    }
}
