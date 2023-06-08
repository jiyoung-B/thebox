package com.team.thebox.model;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "movielocation")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Movielocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long LOCATIONNUM;

    private String DISTRICTNAME;

    private String PLACENAME;



}
