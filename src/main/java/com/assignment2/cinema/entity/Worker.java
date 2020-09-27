package com.assignment2.cinema.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.UUID;

@EnableAutoConfiguration
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public final class Worker {

    @Id
    private UUID workerId;

    private String name;
    private String surname;
    private int salary;

    @Enumerated(EnumType.STRING)
    private Position position;

    public Worker(String name, String surname, int salary, Position position) {
        workerId = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.position = position;
    }
}
