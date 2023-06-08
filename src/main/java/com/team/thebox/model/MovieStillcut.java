package com.team.thebox.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String fname;
    private String fsize;
    private Long movno;
    @OneToOne(optional = false)
    @JoinColumn(name="movno", insertable = false, updatable = false)
    private Movie movie;
}
