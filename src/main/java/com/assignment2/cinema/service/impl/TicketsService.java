package com.assignment2.cinema.service.impl;

import com.assignment2.cinema.entity.Seance;
import com.assignment2.cinema.entity.Ticket;
import com.assignment2.cinema.entity.Visitor;
import com.assignment2.cinema.repository.TicketRepository;
import com.assignment2.cinema.service.InterfaceTicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TicketsService implements InterfaceTicketsService {

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
        if (ticket.getVisitor() != null)
            throw new IllegalArgumentException("This place is already taken");
        ticket.setVisitor(visitor);
        ticketRepository.save(ticket);
        return ticket;
    }

    @Override
    public void deleteAllBySeance(Seance seance) {
        ticketRepository.deleteAllBySeance(seance);
    }

}
