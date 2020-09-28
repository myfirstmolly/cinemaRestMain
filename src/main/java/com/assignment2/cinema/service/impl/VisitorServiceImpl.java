package com.assignment2.cinema.service.impl;

import com.assignment2.cinema.entity.Visitor;
import com.assignment2.cinema.repository.VisitorRepository;
import com.assignment2.cinema.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public final class VisitorServiceImpl implements VisitorService {

    @Autowired
    VisitorRepository visitorRepository;

    @Override
    public Visitor addVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    @Override
    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }

    @Override
    public Visitor getVisitorById(UUID id) {
        return visitorRepository.findById(id).get();
    }

    @Override
    public void updateVisitorBalance(UUID visitorId, double newBalance) {
        visitorRepository.findById(visitorId).get().setMoney(newBalance);
    }

    @Override
    public void deleteVisitorById(UUID id) {
        visitorRepository.deleteById(id);
    }

}
