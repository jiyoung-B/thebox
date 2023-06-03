package com.team.thebox.service.admin;

import com.team.thebox.model.Movie;
import com.team.thebox.model.MovieSchedule;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface AMovieService {
    Map<String, Object> newMovies(Movie movie);
    boolean newMovies2(Movie movie);
    boolean newMovieAttach(MultipartFile attach, Map<String, Object> mvinfo);

    Movie readOneMovie(Long movno);

    Map<String, Object> readMovie(Integer cpg);
    List<String> readMovieTitle(long movno);
    List<Movie> readMovnoAndTitle();

    boolean newMovieSchedule(MovieSchedule movsch);

    List<MovieSchedule> readSchedule();

    List<Integer> readBookedCnt();
    Map<String, Object> readMovieSchedule(Long movno, Long schno);

    Movie getOneMovieByMovno(Long movno);

    boolean modifyMovieByMovno(Movie existingmovie);

    boolean removeMovieByMovno(Long movno);
}
