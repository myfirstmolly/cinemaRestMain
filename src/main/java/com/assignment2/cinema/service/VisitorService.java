package com.assignment2.cinema.service;

import com.assignment2.cinema.entity.Visitor;

import java.util.List;
import java.util.UUID;

public interface VisitorService {

    Visitor addVisitor(Visitor visitor);

    List<Visitor> getAllVisitors();

    Visitor getVisitorById(UUID id);

    void updateVisitorBalance(UUID visitorId, double newBalance);

    void deleteVisitorById(UUID id);

}
