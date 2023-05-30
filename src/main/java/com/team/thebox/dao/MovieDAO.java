package com.team.thebox.dao;

import com.team.thebox.model.Movie;
import com.team.thebox.model.MovieAttach;

public interface MovieDAO {


    int insertMovie(Movie pds);
    int insertMovieAttach(MovieAttach pa);
}
