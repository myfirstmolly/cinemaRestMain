package com.assignment2.cinema.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Film {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID filmId;

    @Column(unique = true)
    private String name;
    private String director;
    private Integer year;
    private String genre;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    @JsonManagedReference
    @OneToMany(mappedBy = "film")
    private List<Seance> seanceList;

    public Film(String name, String director, Integer year, String genre) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.genre = genre;
    }

    public Film(String name, String director, Integer year, String genre,
                Rating rating) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
    }

}
