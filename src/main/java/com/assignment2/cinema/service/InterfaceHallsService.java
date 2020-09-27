package com.assignment2.cinema.service;

import com.assignment2.cinema.entity.Hall;

import java.util.List;
import java.util.UUID;

public interface InterfaceHallsService {
    Hall addHall(Hall hall);
    List<Hall> getAll();
    Hall getById(UUID id);
    Hall getByName(String name);
    void deleteHallById(UUID id);
}
