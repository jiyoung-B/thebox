//package com.team.thebox.model;
//
//import lombok.*;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "movieselect")
//@Getter
//@Setter
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
//public class MovieSelect {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long movno;
//
//    @Column
//    private String movtitle;		// 제목
//
//    @Column
//    private LocalDate movreleasedate;	// 개봉일
//
//    @Column
//    private String movgrade;		// 등급
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "movie_id")
//    private List<MoviePoster> movPosters = new ArrayList<>();    // 포스터 이미지 URL
//}
