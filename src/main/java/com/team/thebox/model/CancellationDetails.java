package com.team.thebox.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cancellationdetails")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CancellationDetails {

    private String userid;
    private LocalDateTime cancellationdate;
    private String title;
    private String region;
    private LocalDateTime viewingday;
    private int totalprice;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long canno;
}
