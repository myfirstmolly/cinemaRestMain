package com.assignment.cinema.client;

import com.cinema.film.*;
import com.cinema.hall.HallRequest;
import com.cinema.hall.HallServiceGrpc;
import com.cinema.seance.Film;
import com.cinema.seance.Hall;
import com.cinema.seance.SeanceRequest;
import com.cinema.seance.SeanceServiceGrpc;
import com.cinema.visitor.VisitorRequest;
import com.cinema.visitor.VisitorServiceGrpc;
import com.cinema.worker.Position;
import com.cinema.worker.WorkerRequest;
import com.cinema.worker.WorkerServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcTest {
    private final String url = "localhost";
    private final ManagedChannel channel = ManagedChannelBuilder.forAddress(url, 7080).usePlaintext().build();
    FilmServiceGrpc.FilmServiceBlockingStub filmStub = FilmServiceGrpc.newBlockingStub(channel);
    SeanceServiceGrpc.SeanceServiceBlockingStub seanceStub = SeanceServiceGrpc.newBlockingStub(channel);
    HallServiceGrpc.HallServiceBlockingStub hallStub = HallServiceGrpc.newBlockingStub(channel);
    VisitorServiceGrpc.VisitorServiceBlockingStub visitorStub = VisitorServiceGrpc.newBlockingStub(channel);
    WorkerServiceGrpc.WorkerServiceBlockingStub workerStub = WorkerServiceGrpc.newBlockingStub(channel);

    public void test() {
        Film trainspotting = addFilm("Trainspotting", "Danny Boyle",
                1996, Genre.NC17);
        Film strangers = addFilm("Strangers from Hell", "Lee Chang-Hee",
                2019, Genre.NC17);
        Film seven = addFilm("Se7en", "David Fincher",
                1995, Genre.R);
        Film midsommar = addFilm("Midsommar", "Ari Aster",
                2019, Genre.R);

        FilmResponse response = filmStub.byName(FilmByNameRequest.newBuilder().
                setName("Trainspotting").build());
        System.out.println(response.toString());

        Hall small = addHall("Small hall", 5, 5);
        Hall medium = addHall("Medium Hall", 6, 15);
        Hall big = addHall("Big Hall", 10, 20);

        addSeance("2020.09.28T19:30", 300, trainspotting, big);
        addSeance("2020.09.28T16:30", 200, strangers, medium);
        addSeance("2020.09.28T19:30", 400, seven, small);
        addSeance("2020.09.28T19:30", 350, midsommar, big);

        addVisitor("Marie", 500, 20);
        addVisitor("Mark", 4700, 46);
        addVisitor("Dan", 400, 20);
        addVisitor("Andrew", 400, 32);
        addVisitor("Sonya", 800, 19);
        addVisitor("Simon", 700, 47);

        addWorker("Rita", "Yusupova", 90000, Position.OWNER);
        addWorker("Victoria", "Kostenko", 200, Position.TICKETSELLER);
        addWorker("Anton", "Petrov", 300, Position.MANAGER);

    }

    private Film addFilm(String name, String director, int year, Genre genre) {
        FilmRequest film = FilmRequest.newBuilder().
                setName(name).
                setDirector(director).
                setYear(year).
                setGenre(genre).
                build();
        filmStub.add(film);
        return Film.newBuilder().
                setName(film.getName()).
                setDirector(film.getDirector()).
                setYear(film.getYear()).
                setGenre(com.cinema.seance.Genre.valueOf(film.getGenre().name())).
                build();
    }

    private void addSeance(String date, double price, Film film, Hall hall) {
        SeanceRequest seance = SeanceRequest.newBuilder().
                setSeanceDate(date).
                setPrice(price).
                setFilm(film).
                setHall(hall).
                build();
        seanceStub.add(seance);
    }

    private Hall addHall(String name, int linesNum, int seatsNum) {
        HallRequest hall = HallRequest.newBuilder().
                setName(name).
                setLinesNum(linesNum).
                setSeatsNum(seatsNum).
                build();
        hallStub.add(hall);
        return Hall.newBuilder().
                setName(hall.getName()).
                setSeatsNum(hall.getSeatsNum()).
                setLinesNum(hall.getLinesNum()).build();
    }

    private void addVisitor(String name, double balance, int age) {
        VisitorRequest visitor = VisitorRequest.newBuilder().
                setName(name).
                setMoney(balance).
                setAge(age).
                build();
        visitorStub.add(visitor);
    }

    private void addWorker(String name, String surname, int salary, Position position) {
        WorkerRequest worker = WorkerRequest.newBuilder().
                setName(name).
                setSurname(surname).
                setSalary(salary).
                setPosition(position).
                build();
        workerStub.add(worker);
    }

}
