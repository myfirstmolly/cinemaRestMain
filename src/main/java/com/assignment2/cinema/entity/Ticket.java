package com.assignment2.cinema.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.UUID;

@EnableAutoConfiguration
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public final class Ticket {

    @Id
    private final UUID ticketId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "seance_id")
    private final Seance seance;

    private final int line;
    private final int seat;

    @OneToOne
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;

    public Ticket(Seance seance, int line, int seat) {
        ticketId = UUID.randomUUID();
        this.seance = seance;
        this.line = line;
        this.seat = seat;
    }

    public Ticket setVisitor(Visitor visitor) {
        this.visitor = visitor;
        return this;
    }

}
