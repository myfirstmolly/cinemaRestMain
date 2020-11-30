package com.assignment.cinema.service.impl;

import com.assignment.cinema.entity.Hall;
import com.assignment.cinema.repository.HallRepository;
import com.assignment.cinema.service.HallsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public final class HallsServiceImpl implements HallsService {

    @Autowired
    private HallRepository hallRepository;

    @Override
    public Hall addHall(Hall hall) {
        Hall savedHall = hallRepository.save(hall);
        return savedHall;
    }

    @Override
    public List<Hall> getAll() {
        return hallRepository.findAll();
    }

    @Override
    public Hall getById(UUID id) {
        Hall hall = hallRepository.findById(id).get();
        return hall;
    }

    @Override
    public Hall getByName(String name) {
        return hallRepository.findByName(name);
    }

    @Override
    public void deleteHallById(UUID id) {
        hallRepository.deleteById(id);
    }
}
