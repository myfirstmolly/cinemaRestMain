package com.assignment2.cinema.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public final class Visitor {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID userId;

    private String name;
    private double money;
    private int age;

    @JsonIgnore
    @OneToOne(mappedBy = "visitor", cascade = CascadeType.ALL)
    Ticket ticket;

    public Visitor(String name, double money, int age) {
        this.name = name;
        this.money = money;
        this.age = age;
        this.ticket = null;
    }
}
