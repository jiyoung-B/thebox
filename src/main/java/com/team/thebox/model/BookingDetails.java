package com.team.thebox.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookingdetails")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bkno;

    private String bookingnum;
    private String userid;
    private String title;
    private String cinematype;
    private String region;
    private String screennum;
    private String seats;
    private LocalDateTime viewingday;
    private int adult;
    private int teen;
    private int totalprice;

    @CreatedDate
    @Column(insertable = false, updatable = false)
    private LocalDateTime paymentdate;

    private String poster;
}
