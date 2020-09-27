package com.assignment2.cinema.controller;

import com.assignment2.cinema.entity.*;
import com.assignment2.cinema.service.InterfaceWorkerService;
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
    private InterfaceWorkerService ownerService;

    @PostMapping("add-owner")
    public Worker addOwner(@RequestBody Worker worker) {
        return ownerService.addOwner(worker);
    }

    @PostMapping("add-worker")
    public Worker addWorker(@RequestBody Worker worker) {
        return ownerService.addWorker(worker);
    }

    @GetMapping("workers/all")
    public List<Worker> getAll() {
        return ownerService.getWorkers();
    }

    @GetMapping("workers/{position}")
    public List<Worker> getAllByPosition(@PathVariable(value = "position")
                                                     Position position) {
        return ownerService.getWorkersByPosition(position);
    }

    @DeleteMapping("workers/{workerId}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "workerId") UUID id) {
        ownerService.deleteWorkerById(id);
        return ResponseEntity.noContent().build();
    }

}
