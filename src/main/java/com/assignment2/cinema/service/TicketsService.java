package com.assignment2.cinema.service;

import com.assignment2.cinema.entity.Seance;
import com.assignment2.cinema.entity.Ticket;
import com.assignment2.cinema.entity.Visitor;

import java.util.List;
import java.util.UUID;

public interface TicketsService {
    Ticket addTicket(Ticket ticket);

    List<Ticket> getAll();

    Ticket getById(UUID id);

    Ticket setVisitorToTicket(Visitor visitor, Seance seance, int line, int seat);

    void deleteAllBySeance(Seance seance);

    Ticket getBySeanceAndLineAndSeat(Seance seance, int line, int seat);
}
