package com.assignment2.cinema;

import com.assignment2.cinema.entity.*;
import com.assignment2.cinema.request.TicketRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class CinemaApplication {

    private static final String URL = "http://localhost:8081";
    private static final HttpHeaders headers = new HttpHeaders();
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final HttpEntity<Object> headersEntity = new HttpEntity<>(headers);

    public static void main(String[] args) {

        headers.setContentType(MediaType.APPLICATION_JSON);

        //add halls
        Hall small = new Hall("Small Hall", 5, 5);
        Hall medium = new Hall("Medium Hall", 6, 15);
        Hall big = new Hall("Big Hall", 10, 20);

        addEntity("/cinema", small);
        addEntity("/cinema", medium);
        addEntity("/cinema", big);

        //add workers
        Worker owner = new Worker("Rita", "Yusupova",
                800, Position.OWNER);
        Worker ticketSeller = new Worker("Victoria", "Kostenko",
                200, Position.TICKETSELLER);
        Worker manager = new Worker("Andrew", "Petrov",
                300, Position.MANAGER);

        addEntity("/worker", owner);
        addEntity("/worker", ticketSeller);
        addEntity("/worker", manager);

        //add film
        Film trainspotting = new Film("Trainspotting", "Danny Boyle",
                1996, "Dark comedy", Rating.NC17);
        Film strangersFromHell = new Film("Strangers from Hell", "Lee Chang-Hee",
                2019, "Psychology thriller", Rating.NC17);
        Film seven = new Film("Se7en", "David Fincher",
                1995, "Crime thriller", Rating.R);
        Film midsommar = new Film("Midsommar", "Ari Aster",
                2019, "Horror", Rating.R);

        addEntity("/film", trainspotting);
        addEntity("/film", strangersFromHell);
        addEntity("/film", seven);
        addEntity("/film", midsommar);

        //add seances
        Seance trainspottingSeance = new Seance("2020.09.28T19:30", 300, trainspotting, big);
        Seance strangersFromHellSeance = new Seance("2020.09.28T21:00", 400, strangersFromHell, medium);
        Seance sevenSeance = new Seance("2020.09.28T13:00", 200, seven, small);
        Seance midsommarSeance = new Seance("2020.09.28T22:00", 350, midsommar, big);

        addEntity("/seance", trainspottingSeance);
        addEntity("/seance", strangersFromHellSeance);
        addEntity("/seance", sevenSeance);
        addEntity("/seance", midsommarSeance);

        //add visitors
        Visitor marie = new Visitor("Marie", 500, 18);
        Visitor mark = new Visitor("Mark", 4700, 46);
        Visitor dan = new Visitor("Dan", 400, 20);
        Visitor andrew = new Visitor("Andrew", 400, 32);
        Visitor sonya = new Visitor("Sonya", 800, 19);
        Visitor simon = new Visitor("Simon", 700, 47);

        addEntity("/visitor", marie);
        addEntity("/visitor", mark);
        addEntity("/visitor", dan);
        addEntity("/visitor", andrew);
        addEntity("/visitor", sonya);
        addEntity("/visitor", simon);

        //sell tickets
        sellTicket(marie, midsommarSeance, 10, 10);
        sellTicket(mark, trainspottingSeance, 10, 10);
        sellTicket(dan, strangersFromHellSeance, 6, 7);
        sellTicket(andrew, sevenSeance, 4, 2);
        sellTicket(sonya, strangersFromHellSeance, 5, 8);
        sellTicket(simon, trainspottingSeance, 10, 11);

    }

    private static void sellTicket(Visitor visitor, Seance seance, int line, int place) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String ticketRequest = objectMapper.writeValueAsString(new
                    TicketRequest(visitor, line, place));
            HttpEntity<String> httpRequest = new HttpEntity<>(ticketRequest, headers);
            ResponseEntity<String> response = restTemplate.postForEntity(URL +
                            "/seance/" + seance.getSeanceId() + "/visitor",
                    httpRequest, String.class);
            System.out.println(response);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private static void addEntity(String path, Object entity) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String entityJson = objectMapper.writeValueAsString(entity);
            HttpEntity<String> entityJsonHttp = new HttpEntity<>(entityJson, headers);
            ResponseEntity<Void> response = restTemplate.postForEntity(URL +
                    path, entityJsonHttp, Void.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
