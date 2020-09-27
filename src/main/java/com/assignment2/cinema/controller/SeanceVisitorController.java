package com.assignment2.cinema.controller;

import com.assignment2.cinema.entity.Seance;
import com.assignment2.cinema.entity.Ticket;
import com.assignment2.cinema.entity.Visitor;
import com.assignment2.cinema.request.TicketRequest;
import com.assignment2.cinema.service.InterfaceSeancesVisitorService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/service")
@AllArgsConstructor
@NoArgsConstructor
public class SeanceVisitorController {

    @Autowired
    private InterfaceSeancesVisitorService seancesVisitorService;

    @PostMapping("visitor")
    public Visitor addVisitor(@RequestBody Visitor visitor) {
        return seancesVisitorService.addVisitor(visitor);
    }

    @GetMapping("visitor")
    public List<Visitor> getAllVisitors() {
        return seancesVisitorService.getAllVisitors();
    }

    @GetMapping("visitor/{id}")
    public Visitor getVisitorById(@PathVariable(name = "id") UUID id) {
        return seancesVisitorService.getVisitorById(id);
    }

    @DeleteMapping("visitor/{id}")
    public void deleteById(@PathVariable(name = "id") UUID id) {
        seancesVisitorService.deleteVisitorById(id);
    }

    @PostMapping("seances")
    public Seance addSeance(@RequestBody Seance seance) {
        return seancesVisitorService.addSeance(seance);
    }

    @GetMapping("/buy")
    public Ticket buyTicket(@RequestBody(required = false) TicketRequest ticketRequest) {
        return seancesVisitorService.sellTicket(ticketRequest.getVisitor(),
                ticketRequest.getSeance(), ticketRequest.getLine(),
                ticketRequest.getPlace());
    }

    @GetMapping("seances")
    public List<Seance> getAll() {
        return seancesVisitorService.getAllSeances();
    }

    @GetMapping("seances/{seanceId}")
    public Seance getById(@PathVariable(value = "seanceId") UUID id) {
        return seancesVisitorService.getSeanceById(id);
    }

    @DeleteMapping("seances/{seanceId}")
    public ResponseEntity<Void> deleteSeance(@PathVariable(value = "seanceId") UUID id) {
        seancesVisitorService.deleteVisitorById(id);
        return ResponseEntity.noContent().build();
    }

}
