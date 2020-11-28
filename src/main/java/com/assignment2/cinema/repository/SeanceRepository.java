package com.assignment2.cinema.repository;

import com.assignment2.cinema.entity.Film;
import com.assignment2.cinema.entity.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SeanceRepository extends JpaRepository<Seance, UUID> {
    void deleteAllByFilm(Film film);
}
