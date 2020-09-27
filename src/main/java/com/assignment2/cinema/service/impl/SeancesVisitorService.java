package com.assignment2.cinema.service.impl;

import com.assignment2.cinema.entity.*;
import com.assignment2.cinema.repository.CinemaRepository;
import com.assignment2.cinema.repository.SeanceRepository;
import com.assignment2.cinema.repository.VisitorRepository;
import com.assignment2.cinema.service.InterfaceSeancesVisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SeancesVisitorService implements InterfaceSeancesVisitorService {

    @Autowired
    private SeanceRepository seancesRepository;
    @Autowired
    private TicketsService ticketsService;
    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private VisitorRepository visitorRepository;

    private double cash;

    @Override
    public Ticket sellTicket(UUID visitorId, UUID seanceId, int line, int place) {
        Seance seance = seancesRepository.findById(seanceId).get();
        Visitor visitor = visitorRepository.findById(visitorId).get();
        boolean rightAge;

        if (seance.getFilm().getRating() != null)
            rightAge = visitor.getAge() >= seance.getFilm().getRating().getAge();
        else rightAge = true;

        boolean enoughMoney = visitor.getMoney() >= seance.getPrice();

        if (!rightAge || !enoughMoney) return null;

        cash += seance.getPrice();
        visitor.setMoney(visitor.getMoney() - seance.getPrice());
        Ticket ticket = ticketsService.setVisitorToTicket(visitor, seance, line, place);
        visitor.setTicket(ticket);

        return ticket;
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
    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }

    @Override
    public Visitor getVisitorById(UUID id) {
        return visitorRepository.findById(id).get();
    }

    @Override
    public void updateVisitorBalance(UUID visitorId, double newBalance) {
        visitorRepository.findById(visitorId).get().setMoney(newBalance);
    }

    @Override
    public void deleteVisitorById(UUID id) {
        visitorRepository.deleteById(id);
    }

    @Override
    public Seance addSeance(Seance seance) {
        Seance savedSeance = seancesRepository.save(seance);
        createTickets(seance);
        return savedSeance;
    }

    public void createTickets(Seance seance) {
        Hall hall = cinemaRepository.findByHallId(seance.getHall().getHallId());
        int lines = hall.getLinesNum();
        int seats = hall.getSeatsNum();
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < seats; j++) {
                Ticket ticket = new Ticket();
                ticket.setSeance(seance);
                ticket.setLine(i + 1);
                ticket.setSeat(j + 1);
                ticketsService.addTicket(ticket);
            }
        }
    }

    @Override
    public List<Seance> getAllSeances() {
        return seancesRepository.findAll();
    }

    @Override
    public Seance getSeanceById(UUID id) {
        return seancesRepository.findById(id).get();
    }

    @Override
    public void deleteSeanceById(UUID id) {
        ticketsService.deleteAllBySeance(seancesRepository.findById(id).get());
        seancesRepository.deleteById(id);
    }

    @Override
    public void deleteAllSeancesByFilm(Film film) {
        seancesRepository.deleteAllByFilm(film);
    }

}
