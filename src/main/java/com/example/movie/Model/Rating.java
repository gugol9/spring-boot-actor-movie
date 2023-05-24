package com.example.movie.Model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ratingID;
    private int score;
    private String review;
    private long titleID;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "titleID", referencedColumnName = "titleID", updatable = false, insertable = false)
    private Film film;

}
