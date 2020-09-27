package com.assignment2.cinema.service.impl;

import com.assignment2.cinema.entity.Film;
import com.assignment2.cinema.repository.FilmRepository;
import com.assignment2.cinema.service.InterfaceFilmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FilmsService implements InterfaceFilmsService {

    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private SeancesVisitorService seancesService;

    @Override
    public Film addFilm(Film film) {
        Film savedFilm = filmRepository.save(film);
        return savedFilm;
    }

    @Override
    public List<Film> getAll() {
        return filmRepository.findAll();
    }

    @Override
    public Film getById(UUID id) {
        return filmRepository.getOne(id);
    }

    @Override
    public Film getByName(String name) {
        return filmRepository.findByName(name);
    }

    @Override
    public void deleteById(UUID id) {
        seancesService.deleteAllSeancesByFilm(filmRepository.findById(id).get());
        filmRepository.deleteById(id);
    }

}
