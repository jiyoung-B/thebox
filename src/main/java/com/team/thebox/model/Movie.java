package com.team.thebox.model;


import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Builder
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
    private String movgenre;            // 장르
    @Column(nullable = false)
    private String movtitle;            // 제목
    @Column
    private String movdirector;         // 감독명
    @Column
    private String movactor;            // 배우명
    @Column
    private String movreleasedate;      // 개봉일
    @Column
    private String movcountry;          // 국가
    @Column
    private String movgrade;            // 등급
    @Column
    private String movruntime;          // 런타임(분)

    private String uuid;
    @Lob
    @Column
    private String movdetail;           // 줄거리

    //@OneToOne(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private String movmainposter;    // 영화 포스터

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MovieStillcut> stillcuts = new ArrayList<>(); // 스틸컷


//    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private String videourl;/* = new ArrayList<>(); */// 예고편



    public void setStillcuts(List<MovieStillcut> stillcuts) {
        this.stillcuts.clear();
        if (stillcuts != null) {
            this.stillcuts.addAll(stillcuts);
            for (MovieStillcut stillcut : stillcuts) {
                stillcut.setMovie(this);
            }
        }
    }

//    public void setVideos(List<MovieVideo> videos) {
//        this.videourl.clear();
//        if (videos != null) {
//            this.videourl.addAll(videos);
//            for (MovieVideo video : videos) {
//                video.setMovie(this);
//            }
//        }
//    }

}
