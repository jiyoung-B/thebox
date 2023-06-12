package com.team.thebox.dao.admin;

import com.team.thebox.model.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AMovieDAO {


    Long insertMovie(Movie movie);
    int insertMovieAttach(MovieAttach pa);

    Object selectOneMovie(Long movno);    // 영화 상세보기
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

    void insertMovieInfo(Movie movie);

    List<Movie> selectAllMovie();

    //void insertMovieStillcuts(List<MovieStillcut> stillcuts);

    Long insertMovieStillcut(MovieStillcut ms);

    List<Movielocation> selectLocation();


    Movielocation selectMovieLocation(Long ciplace);

    Movie getMovieByMovno(Long movno);

    void deleteMovieStillcutsByMovno(Long movno);


    Optional<MovieStillcut> findMovieStillcutById(Long movno);

    void deleteByMovno(Long movno);

    void deleteMovieStillcut(MovieStillcut movieStillcut);

    MovieStillcut saveMovieStillcut(MovieStillcut newMovieStillcut);

    Long updateMovieStillcut(MovieStillcut ms);
}
