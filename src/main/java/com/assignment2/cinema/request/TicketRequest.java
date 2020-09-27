package com.assignment2.cinema.request;

import lombok.Data;

import java.util.UUID;

@Data
public class TicketRequest {
    UUID visitorId;
    UUID seanceId;
    int line;
    int place;
}
