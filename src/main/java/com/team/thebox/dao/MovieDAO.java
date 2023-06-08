package com.team.thebox.dao;

import com.team.thebox.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface MovieDAO {


    int insertMovie(Movie movie);
    int insertMovieAttach(MovieAttach pa);

    Movie selectOneMovie(int movno);    // 영화 상세보기

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

    int updateReply(MovieReply reply);

    void deleteReply(int rpno);
    List<Integer> selectBookedCnt();

    Map<String, Object> selectScheduleList(Long movno, Long schno);

    List<Movielocation> selectMovieLocation();

    int insertTicket(Ticketing ticketing);
}
