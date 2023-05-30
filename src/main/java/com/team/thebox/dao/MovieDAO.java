package com.team.thebox.dao;

import com.team.thebox.domain.Movie;
import com.team.thebox.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDAO {
    @Autowired
    private MovieRepository movieRepository;


    public Movie insertMovie(Movie movie) {
        return movieRepository.save(movie);
    }
}
