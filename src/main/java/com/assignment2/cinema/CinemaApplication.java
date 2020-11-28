package com.assignment2.cinema;

import com.assignment2.cinema.client.GrpcTest;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CinemaApplication {

    public static void main(String[] args) {
        GrpcTest grpcTest = new GrpcTest();
        grpcTest.test();
    }
}
