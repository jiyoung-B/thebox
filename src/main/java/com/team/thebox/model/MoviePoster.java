//package com.team.thebox.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import javax.persistence.*;
//
//@Entity
//@Table(name = "movieposter")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class MoviePoster {
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column
//    private String url;
//
//    @ManyToOne(optional = true)
//    @JoinColumn(name = "movie_id")
//    private Movie movie;
//}
