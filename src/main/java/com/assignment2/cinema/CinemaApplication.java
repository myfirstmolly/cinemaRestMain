package com.assignment2.cinema;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CinemaApplication {

    static final Logger log = LoggerFactory.getLogger(CinemaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CinemaApplication.class, args);
    }

}
