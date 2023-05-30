package com.team.thebox.service.admin;

import com.team.thebox.dao.MovieDAO;
import com.team.thebox.domain.Movie;
import com.team.thebox.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AdminMovieService {
    @Autowired
    private MovieDAO movieDAO;

    public boolean saveMovie(Movie movie) {
        boolean result = false;

        if (movieDAO.insertMovie(movie) != null) {
            result = true;
        }
        return result;
    }
}

