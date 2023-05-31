package com.team.thebox.service.admin;

import com.team.thebox.model.Movie;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface MovieService {
    Map<String, Object> newMovies(Movie movie);
    boolean newMovies2(Movie movie);
    boolean newMovieAttach(MultipartFile attach, Map<String, Object> mvinfo);

    Movie readOneMovie(int mvno);

    Map<String, Object> readMovie(Integer cpg);
}
