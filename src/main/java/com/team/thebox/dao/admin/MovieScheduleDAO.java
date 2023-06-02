package com.team.thebox.dao.admin;

import com.team.thebox.model.Movie;
import com.team.thebox.model.MovieAttach;
import com.team.thebox.model.MovieSchedule;

import java.util.List;
import java.util.Map;

public interface MovieScheduleDAO {


    List<MovieSchedule> selectMovieSchedule();

    Movie selectMovieTitleByMovno(Long movno);

    int getBookedCount(Long schno);

    MovieSchedule selectOneSchedule(Long schno);

    Long updateMoviesSchedule(MovieSchedule  schedule);
}
