package com.assignment2.cinema.controller;

import com.assignment2.cinema.entity.Film;
import com.assignment2.cinema.service.FilmsService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/film")
@AllArgsConstructor
@NoArgsConstructor
public class FilmController {

    @Autowired
    FilmsService filmsService;

    @PostMapping
    public Film createFilm(@RequestBody Film film) {
        return filmsService.addFilm(film);
    }

    @GetMapping
    public List<Film> getAll() {
        return filmsService.getAll();
    }

    @GetMapping("{filmId}")
    public Film getById(@PathVariable(value = "filmId") UUID id) {
        return filmsService.getById(id);
    }

    @DeleteMapping("{filmId}")
    public ResponseEntity<Void> deleteFilm(@PathVariable(value = "filmId") UUID id) {
        filmsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
