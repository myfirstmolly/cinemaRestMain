package com.assignment2.cinema.repository;

import com.assignment2.cinema.entity.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectionRepository extends JpaRepository<Seance, UUID> {
    Seance getBySeanceId(UUID seanceId);
}
