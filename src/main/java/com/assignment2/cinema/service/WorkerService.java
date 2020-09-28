package com.assignment2.cinema.service;

import com.assignment2.cinema.entity.Position;
import com.assignment2.cinema.entity.Worker;

import java.util.List;
import java.util.UUID;

public interface WorkerService {
    Worker addOwner(Worker owner);

    Worker addWorker(Worker worker);

    List<Worker> getWorkers();

    List<Worker> getWorkersByPosition(Position position);

    void deleteWorkerById(UUID id);

}
