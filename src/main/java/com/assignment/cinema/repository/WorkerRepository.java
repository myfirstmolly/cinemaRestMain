package com.assignment.cinema.repository;

import com.assignment.cinema.entity.Position;
import com.assignment.cinema.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface WorkerRepository extends JpaRepository<Worker, UUID> {
    List<Worker> getAllByPosition(Position position);
}
