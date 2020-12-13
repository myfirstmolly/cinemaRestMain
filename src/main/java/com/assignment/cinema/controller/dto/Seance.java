package com.assignment.cinema.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Seance {

    private UUID seanceId;
    private String seanceDate;
    private double price;
    private UUID hallId;
    private UUID filmId;

    public Seance(String seanceDate, double price, UUID hallId, UUID filmId) {
        seanceId = UUID.randomUUID();
        this.seanceDate = seanceDate;
        this.price = price;
        this.filmId = filmId;
        this.hallId = hallId;
    }

    public UUID getSeanceId() {
        return seanceId;
    }

    public String getSeanceDate() {
        return seanceDate;
    }

    public double getPrice() {
        return price;
    }

    public UUID getHallId() {
        return hallId;
    }

    public UUID getFilmId() {
        return filmId;
    }
}
