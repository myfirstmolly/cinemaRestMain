package com.assignment.cinema.repository;

import com.assignment.cinema.entity.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HallRepository extends JpaRepository<Hall, UUID> {
    Hall findByName(String name);

    Hall findByHallId(UUID id);
}
