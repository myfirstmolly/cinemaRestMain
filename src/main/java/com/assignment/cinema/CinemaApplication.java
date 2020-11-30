package com.assignment.cinema;

import com.assignment.cinema.client.GrpcTest;
import com.cinema.film.FilmServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CinemaApplication {

    private final static String url = "localhost";
    private static final ManagedChannel channel = ManagedChannelBuilder.forAddress(url, 7081).usePlaintext().build();
    private static final FilmServiceGrpc.FilmServiceBlockingStub stub = FilmServiceGrpc.newBlockingStub(channel);


    public static void main(String[] args) {
        GrpcTest grpcTest = new GrpcTest();
        grpcTest.test();
    }
}
