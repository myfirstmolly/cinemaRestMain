package com.assignment.cinema.service;

import com.assignment.cinema.entity.Seance;
import com.assignment.cinema.entity.Ticket;
import com.assignment.cinema.entity.Visitor;

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
