package com.team.thebox.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "box_office230612")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Stats {

    @Id
    private int rank;
    private String title;
    private long sales;
    private double salesshare;
    private long cumulativesales;
    private long boxoffice;
    private long cumulativeboxoffice;
}
