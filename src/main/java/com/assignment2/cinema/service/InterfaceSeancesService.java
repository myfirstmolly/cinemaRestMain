package com.assignment2.cinema.service;

import com.assignment2.cinema.entity.Film;
import com.assignment2.cinema.entity.Seance;
import com.assignment2.cinema.entity.Ticket;

import java.util.List;
import java.util.UUID;

public interface InterfaceSeancesService {
    Seance addSeance(Seance seance);
    List<Seance> getAll();
    Seance getById(UUID id);
    void deleteById(UUID id);
    void deleteAllByFilm(Film film);
}
