package com.assignment.cinema.service.impl;

import com.assignment.cinema.controller.dto.Seance;
import com.assignment.cinema.entity.Film;
import com.assignment.cinema.entity.Hall;
import com.assignment.cinema.entity.Ticket;
import com.assignment.cinema.entity.Visitor;
import com.assignment.cinema.repository.FilmRepository;
import com.assignment.cinema.repository.HallRepository;
import com.assignment.cinema.repository.SeanceRepository;
import com.assignment.cinema.service.SeancesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public final class SeancesServiceImpl implements SeancesService {

    @Autowired
    private SeanceRepository seancesRepository;
    @Autowired
    private TicketsServiceImpl ticketsService;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private HallRepository hallRepository;

    private double cash;

    @Override
    public Ticket sellTicket(Visitor visitor, com.assignment.cinema.entity.Seance seance, int line, int place) {
        boolean rightAge;

        cash += seance.getPrice();
        visitor.setMoney(visitor.getMoney() - seance.getPrice());
        Ticket ticket = ticketsService.setVisitorToTicket(visitor, seance, line, place);

        return ticket;
    }

    @Override
    public double getCash() {
        return cash;
    }

    @Override
    public com.assignment.cinema.entity.Seance addSeance(Seance seanceDto) {
        Film film = filmRepository.findById(seanceDto.getFilmId()).get();
        Hall hall = hallRepository.findById(seanceDto.getHallId()).get();
        com.assignment.cinema.entity.Seance seance = new com.assignment.cinema.entity.Seance(seanceDto.getSeanceDate(),
                seanceDto.getPrice(), film, hall);
        com.assignment.cinema.entity.Seance savedSeance = seancesRepository.save(seance);
        createTickets(seance);
        return savedSeance;
    }

    public void createTickets(com.assignment.cinema.entity.Seance seance) {
        Hall hall = seance.getHall();
        int lines = hall.getLinesNum();
        int seats = hall.getSeatsNum();
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < seats; j++) {
                Ticket ticket = new Ticket(seance, i + 1, j + 1);
                ticketsService.addTicket(ticket);
            }
        }
    }

    @Override
    public List<com.assignment.cinema.entity.Seance> getAllSeances() {
        return seancesRepository.findAll();
    }

    @Override
    public com.assignment.cinema.entity.Seance getSeanceById(UUID id) {
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
