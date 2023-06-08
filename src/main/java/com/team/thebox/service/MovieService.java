package com.team.thebox.service;

import com.team.thebox.model.Movie;
import com.team.thebox.model.MovieReply;

import java.util.List;
import java.util.Map;

public interface MovieService {
    Map<String, Object> readMovie();

    Movie readOneMovie(int movno);


    boolean newReply(MovieReply reply);

    List<MovieReply> readOneMovieReply(int movno);

    boolean modifyReply(MovieReply reply);

    void deleteReply(int rpno);

    //Map<String, Object> readStar();
    Map<String, Object> readStar();

    List<Movielocation> readMovieLocation();
}
