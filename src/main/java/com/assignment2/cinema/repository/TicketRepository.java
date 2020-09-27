package com.assignment2.cinema.repository;

import com.assignment2.cinema.entity.Seance;
import com.assignment2.cinema.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, UUID> {
    void deleteAllBySeance(Seance seance);
}
