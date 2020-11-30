package com.assignment.cinema.service;

import com.assignment.cinema.entity.Film;

import java.util.List;
import java.util.UUID;

public interface FilmsService {
    Film addFilm(Film film);

    List<Film> getAll();

    Film getById(UUID id);

    Film getByName(String name);

    void deleteById(UUID id);
}
