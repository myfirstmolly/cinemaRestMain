//package com.assignment2.cinema.service.impl;
//
//import com.assignment2.cinema.controller.dto.SeanceDto;
//import com.assignment2.cinema.entity.*;
//import com.assignment2.cinema.repository.FilmRepository;
//import com.assignment2.cinema.repository.HallRepository;
//import com.assignment2.cinema.repository.SeanceRepository;
//import com.assignment2.cinema.service.SeancesService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.UUID;
//
//@Service
//public final class SeancesServiceImpl implements SeancesService {
//
//    @Autowired
//    private SeanceRepository seancesRepository;
//    @Autowired
//    private TicketsServiceImpl ticketsService;
//    @Autowired
//    private FilmRepository filmRepository;
//    @Autowired
//    private HallRepository hallRepository;
//
//    private double cash;
//
//    @Override
//    public Ticket sellTicket(Visitor visitor, Seance seance, int line, int place) {
//        boolean rightAge;
//
//        if (seance.getFilm().getRating() != null)
//            rightAge = visitor.getAge() >= seance.getFilm().getRating().getAge();
//        else rightAge = true;
//
//        boolean enoughMoney = visitor.getMoney() >= seance.getPrice();
//
//        if (!rightAge || !enoughMoney) return null;
//
//        cash += seance.getPrice();
//        visitor.setMoney(visitor.getMoney() - seance.getPrice());
//        Ticket ticket = ticketsService.setVisitorToTicket(visitor, seance, line, place);
//
//        return ticket;
//    }
//
//    @Override
//    public double getCash() {
//        return cash;
//    }
//
//    @Override
//    public Seance addSeance(SeanceDto seanceDto) {
//        Film film = filmRepository.findById(seanceDto.getFilmID()).get();
//        Hall hall = hallRepository.findById(seanceDto.getHallID()).get();
//        Seance seance = new Seance(seanceDto.getSeanceDate(),
//                seanceDto.getPrice(), film, hall);
//        Seance savedSeance = seancesRepository.save(seance);
//        createTickets(seance);
//        return savedSeance;
//    }
//
//    public void createTickets(Seance seance) {
//        Hall hall = seance.getHall();
//        int lines = hall.getLinesNum();
//        int seats = hall.getSeatsNum();
//        for (int i = 0; i < lines; i++) {
//            for (int j = 0; j < seats; j++) {
//                Ticket ticket = new Ticket(seance, i + 1, j + 1);
//                ticketsService.addTicket(ticket);
//            }
//        }
//    }
//
//    @Override
//    public List<Seance> getAllSeances() {
//        return seancesRepository.findAll();
//    }
//
//    @Override
//    public Seance getSeanceById(UUID id) {
//        return seancesRepository.findById(id).get();
//    }
//
//    @Override
//    public void deleteSeanceById(UUID id) {
//        ticketsService.deleteAllBySeance(seancesRepository.findById(id).get());
//        seancesRepository.deleteById(id);
//    }
//
//    @Override
//    public void deleteAllSeancesByFilm(Film film) {
//        seancesRepository.deleteAllByFilm(film);
//    }
//
//}
