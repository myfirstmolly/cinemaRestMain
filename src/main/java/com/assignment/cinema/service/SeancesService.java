package com.assignment.cinema.service;

import com.assignment.cinema.controller.dto.Seance;
import com.assignment.cinema.entity.Film;
import com.assignment.cinema.entity.Ticket;
import com.assignment.cinema.entity.Visitor;

import java.util.List;
import java.util.UUID;

public interface SeancesService {
    Ticket sellTicket(Visitor visitor, com.assignment.cinema.entity.Seance seance, int line, int place);

    double getCash();

    com.assignment.cinema.entity.Seance addSeance(Seance seance);

    List<com.assignment.cinema.entity.Seance> getAllSeances();

    com.assignment.cinema.entity.Seance getSeanceById(UUID id);

    void deleteSeanceById(UUID id);

    void deleteAllSeancesByFilm(Film film);
}
