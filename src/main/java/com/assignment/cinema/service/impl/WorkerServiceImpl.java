package com.assignment.cinema.service.impl;

import com.assignment.cinema.entity.Position;
import com.assignment.cinema.entity.Worker;
import com.assignment.cinema.repository.WorkerRepository;
import com.assignment.cinema.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public final class WorkerServiceImpl implements WorkerService {

    @Autowired
    WorkerRepository workerRepository;

    @Override
    public Worker addWorker(Worker worker) {
        return workerRepository.save(worker);
    }

    @Override
    public List<Worker> getWorkers() {
        return workerRepository.getAllByPosition(Position.MANAGER);
    }

    @Override
    public List<Worker> getWorkersByPosition(Position position) {
        return workerRepository.getAllByPosition(position);
    }

    @Override
    public void deleteWorkerById(UUID id) {
        workerRepository.deleteById(id);
    }

}
