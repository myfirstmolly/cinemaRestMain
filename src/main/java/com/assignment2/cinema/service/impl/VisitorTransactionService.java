package com.assignment2.cinema.service.impl;

import com.assignment2.cinema.entity.Seance;
import com.assignment2.cinema.entity.Ticket;
import com.assignment2.cinema.entity.Visitor;
import com.assignment2.cinema.repository.ProjectionRepository;
import com.assignment2.cinema.repository.TicketsRepository;
import com.assignment2.cinema.repository.VisitorRepository;
import com.assignment2.cinema.service.InterfaceVisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public final class VisitorTransactionService implements InterfaceVisitorService {

    @Autowired
    private VisitorRepository visitorRepository;
    @Autowired
    private TicketsRepository ticketsRepository;
    @Autowired
    private ProjectionRepository projectionRepository;

    private double cash;

    @Override
    public Ticket buyTicket(UUID visitorId, UUID seanceId, int line, int place) {
        Seance seance = projectionRepository.getBySeanceId(seanceId);
        Visitor visitor = visitorRepository.findById(visitorId).get();
        boolean rightAge = false;

        if(seance.getFilm().getRating() != null)
            rightAge = visitor.getAge() >= seance.getFilm().getRating().getAge();
        else rightAge = true;

        boolean enoughMoney = visitor.getMoney() >= seance.getPrice();

        if(!rightAge || !enoughMoney) return null;

        cash += seance.getPrice();
        visitor.setMoney(visitor.getMoney() - seance.getPrice());
        visitor.setTicket(ticketsRepository.getBySeanceAndLineAndSeat(seance, line, place));

        return ticketsRepository.getBySeanceAndLineAndSeat(seance, line, place).
                setVisitor(visitor);
    }

    @Override
    public double getCash() {
        return cash;
    }

    @Override
    public Visitor addVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    @Override
    public List<Visitor> getAll() {
        return visitorRepository.findAll();
    }

    @Override
    public Visitor getById(UUID id) {
        return visitorRepository.findById(id).get();
    }

    @Override
    public void updateBalance(UUID visitorId, double newBalance) {
        visitorRepository.findById(visitorId).get().setMoney(newBalance);
    }

    @Override
    public void deleteById(UUID id) {
        visitorRepository.deleteById(id);
    }
}
