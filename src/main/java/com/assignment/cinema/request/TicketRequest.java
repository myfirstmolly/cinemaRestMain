package com.assignment.cinema.request;

import com.assignment.cinema.entity.Visitor;
import lombok.Data;

@Data
public class TicketRequest {
    Visitor visitor;
    int line;
    int place;

    public TicketRequest(Visitor visitor, int line, int place) {
        this.visitor = visitor;
        this.line = line;
        this.place = place;
    }
}
