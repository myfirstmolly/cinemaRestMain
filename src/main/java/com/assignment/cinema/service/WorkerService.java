package com.assignment.cinema.service;

import com.assignment.cinema.entity.Position;
import com.assignment.cinema.entity.Worker;

import java.util.List;
import java.util.UUID;

public interface WorkerService {
    Worker addWorker(Worker worker);

    List<Worker> getWorkers();

    List<Worker> getWorkersByPosition(Position position);

    void deleteWorkerById(UUID id);
}
