package com.example.movie.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity

@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ActorID")
    private Long actorid;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "birth")
    private LocalDate birth;

    @Column(name = "gender")
    private String gender;

    @Column(name = "score")
    private int score;

    @Column(name = "oscar")
    private boolean oscar;



    @OneToMany(mappedBy = "actor", cascade = CascadeType.ALL)
    private List<Film> films;






}
