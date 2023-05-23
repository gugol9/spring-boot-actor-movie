package com.example.movie.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    private Long TitleID;
    private String title;
    private LocalDate yearOfProduction;
    private int lengthMinutes;
    private String genre;
    private Long ratinID;
    private Long directorID;
    private Long soundTrackID;

    @Column(name = "ActorID",insertable=false, updatable=false)
    private Long ActorID;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="ActorID", referencedColumnName = "ActorID", updatable = false, insertable = false)
    private Actor actor;


}
