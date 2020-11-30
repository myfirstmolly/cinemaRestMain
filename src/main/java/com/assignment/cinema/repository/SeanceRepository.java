package com.assignment.cinema.repository;

import com.assignment.cinema.entity.Film;
import com.assignment.cinema.entity.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SeanceRepository extends JpaRepository<Seance, UUID> {
    void deleteAllByFilm(Film film);
}
