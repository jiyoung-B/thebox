package com.team.thebox.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Builder
@ToString(exclude = "movieStillcut")
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

    @Column
    private  Double tsales;              //에매율

    private String uuid;

    @Column
    private String movdetail;           // 줄거리

    private String movmainposter;    // 영화 포스터

    private String videourl;    // 예고편

    private Integer moviestillcut_id;

    @OneToOne(optional = false)
    @JoinColumn(name="moviestillcut_id", insertable = false, updatable = false)
    @JsonIgnore
    private MovieStillcut movieStillcut;


}
