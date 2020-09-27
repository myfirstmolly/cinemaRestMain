package com.assignment2.cinema.controller;

import com.assignment2.cinema.entity.Film;
import com.assignment2.cinema.service.InterfaceFilmsService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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
    InterfaceFilmsService filmsService;

    @PostMapping("films")
    public Film createFilm(@RequestBody Film film) {
        Film savedFilm = filmsService.addFilm(film);
        return savedFilm;
    }

    @DeleteMapping("films/{filmId}")
    public ResponseEntity<Void> deleteFilm(@PathVariable(value = "filmId") UUID id) {
        filmsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
