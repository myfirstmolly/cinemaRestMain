package com.assignment.cinema.repository;

import com.assignment.cinema.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FilmRepository extends JpaRepository<Film, UUID> {
    Film findByName(String name);
}
