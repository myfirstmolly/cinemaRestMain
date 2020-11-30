package com.assignment.cinema.service.impl;

import com.assignment.cinema.entity.Seance;
import com.assignment.cinema.entity.Ticket;
import com.assignment.cinema.entity.Visitor;
import com.assignment.cinema.repository.TicketRepository;
import com.assignment.cinema.service.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public final class TicketsServiceImpl implements TicketsService {

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public Ticket addTicket(Ticket ticket) {
        Ticket savedTicket = ticketRepository.save(ticket);
        return savedTicket;
    }

    @Override
    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket getById(UUID id) {
        return ticketRepository.getOne(id);
    }

    @Override
    public Ticket getBySeanceAndLineAndSeat(Seance seance, int line, int seat) {
        return ticketRepository.getBySeanceAndLineAndSeat(seance, line, seat);
    }

    @Override
    public Ticket setVisitorToTicket(Visitor visitor, Seance seance, int line, int seat) {
        Ticket ticket = ticketRepository.getBySeanceAndLineAndSeat(seance, line, seat);
        if (ticketRepository.getBySeanceAndLineAndSeat(seance, line, seat) == null)
            throw new IllegalArgumentException("No such place in hall");
        if (ticket.getVisitor() != null)
            throw new IllegalArgumentException("This place is already taken");
        Ticket updated = ticket.setVisitor(visitor);
        ticketRepository.save(updated);
        return updated;
    }

    @Override
    public void deleteAllBySeance(Seance seance) {
        ticketRepository.deleteAllBySeance(seance);
    }

}
