package com.assignment.cinema.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

@EnableAutoConfiguration
@Data
@Entity
@AllArgsConstructor
public final class Visitor {

    @Id
    private final UUID userId;

    private final String name;
    private double money;
    private final int age;

    @JsonIgnore
    @OneToOne(mappedBy = "visitor", cascade = CascadeType.ALL)
    Ticket ticket;

    public Visitor(String name, double money, int age) {
        userId = UUID.randomUUID();
        this.name = name;
        this.money = money;
        this.age = age;
        this.ticket = null;
    }


}
