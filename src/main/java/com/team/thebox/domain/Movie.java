package com.team.thebox.domain;


import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Entity
@Table(name="movie")
public class Movie extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movno;

    @Column
    private String movgenre;		// 장르
    @Column
    private String movtitle;		// 제목
    @Column
    private String movdirector;		// 감독명
    @Column
    private String movactor;		// 배우명
    @Column
    private LocalDate movreleasedate;	// 개봉일
    @Column
    private String movcountry;		// 국가
    @Column
    private String movgrade;		// 등급
    @Column
    private int movruntime;			// 런타임(분)
    @Lob
    @Column
    private String movdetail;		// 줄거리

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    private List<MoviePoster> movPosters = new ArrayList<>();    // 포스터 이미지 URL


    @Column
    private String movvideo;           // 예고편 동영상 URL


}
