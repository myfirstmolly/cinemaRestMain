package com.assignment2.cinema.repository;

import com.assignment2.cinema.entity.Seance;
import com.assignment2.cinema.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TicketsRepository extends JpaRepository<Ticket, UUID> {
    Ticket getBySeanceAndLineAndSeat(Seance seance, int line, int seat);

}
