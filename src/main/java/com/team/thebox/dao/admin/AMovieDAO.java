package com.team.thebox.dao.admin;

import com.team.thebox.model.Movie;
import com.team.thebox.model.MovieAttach;
import com.team.thebox.model.MovieReply;
import com.team.thebox.model.MovieSchedule;

import java.util.List;
import java.util.Map;

public interface AMovieDAO {


    int insertMovie(Movie movie);
    int insertMovieAttach(MovieAttach pa);

    Movie selectOneMovie(Long movno);    // 영화 상세보기
    Long updateMovie(Movie updatemovie);

    Map<String, Object> selectMovie(int cpg);
//
//    List<String> selectMovieTitle(long movno);

    Map<String, Object> selectMovie(); //now


    int insertMovieReply(MovieReply reply);

    List<MovieReply> selectOneMovieReply(int movno);

    List<String> selectMovieTitle();

    int insertMovieSchedule(MovieSchedule movsch);

    List<Movie> selectMovnoAndTitle();

    List<MovieSchedule> selectMovieSchdule();

    List<Integer> selectBookedCnt();

    Map<String, Object> selectScheduleList(Long movno, Long schno);

    void deleteMovieByMovno(Long movno);
}
