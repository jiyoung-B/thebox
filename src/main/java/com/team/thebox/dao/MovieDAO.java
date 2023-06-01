package com.team.thebox.dao;

import com.team.thebox.model.Movie;
import com.team.thebox.model.MovieAttach;
import com.team.thebox.model.MovieReply;
import com.team.thebox.model.MovieSchedule;

import java.util.List;
import java.util.Map;

public interface MovieDAO {


    int insertMovie(Movie movie);
    int insertMovieAttach(MovieAttach pa);

    Movie selectOneMovie(int movno);    // 영화 상세보기

    Map<String, Object> selectMovie(int cpg);

    Map<String, Object> selectMovie(); //now


    int insertMovieReply(MovieReply reply);

    List<MovieReply> selectOneMovieReply(int movno);

    List<String> selectMovieTitle();

    int insertMovieSchedule(MovieSchedule movsch);

    List<Movie> selectMovnoAndTitle();

    List<MovieSchedule> selectMovieSchdule();

    int selectBookedCnt();
}
