package com.assignment2.cinema.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Film {

    @Id
    private UUID filmId;

    @Column(unique = true)
    private String name;
    private String director;
    private Integer year;
    private String genre;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    @JsonIgnore
    @OneToMany(mappedBy = "film", fetch = FetchType.LAZY)
    private List<Seance> seanceList;

    public Film(String name, String director, Integer year, String genre,
                Rating rating) {
        filmId = UUID.randomUUID();
        this.name = name;
        this.director = director;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
    }

}
