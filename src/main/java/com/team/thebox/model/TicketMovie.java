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
/*    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movlistno;*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String schno;
    private String stime;
    private String movtitle;
    private String movgrade;
    private String movmainposter;
    private String movdetail;

    /*@OneToOne(optional = false)
    @JoinColumn(name = "movno", insertable = false, updatable = false)
    private Movie movie;

    @OneToOne(optional = false)
    @JoinColumn(name = "movno", insertable = false, updatable = false)
    private MovieSchedule movieSchedule;*/



}
