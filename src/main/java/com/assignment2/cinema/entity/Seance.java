package com.assignment2.cinema.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Data
@AllArgsConstructor
public final class Seance {

    @Id
    private final UUID seanceId;

    private final String seanceDate;

    private final double price;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private final Film film;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private final Hall hall;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "seance")
    private final List<Ticket> ticket;

    public Seance(String date, double price, Film film, Hall hall) {
        seanceId = UUID.randomUUID();
        this.seanceDate = date;
        this.price = price;
        this.film = film;
        this.hall = hall;
        ticket = new ArrayList<>();
    }
}
