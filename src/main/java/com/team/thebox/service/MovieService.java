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
}
