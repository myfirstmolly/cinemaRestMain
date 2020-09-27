package com.assignment2.cinema;

import com.assignment2.cinema.entity.*;
import com.assignment2.cinema.request.TicketRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;


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

        addEntity("/cinema/add-hall", small);
        addEntity("/cinema/add-hall", medium);
        addEntity("/cinema/add-hall", big);

        //add workers
        Worker owner = new Worker("Rita", "Yusupova",
                800, Position.OWNER);
        Worker ticketSeller = new Worker("Victoria", "Kostenko",
                200, Position.TICKETSELLER);
        Worker manager =  new Worker("Andrew", "Petrov",
                300, Position.MANAGER);

        addEntity("/worker/add-worker", owner);
        addEntity( "/worker/add-worker", ticketSeller);
        addEntity("/worker/add-worker", manager);

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

        addEntity("/service/seances", trainspottingSeance);
        addEntity("/service/seances", strangersFromHellSeance);
        addEntity("/service/seances", sevenSeance);
        addEntity("/service/seances", midsommarSeance);

        //add visitors
        Visitor marie = new Visitor("Marie", 500, 18);
        Visitor mark = new Visitor("Mark", 4700, 46);
        Visitor dan = new Visitor("Dan", 400, 20);
        Visitor andrew = new Visitor("Andrew", 400, 32);
        Visitor sonya = new Visitor("Sonya", 800, 19);
        Visitor simon = new Visitor("Simon", 700, 47);

        addEntity("/service/visitor", marie);
        addEntity("/service/visitor", dan);
        addEntity("/service/visitor", andrew);
        addEntity("/service/visitor", sonya);
        addEntity("/service/visitor", mark);
        addEntity("/service/visitor", simon);

        SpringApplication.run(CinemaApplication.class, args);

    }

    private static void addEntity(String path, Object entity) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String hallJson = objectMapper.writeValueAsString(entity);
            HttpEntity<String> hallJsonHttp = new HttpEntity<>(hallJson, headers);
            ResponseEntity<Void> response = restTemplate.postForEntity(URL +
                    path, hallJsonHttp, Void.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
