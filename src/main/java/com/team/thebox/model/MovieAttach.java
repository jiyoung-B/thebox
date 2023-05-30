package com.team.thebox.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "movieattach")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovieAttach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movano;

    private String fname;
    private String ftype;
    private String fsize;

    @Column(insertable = false, updatable = false)
    private int fdown;

    private Integer movno;
}