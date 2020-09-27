package com.assignment2.cinema.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Data
@NoArgsConstructor
public final class Hall {

    @Id
    private UUID hallId;

    @Column(unique = true)
    private String name;

    private int linesNum;
    private int seatsNum;

    @JsonIgnore
    @OneToMany(mappedBy = "hall", fetch = FetchType.LAZY)
    private List<Seance> seances;

    public Hall(String name, int linesNum, int seatsNum) {
        hallId = UUID.randomUUID();
        this.name = name;
        this.linesNum = linesNum;
        this.seatsNum = seatsNum;
        this.seances = new ArrayList<>();
    }

}
