package com.assignment2.cinema.controller;

import com.assignment2.cinema.entity.Visitor;
import com.assignment2.cinema.service.VisitorService;
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
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    @PostMapping
    public Visitor addVisitor(@RequestBody Visitor visitor) {
        return visitorService.addVisitor(visitor);
    }

    @GetMapping
    public List<Visitor> getAllVisitors() {
        return visitorService.getAllVisitors();
    }

    @GetMapping("{id}")
    public Visitor getVisitorById(@PathVariable(name = "id") UUID id) {
        return visitorService.getVisitorById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable(name = "id") UUID id) {
        visitorService.deleteVisitorById(id);
    }

}
