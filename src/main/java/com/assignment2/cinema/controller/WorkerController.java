package com.assignment2.cinema.controller;

import com.assignment2.cinema.entity.Position;
import com.assignment2.cinema.entity.Worker;
import com.assignment2.cinema.service.WorkerService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/worker")
@AllArgsConstructor
@NoArgsConstructor
public class WorkerController {

    @Autowired
    private WorkerService ownerService;

    @PostMapping
    public Worker addWorker(@RequestBody Worker worker) {
        return ownerService.addWorker(worker);
    }

    @GetMapping
    public List<Worker> getAll() {
        return ownerService.getWorkers();
    }

    @GetMapping("{position}")
    public List<Worker> getAllByPosition(@PathVariable(value = "position")
                                                     Position position) {
        return ownerService.getWorkersByPosition(position);
    }

    @DeleteMapping("{workerId}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "workerId") UUID id) {
        ownerService.deleteWorkerById(id);
        return ResponseEntity.noContent().build();
    }

}
