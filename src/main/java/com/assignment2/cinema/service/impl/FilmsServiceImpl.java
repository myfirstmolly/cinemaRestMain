package com.assignment2.cinema.service.impl;

import com.assignment2.cinema.entity.Film;
import com.assignment2.cinema.repository.FilmRepository;
import com.assignment2.cinema.repository.SeanceRepository;
import com.assignment2.cinema.service.FilmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public final class FilmsServiceImpl implements FilmsService {

    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private SeanceRepository seancesRepository;

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
        seancesRepository.deleteAllByFilm(filmRepository.findById(id).get());
        filmRepository.deleteById(id);
    }

}
