package com.team.thebox.model;


import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@ToString
@Getter
@Setter

@NoArgsConstructor
@DynamicUpdate
@Entity
@Table(name="moviestillcut")
public class MovieStillcut{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="stillcuturl")
    private String stillcuturl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movno")
    private Movie movie;

    public MovieStillcut(String stillcuturl) {
        this.stillcuturl = stillcuturl;
    }
}
