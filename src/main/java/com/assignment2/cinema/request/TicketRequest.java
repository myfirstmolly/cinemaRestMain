package com.assignment2.cinema.request;

import com.assignment2.cinema.entity.Visitor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TicketRequest {
    Visitor visitor;
    int line;
    int place;
}
