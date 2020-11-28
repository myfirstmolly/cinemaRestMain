package com.assignment2.cinema.client;

import com.cinema.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcTest {
    private final String url = "localhost";
    private final ManagedChannel channel = ManagedChannelBuilder.forAddress(url, 7080).usePlaintext().build();
    CinemaServiceGrpc.CinemaServiceBlockingStub stub = CinemaServiceGrpc.newBlockingStub(channel);

    public void test() {
        FilmRequest trainspotting = addFilm("Trainspotting", "Danny Boyle",
                1996, Genre.NC17);
        FilmRequest strangers = addFilm("Strangers from Hell2", "Lee Chang-Hee",
                2019, Genre.NC17);
        FilmRequest seven = addFilm("Se7en", "David Fincher",
                1995, Genre.R);
        FilmRequest midsommar = addFilm("Midsommar", "Ari Aster",
                2019, Genre.R);

        HallRequest small = addHall("Small Hall", 5, 5);
        HallRequest medium = addHall("Medium Hall", 6, 15);
        HallRequest big = addHall("Big Hall", 10, 20);

        addSeance("2020.09.28T19:30", 300, trainspotting, big);
        addSeance("2020.09.28T21:00", 400, strangers, medium);
        addSeance("2020.09.28T13:00", 200, midsommar, big);
        addSeance("2020.09.28T19:30", 350, seven, small);

        addVisitor("Marie", 500, 18);
        addVisitor("Mark", 4700, 46);
        addVisitor("Dan", 400, 20);
        addVisitor("Andrew", 400, 32);
        addVisitor("Sonya", 800, 19);
        addVisitor("Simon", 700, 47);
    }

    private FilmRequest addFilm(String name, String director, int year, Genre genre) {
        FilmRequest film = FilmRequest.newBuilder().
                setName(name).
                setDirector(director).
                setYear(year).
                setGenre(genre).
                build();
        stub.addFilm(film);
        return film;
    }

    private void addSeance(String date, double price, FilmRequest film, HallRequest hall) {
        CinemaServiceGrpc.CinemaServiceBlockingStub stub = CinemaServiceGrpc.newBlockingStub(channel);
        SeanceRequest seance = SeanceRequest.newBuilder().
                setSeanceDate(date).
                setPrice(price).
                setFilm(film).
                setHall(hall).
                build();
        stub.addSeance(seance);
    }

    private HallRequest addHall(String name, int linesNum, int seatsNum) {
        HallRequest hall = HallRequest.newBuilder().
                setName(name).
                setLinesNum(linesNum).
                setSeatsNum(seatsNum).
                build();
        HallResponse response = stub.addHall(hall);
        return hall;
    }

    private void addVisitor(String name, double balance, int age) {
        VisitorRequest visitor = VisitorRequest.newBuilder().
                setName(name).
                setMoney(balance).
                setAge(age).
                build();
        stub.addVisitor(visitor);
    }

    private void addWorker(String name, String surname, int salary, Position position) {
        WorkerRequest worker = WorkerRequest.newBuilder().
                setName(name).
                setSurname(surname).
                setSalary(salary).
                setPosition(position).
                build();
        stub.addWorker(worker);
    }

}
