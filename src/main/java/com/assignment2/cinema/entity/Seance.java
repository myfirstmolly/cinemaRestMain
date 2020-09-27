package com.assignment2.cinema.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public final class Seance {

    @Id
    private UUID seanceId;

    private String seanceDate;

    private double price;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "seance")
    private List<Ticket> ticket;

    public Seance(String date, double price, Film film, Hall hall) {
        seanceId = UUID.randomUUID();
        this.seanceDate = date;
        this.price = price;
        this.film = film;
        this.hall = hall;
        ticket = new ArrayList<>();
    }
}
