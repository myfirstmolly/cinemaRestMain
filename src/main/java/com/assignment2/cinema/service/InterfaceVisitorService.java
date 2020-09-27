package com.assignment2.cinema.service;

import com.assignment2.cinema.entity.Seance;
import com.assignment2.cinema.entity.Ticket;
import com.assignment2.cinema.entity.Visitor;

import java.util.List;
import java.util.UUID;

public interface InterfaceVisitorService {
    Ticket buyTicket(UUID visitorId, UUID seanceId, int line, int place);
    double getCash();
    Visitor addVisitor(Visitor visitor);
    List<Visitor> getAll();
    Visitor getById(UUID id);
    void updateBalance(UUID visitorId, double newBalance);
    void deleteById(UUID id);
}
