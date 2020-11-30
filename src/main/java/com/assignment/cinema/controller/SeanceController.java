package com.assignment.cinema.controller;

import com.assignment.cinema.controller.dto.SeanceDto;
import com.assignment.cinema.entity.Seance;
import com.assignment.cinema.entity.Ticket;
import com.assignment.cinema.request.TicketRequest;
import com.assignment.cinema.service.SeancesService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/seance")
@AllArgsConstructor
@NoArgsConstructor
public class SeanceController {

    @Autowired
    private SeancesService seancesService;

    @PostMapping
    public Seance addSeance(@RequestBody SeanceDto seance) {
        return seancesService.addSeance(seance);
    }

    @PostMapping("{seanceId}/visitor")
    public Ticket buyTicket(@PathVariable(value = "seanceId") UUID id,
                            @RequestBody(required = false) TicketRequest ticketRequest) {
        return seancesService.sellTicket(ticketRequest.getVisitor(),
                seancesService.getSeanceById(id), ticketRequest.getLine(),
                ticketRequest.getPlace());
    }

    @GetMapping
    public List<Seance> getAll() {
        return seancesService.getAllSeances();
    }

    @GetMapping("{seanceId}")
    public Seance getById(@PathVariable(value = "seanceId") UUID id) {
        return seancesService.getSeanceById(id);
    }

    @DeleteMapping("{seanceId}")
    public ResponseEntity<Void> deleteSeance(@PathVariable(value = "seanceId") UUID id) {
        seancesService.deleteSeanceById(id);
        return ResponseEntity.noContent().build();
    }

}
