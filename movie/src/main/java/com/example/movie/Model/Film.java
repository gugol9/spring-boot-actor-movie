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
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TitleID")
    private Long titleId;

    @Column(name = "title")
    private String title;

    @Column(name = "yearOfProduction")
    private LocalDate yearOfProduction;

    @Column(name = "lengthminutes")
    private int lengthMinutes;

    @Column(name = "genre")
    private String genre;

    @Column(name = "ratinID")
    private Long ratinID;

    @Column(name = "directorID")
    private Long directorID;

    @Column(name = "ActorID",insertable=false, updatable=false)
    private Long actorId;

    @ManyToOne()
    @JoinColumn(name="ActorID", referencedColumnName = "ActorID")
    private Actor actor;

}
