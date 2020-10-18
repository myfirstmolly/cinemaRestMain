package com.assignment2.cinema.service;

import com.assignment2.cinema.controller.dto.SeanceDto;
import com.assignment2.cinema.entity.Film;
import com.assignment2.cinema.entity.Seance;
import com.assignment2.cinema.entity.Ticket;
import com.assignment2.cinema.entity.Visitor;

import java.util.List;
import java.util.UUID;

public interface SeancesService {
    Ticket sellTicket(Visitor visitor, Seance seance, int line, int place);

    double getCash();

    Seance addSeance(SeanceDto seance);

    List<Seance> getAllSeances();

    Seance getSeanceById(UUID id);

    void deleteSeanceById(UUID id);

    void deleteAllSeancesByFilm(Film film);
}
