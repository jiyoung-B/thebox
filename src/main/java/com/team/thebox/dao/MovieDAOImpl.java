package com.team.thebox.dao;

import com.team.thebox.model.Movie;
import com.team.thebox.model.MovieAttach;
import com.team.thebox.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDAOImpl implements MovieDAO {
    @Autowired
    MovieRepository movieRepository;


    public int insertMovie(Movie movie) {

        return Math.toIntExact(movieRepository.save(movie).getMovno());
    }

    @Override
    public int insertMovieAttach(MovieAttach ma) {
        return 0;
    }
}
