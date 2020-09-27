package com.assignment2.cinema.service.impl;

import com.assignment2.cinema.entity.Film;
import com.assignment2.cinema.entity.Hall;
import com.assignment2.cinema.entity.Seance;
import com.assignment2.cinema.entity.Ticket;
import com.assignment2.cinema.repository.CinemaRepository;
import com.assignment2.cinema.repository.SeanceRepository;
import com.assignment2.cinema.service.InterfaceSeancesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SeancesService implements InterfaceSeancesService {

    @Autowired
    private SeanceRepository seancesRepository;
    @Autowired
    private TicketsService ticketsService;
    @Autowired
    private CinemaRepository cinemaRepository;

    @Override
    public Seance addSeance(Seance seance) {
        Seance savedSeance = seancesRepository.save(seance);
        createTickets(seance);
        return savedSeance;
    }

    public void createTickets(Seance seance) {
        Hall hall =  cinemaRepository.findByHallId(seance.getHall().getHallId());
        int lines = hall.getLinesNum();
        int seats = hall.getSeatsNum();
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < seats; j++) {
                Ticket ticket = new Ticket();
                ticket.setSeance(seance);
                System.out.println("hi");
                ticket.setLine(i + 1);
                ticket.setSeat(j + 1);
                ticketsService.addTicket(ticket);
            }
        }
    }

    @Override
    public List<Seance> getAll() {
        return seancesRepository.findAll();
    }

    @Override
    public Seance getById(UUID id) {
        return seancesRepository.findById(id).get();
    }

    @Override
    public void deleteById(UUID id) {
        ticketsService.deleteAllBySeance(seancesRepository.findById(id).get());
        seancesRepository.deleteById(id);
    }

    @Override
    public void deleteAllByFilm(Film film) {
        seancesRepository.deleteAllByFilm(film);
    }

}
