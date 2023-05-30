package com.team.thebox.dao;

import com.team.thebox.model.Movie;
import com.team.thebox.model.MovieAttach;

import java.util.Map;

public interface MovieDAO {


    int insertMovie(Movie movie);
    int insertMovieAttach(MovieAttach pa);

    Movie selectOneMovie(int mvno);

    Map<String, Object> selectMovie(int cpg);
}
