package com.team.thebox.repository;

import com.team.thebox.model.MovieList;
import com.team.thebox.model.MovieStillcut;
import com.team.thebox.model.MovieView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieStillcutRepository extends JpaRepository<MovieStillcut, Long> {
    List<MovieList> findAllBy();
    MovieView findAllByMovno(Long movno);



}
