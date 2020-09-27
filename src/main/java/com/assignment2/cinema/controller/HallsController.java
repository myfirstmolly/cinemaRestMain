package com.assignment2.cinema.controller;

import com.assignment2.cinema.entity.Hall;
import com.assignment2.cinema.service.InterfaceHallsService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cinema")
@AllArgsConstructor
@NoArgsConstructor
public class HallsController {

    @Autowired
    private InterfaceHallsService cinemaService;

    @PostMapping(path = "add-hall")
    public Hall createHall(@JsonProperty("name") String name,
                           @JsonProperty("lines") Integer lines,
                           @JsonProperty("seats") Integer seats) {
        Hall toBeAdded = new Hall(name, lines, seats);
        cinemaService.addHall(toBeAdded);
        return toBeAdded;
    }

    @GetMapping
    public List<Hall> getAllHalls() {
        return cinemaService.getAll();
    }

    @GetMapping(path = "{hallId}")
    public Hall getHallById(@PathVariable(value = "hallId") UUID id) {
        Hall hall = cinemaService.getById(id);
        return hall;
    }

    @DeleteMapping(path = "{hallId}")
    public ResponseEntity<Void> deleteHall(@PathVariable(value = "hallId") UUID id)  {
        cinemaService.deleteHallById(id);
        return ResponseEntity.noContent().build();
    }

}
