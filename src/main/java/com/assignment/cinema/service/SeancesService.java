package com.assignment.cinema.service;

import com.assignment.cinema.controller.dto.SeanceDto;
import com.assignment.cinema.entity.Film;
import com.assignment.cinema.entity.Seance;
import com.assignment.cinema.entity.Ticket;
import com.assignment.cinema.entity.Visitor;

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
