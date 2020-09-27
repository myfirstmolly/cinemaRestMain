package com.assignment2.cinema.repository;

import com.assignment2.cinema.entity.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CinemaRepository extends JpaRepository<Hall, UUID> {
    Hall findByHallId(UUID id);
    Hall findByName(String name);
}
