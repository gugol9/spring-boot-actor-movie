package com.example.movie;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long actorid;

    private String firstname;
    private String lastname;
    private LocalDate birth;
    private String gender;
    private int score;
    private boolean oscar;

}
