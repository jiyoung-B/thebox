package com.team.thebox.service.admin;

import com.team.thebox.dto.MovieScheduleDTO;
import com.team.thebox.model.MovieSchedule;

import java.util.List;

public interface AMovieScheduleService {

    List<MovieScheduleDTO> readMovieSchedule();

    MovieSchedule getOneMovieScheduleBySchno(Long schno);

    boolean modifyMovieScheduleBySchno(MovieSchedule schedule);

    boolean removeMovieScheduleBySchno(Long schno);
}
