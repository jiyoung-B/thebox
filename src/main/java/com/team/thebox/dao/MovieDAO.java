package com.team.thebox.dao;

import com.team.thebox.model.Movie;
import com.team.thebox.model.MovieAttach;
import com.team.thebox.model.MovieSchedule;

import java.util.List;
import java.util.Map;

public interface MovieDAO {


    int insertMovie(Movie movie);
    int insertMovieAttach(MovieAttach pa);

    Movie selectOneMovie(int movno);

    Map<String, Object> selectMovie(int cpg);

    List<String> selectMovieTitle();

    int insertMovieSchedule(MovieSchedule movsch);

    List<Movie> selectMovnoAndTitle();

    List<MovieSchedule> selectMovieSchdule();

    int selectBookedCnt();
}
