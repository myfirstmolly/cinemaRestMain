package com.assignment2.cinema.service;

import com.assignment2.cinema.entity.Film;
import com.assignment2.cinema.entity.Seance;
import com.assignment2.cinema.entity.Ticket;
import com.assignment2.cinema.entity.Visitor;

import java.util.List;
import java.util.UUID;

public interface InterfaceSeancesVisitorService {
    Ticket sellTicket(UUID visitorId, UUID seanceId, int line, int place);

    double getCash();

    Visitor addVisitor(Visitor visitor);

    List<Visitor> getAllVisitors();

    Visitor getVisitorById(UUID id);

    void updateVisitorBalance(UUID visitorId, double newBalance);

    void deleteVisitorById(UUID id);

    Seance addSeance(Seance seance);

    List<Seance> getAllSeances();

    Seance getSeanceById(UUID id);

    void deleteSeanceById(UUID id);

    void deleteAllSeancesByFilm(Film film);
}
