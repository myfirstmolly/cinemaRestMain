package com.assignment2.cinema.controller;

import com.assignment2.cinema.entity.Film;
import com.assignment2.cinema.entity.Hall;
import com.assignment2.cinema.entity.Seance;
import com.assignment2.cinema.service.InterfaceSeancesService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/seances")
@AllArgsConstructor
@NoArgsConstructor
public class SeanceController {

    @Autowired
    private InterfaceSeancesService seancesService;

    @PostMapping
    public Seance addSeance(@RequestBody Seance seance) {
        return seancesService.addSeance(seance);
    }

    @GetMapping
    public List<Seance> getAll() {
        return seancesService.getAll();
    }

    @GetMapping("{seanceId}")
    public Seance getById(@PathVariable(value = "seanceId") UUID id) {
        return seancesService.getById(id);
    }

    @DeleteMapping("{seanceId}")
    public ResponseEntity<Void> deleteSeance(@PathVariable(value = "seanceId")UUID id) {
        seancesService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
