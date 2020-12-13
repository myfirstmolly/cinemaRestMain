package com.assignment.cinema;

import com.assignment.cinema.client.RabbitTest;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CinemaApplication {

    public static void main(String[] args) {
        RabbitTest rabbitTest = new RabbitTest();
        rabbitTest.testClient();
    }
}
