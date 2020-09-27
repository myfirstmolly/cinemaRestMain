package com.assignment2.cinema.controller;

import com.assignment2.cinema.entity.Ticket;
import com.assignment2.cinema.entity.Visitor;
import com.assignment2.cinema.service.InterfaceVisitorService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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
    public Visitor addVisitor(@JsonProperty("name") String name,
                              @JsonProperty("money") double money,
                              @JsonProperty("age") int age) {
        return visitorService.addVisitor(new Visitor(name, money, age));
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
