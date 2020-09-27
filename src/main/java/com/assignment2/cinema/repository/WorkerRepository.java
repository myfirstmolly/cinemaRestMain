package com.assignment2.cinema.repository;

import com.assignment2.cinema.entity.Position;
import com.assignment2.cinema.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface WorkerRepository extends JpaRepository<Worker, UUID> {
    List<Worker> getAllByPosition(Position position);
}
