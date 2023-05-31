package com.example.movie.DTO;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ActorDTO {

    private String firstname;
    private String lastname;
    private LocalDate birth;
    private String gender;
    private int score;
    private boolean oscar;
}
