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
@Table(name="booked")
public class Booked{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long schno;

    @Column
    private String seatid;


}