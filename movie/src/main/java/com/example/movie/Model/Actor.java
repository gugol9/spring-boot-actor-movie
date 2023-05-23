package com.example.movie.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
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
    private Long ActorID;

    private String firstname;
    private String lastname;
    private LocalDate birth;
    private String gender;
    private int score;
    private boolean oscar;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ActorID", updatable = false, insertable = false)
    @ToString.Exclude
    private List<Film> filmList;
}