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

    private String userid;
    private String title;
    private String cinematype;
    private String region;
    private int adult;
    private int teen;
    private String seats;
    private String viewingday;
    private int totalprice;

    private String paymentdate;

    private String poster;
}
