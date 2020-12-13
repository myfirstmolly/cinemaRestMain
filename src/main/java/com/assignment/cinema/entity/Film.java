package com.assignment.cinema.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Data
@AllArgsConstructor
public final class Film {

    @Id
    private final UUID filmId;

    @Column(unique = true)
    private final String name;
    private final String director;
    private final Integer year;

    @Enumerated(EnumType.STRING)
    private final Genre genre;

    @JsonIgnore
    @OneToMany(mappedBy = "film", fetch = FetchType.LAZY)
    private List<Seance> seanceList;

    public Film(String name, String director, Integer year, Genre genre) {
        filmId = UUID.randomUUID();
        this.name = name;
        this.director = director;
        this.year = year;
        this.genre = genre;
    }

    public UUID getFilmId() {
        return filmId;
    }
}
