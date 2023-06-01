package com.team.thebox.dto;

import com.team.thebox.model.MovieSchedule;
import lombok.*;

import javax.persistence.Column;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieScheduleDTO {
    private Long id;
    private Long schno;
    private String ciplace;
    private String movtitle;
    private String odate;
    private String stime;
    private String etime;
    private int price;
    private int booked;

}
