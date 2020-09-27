package com.assignment2.cinema.controller;

import com.assignment2.cinema.entity.Ticket;
import com.assignment2.cinema.entity.Visitor;
import com.assignment2.cinema.request.TicketRequest;
import com.assignment2.cinema.service.InterfaceVisitorService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/visitor")
@AllArgsConstructor
@NoArgsConstructor
public class VisitorTransactionController {

    @Autowired
    private InterfaceVisitorService visitorService;

    @PostMapping
    public Visitor addVisitor(@RequestBody Visitor visitor) {
        return visitorService.addVisitor(visitor);
    }

    @GetMapping("/buy")
    public Ticket buyTicket(@RequestBody TicketRequest ticketRequest) {
        return visitorService.buyTicket(ticketRequest.getVisitorId(),
                ticketRequest.getSeanceId(), ticketRequest.getLine(),
                ticketRequest.getPlace());
    }

    @GetMapping
    public List<Visitor> getAll() {
        return visitorService.getAll();
    }

    @GetMapping("{id}")
    public Visitor getById(@PathVariable(name = "id") UUID id) {
        return visitorService.getById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable(name = "id") UUID id) {
        visitorService.deleteById(id);
    }

}
