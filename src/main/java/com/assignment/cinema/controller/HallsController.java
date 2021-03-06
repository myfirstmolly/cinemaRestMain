package com.assignment.cinema.controller;

import com.assignment.cinema.entity.Hall;
import com.assignment.cinema.service.HallsService;
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
    private HallsService hallsService;

    @PostMapping
    public Hall createHall(@RequestBody Hall hall) {
        return hallsService.addHall(hall);
    }

    @GetMapping
    public List<Hall> getAllHalls() {
        return hallsService.getAll();
    }

    @GetMapping(path = "{hallId}")
    public Hall getHallById(@PathVariable(value = "hallId") UUID id) {
        Hall hall = hallsService.getById(id);
        return hall;
    }

    @DeleteMapping(path = "{hallId}")
    public ResponseEntity<Void> deleteHall(@PathVariable(value = "hallId") UUID id)  {
        hallsService.deleteHallById(id);
        return ResponseEntity.noContent().build();
    }

}
