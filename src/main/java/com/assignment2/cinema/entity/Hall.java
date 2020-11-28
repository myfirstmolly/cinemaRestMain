package com.assignment2.cinema.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public final class Hall {

    private UUID hallId;
    private final String name;

    private final int linesNum;
    private final int seatsNum;
    private final List<Seance> seances;

    public Hall(String name, int linesNum, int seatsNum) {
        this.name = name;
        this.linesNum = linesNum;
        this.seatsNum = seatsNum;
        this.seances = new ArrayList<>();
    }

    public UUID getHallId() {
        return hallId;
    }
}
