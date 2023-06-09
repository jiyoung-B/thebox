package com.team.thebox.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "TicketMovie")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TicketMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movlistno;

    @Column
    private String movdate;

    @Column
    private String district;

    @Column
    private String movtitle;

    @Column
    private String movgrade;

    @Column
    private String stime;

    @Column
    private String movmainposter;

    private Integer movno;

    @OneToOne(optional = false)
    @JoinColumn(name = "movno", insertable = false, updatable = false)
    private Movie movie;

    @OneToOne(optional = false)
    @JoinColumn(name = "movno", insertable = false, updatable = false)
    private MovieSchedule movieSchedule;



}
