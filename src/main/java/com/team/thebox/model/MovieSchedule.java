package com.team.thebox.model;


import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Entity
@Table(name="movieschedule")
public class MovieSchedule extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schno;

    @Column
    private Long movno;

    @Column
    private String ciplace;

    @Column
    private String odate;


    @Column
    private String stime;

    @Column
    private String etime;

    private int price;

}